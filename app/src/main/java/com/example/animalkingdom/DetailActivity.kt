package com.example.animalkingdom

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animalkingdom.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data passed from MainActivity
        val animalName = intent.getStringExtra("ANIMAL_NAME")
        val animalImageResId = intent.getIntExtra("ANIMAL_IMAGE", -1)

        // Display data
        binding.animalName.text = animalName
        if (animalImageResId != -1) {
            binding.animalImage.setImageResource(animalImageResId)
        }
        binding.arrow.setOnClickListener {
           val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

}
