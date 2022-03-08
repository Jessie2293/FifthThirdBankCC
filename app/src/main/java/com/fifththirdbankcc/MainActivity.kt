package com.fifththirdbankcc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fifththirdbankcc.databinding.ActivityMainBinding
import com.fifththirdbankcc.view.DailyAnimalJokeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}