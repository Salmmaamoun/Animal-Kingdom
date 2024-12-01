package com.example.animalkingdom

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animalkingdom.adapter.AnimalAdapter
import com.example.animalkingdom.data.AnimalData
import com.example.animalkingdom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animals = AnimalData.getAnimals()

        val adapter = AnimalAdapter(animals) { animal ->
            // On animal click, navigate to DetailActivity
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("ANIMAL_NAME", animal.description)
            intent.putExtra("ANIMAL_IMAGE", animal.imageResId)
            startActivity(intent)
        }
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null!!
    }

}

