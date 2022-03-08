package com.fifththirdbankcc.view

import android.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fifththirdbankcc.utils.FragmentName
import com.fifththirdbankcc.viewmodel.DailyJokeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

open class BaseFragment : Fragment() {

    protected val jokeViewModel: DailyJokeViewModel by viewModel()

    fun showErrorDialog(error: Throwable, fragmentName: FragmentName, retryAction: () -> Unit) {
        AlertDialog.Builder(requireContext())
            .setTitle("AN ERROR HAPPENED")
            .setMessage("Sorry, we got an error, we are working on it. ${error.localizedMessage}")
            .setCancelable(true)
            .setPositiveButton("RETRY") { dialogInterface, i ->
                retryAction.invoke()
            }
            .setNegativeButton("DISMISS") { dialogInterface, i ->
                dialogInterface.dismiss()
                when (fragmentName) {
                    FragmentName.DAY -> {
                        findNavController().navigate(
                            JokeOfDayFragmentDirections.actionJokeOfDayFragmentToWelcomePageFragment())
                    }
                    FragmentName.ANIMAL -> {
                        findNavController().navigate(
                            DailyAnimalJokeFragmentDirections.actionAnimalJokeFragmentToWelcomePageFragment())
                    }
                    FragmentName.KNOCK -> {
                        findNavController().navigate(
                            DailyKnockJokeFragmentDirections.actionDailyKnockJokeFragmentToWelcomePageFragment())
                    }
                    FragmentName.BLONDE -> {
                        findNavController().navigate(
                            DailyBlondeJokeFragmentDirections.actionDailyBlondeJokeFragmentToWelcomePageFragment())
                    }
                }
            }
            .show()
    }

    override fun onStop() {
        super.onStop()
        jokeViewModel.reset()
        jokeViewModel.joke.removeObservers(viewLifecycleOwner)
    }
}