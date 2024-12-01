package com.example.animalkingdom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animalkingdom.databinding.ItemAnimalBinding
import com.example.animalkingdom.model.Animal

class AnimalAdapter(
    private val animals: List<Animal>,
    private val onClick: (Animal) -> Unit // Pass a click listener as a lambda
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(
        private val binding: ItemAnimalBinding,
        private val onClick: (Animal) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(animal: Animal) {
            binding.animalName.text = animal.name
            binding.animalImage.setImageResource(animal.imageResId)

            // Handle item clicks
            binding.root.setOnClickListener {
                onClick(animal)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(animals[position])
    }

    override fun getItemCount(): Int = animals.size
}
