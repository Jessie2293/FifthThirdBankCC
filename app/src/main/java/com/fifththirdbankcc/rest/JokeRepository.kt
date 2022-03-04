package com.fifththirdbankcc.rest

import com.fifththirdbankcc.model.JokeCategory
import com.fifththirdbankcc.utils.JokeResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface JokeRepository {
    val dailyJoke: StateFlow<JokeResult>
    suspend fun getDailyJoke(category: JokeCategory)
}

class JokeRepositoryImpl(
    val jokesService: JokeService
) : JokeRepository {

    private val _dailyJokeState: MutableStateFlow<JokeResult> = MutableStateFlow(JokeResult.LOADING)

    override val dailyJoke: StateFlow<JokeResult>
        get() = _dailyJokeState

    override suspend fun getDailyJoke(category: JokeCategory) {
        try {
            val response = jokesService.getDailyJoke(category.cat)

            if (response.isSuccessful) {
                response.body()?.let {
                    _dailyJokeState.value = JokeResult.SUCCESS(it.contents.jokes[0])
                } ?: run {
                    _dailyJokeState.value = JokeResult.ERROR(IllegalStateException("Jokes are coming as null!"))
                }

            } else {
                _dailyJokeState.value = JokeResult.ERROR(Exception(response.errorBody()?.string()))
            }
        } catch (e: Exception) {
            _dailyJokeState.value = JokeResult.ERROR(e)
        }
    }

}