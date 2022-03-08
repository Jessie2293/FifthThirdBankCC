package com.fifththirdbankcc.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.fifththirdbankcc.R
import com.fifththirdbankcc.databinding.FragmentDailyAnimalJokeBinding
import com.fifththirdbankcc.databinding.FragmentWelcomePageBinding


class WelcomePageFragment : Fragment() {

    private val binding by lazy {
        FragmentWelcomePageBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnJod.setOnClickListener {
            findNavController().navigate(WelcomePageFragmentDirections
                .actionWelcomePageFragmentToJokeOfDayFragment())
        }

        binding.btnAnimal.setOnClickListener {
            findNavController().navigate(WelcomePageFragmentDirections
                .actionWelcomePageFragmentToDailyAnimalJokeFragment())
        }

        binding.btnBlonde.setOnClickListener {
            findNavController().navigate(WelcomePageFragmentDirections
                .actionWelcomePageFragmentToDailyBlondeJokeFragment())
        }

        binding.btnKnock.setOnClickListener {
            findNavController().navigate(WelcomePageFragmentDirections
                .actionWelcomePageFragmentToDailyKnockJokeFragment())
        }


    }
}

