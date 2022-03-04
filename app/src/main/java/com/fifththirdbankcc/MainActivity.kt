package com.fifththirdbankcc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fifththirdbankcc.databinding.ActivityMainBinding
import com.fifththirdbankcc.view.DailyAnimalJokeFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.frag_container, DailyAnimalJokeFragment.newInstance())
            .commit()
    }
}