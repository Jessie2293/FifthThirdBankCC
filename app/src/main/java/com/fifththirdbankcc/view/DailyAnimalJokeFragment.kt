package com.fifththirdbankcc.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fifththirdbankcc.R
import com.fifththirdbankcc.databinding.FragmentDailyAnimalJokeBinding
import com.fifththirdbankcc.model.JokeCategory
import com.fifththirdbankcc.utils.JokeResult
import com.fifththirdbankcc.viewmodel.DailyJokeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DailyAnimalJokeFragment : Fragment() {

    private val binding by lazy {
        FragmentDailyAnimalJokeBinding.inflate(layoutInflater)
    }

    private val jokeViewModel: DailyJokeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        jokeViewModel.joke.observe(viewLifecycleOwner) { state ->
            when (state) {
                is JokeResult.LOADING -> {
                    // TODO show a loading spinner screen
                }
                is JokeResult.SUCCESS -> {
                    // TODO display the joke in fragment
                    Log.d(TAG, state.data.joke.text)
                }
                is JokeResult.ERROR -> {
                    // TODO display error dialog
                    Log.e(TAG, state.error.localizedMessage, state.error)
                }
            }
        }

        jokeViewModel.subscribeToDailyJoke(JokeCategory.ANIMAL)

        return binding.root
    }

    companion object {
        private const val TAG = "AnimalJoke"
        fun newInstance() = DailyAnimalJokeFragment()
    }
}