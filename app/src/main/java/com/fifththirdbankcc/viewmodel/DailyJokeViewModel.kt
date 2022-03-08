package com.fifththirdbankcc.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fifththirdbankcc.model.JokeCategory
import com.fifththirdbankcc.rest.JokeRepository
import com.fifththirdbankcc.utils.JokeResult
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

class DailyJokeViewModel(
    val jokeRepository: JokeRepository,
    val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    val coroutineScope: CoroutineScope = CoroutineScope(SupervisorJob() + ioDispatcher)
) : ViewModel(), CoroutineScope by coroutineScope {

    private var _jokeLivedata: MutableLiveData<JokeResult> = MutableLiveData(JokeResult.LOADING)
    val joke: LiveData<JokeResult> get() = _jokeLivedata

    fun subscribeToDailyJoke(category: JokeCategory) {
        _jokeLivedata.postValue(JokeResult.LOADING)

        collectJoke()

        launch {
            jokeRepository.getDailyJoke(category)
        }

    }

    private fun collectJoke() {
        launch {
            jokeRepository.dailyJoke.collect { state ->
                when (state) {
                    is JokeResult.LOADING -> { _jokeLivedata.postValue(state) }
                    is JokeResult.SUCCESS -> { _jokeLivedata.postValue(state) }
                    is JokeResult.ERROR -> { _jokeLivedata.postValue(state) }
                }
            }
        }
    }

    fun reset() {
        jokeRepository.resetState()
        _jokeLivedata.postValue(JokeResult.LOADING)
    }
}