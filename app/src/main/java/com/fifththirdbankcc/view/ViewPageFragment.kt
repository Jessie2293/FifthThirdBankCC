package com.fifththirdbankcc.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fifththirdbankcc.R

val jokeArray = arrayOf(
    "J.O.T.D",
    "Animal",
    "Blonde",
    "Knock-Knock"
)

class ViewPageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_page, container, false)


    }
}