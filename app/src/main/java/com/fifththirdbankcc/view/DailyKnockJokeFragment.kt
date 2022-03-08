package com.fifththirdbankcc.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fifththirdbankcc.databinding.FragmentDailyKnockJokeBinding
import com.fifththirdbankcc.model.JokeCategory
import com.fifththirdbankcc.utils.FragmentName
import com.fifththirdbankcc.utils.JokeResult

class DailyKnockJokeFragment : BaseFragment() {

    private val binding by lazy {
        FragmentDailyKnockJokeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        jokeViewModel.joke.observe(viewLifecycleOwner) { state ->
            when (state) {
                is JokeResult.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is JokeResult.SUCCESS -> {
                    binding.tvJokeTitle.text = state.data.joke.title
                    binding.tvJoke.text = state.data.joke.text
                    binding.progressBar.visibility = View.GONE
                }
                is JokeResult.ERROR -> {
                    binding.progressBar.visibility = View.GONE

                    showErrorDialog(state.error, FragmentName.KNOCK) {
                        jokeViewModel.subscribeToDailyJoke(JokeCategory.KNOCK)
                    }
                }
            }
        }

        jokeViewModel.subscribeToDailyJoke(JokeCategory.KNOCK)

        return binding.root
    }
}