package com.fifththirdbankcc.view

import android.app.AlertDialog
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    fun showErrorDialog(error: Throwable, retryAction: () -> Unit) {
        AlertDialog.Builder(requireContext())
            .setTitle("AN ERROR HAPPENED")
            .setMessage("Sorry, we got an error, we are working on it. ${error.localizedMessage}")
            .setPositiveButton("RETRY") { dialogInterface, i ->
                retryAction.invoke()
            }
            .setNegativeButton("DISMISS") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
            .show()
    }
}