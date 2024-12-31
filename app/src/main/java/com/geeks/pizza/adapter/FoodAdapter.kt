package com.geeks.pizza.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.geeks.pizza.Food
import com.geeks.pizza.OnItemRecyclerViewClickListener
import com.geeks.pizza.R
import com.geeks.pizza.adapter.FoodAdapter.FoodViewHolder
import com.geeks.pizza.databinding.ItemMenuBinding

class FoodAdapter(
    private val list: ArrayList<Food>,
    private val onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener?
) :
    RecyclerView.Adapter<FoodViewHolder>() {
    private var selectedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class FoodViewHolder(var binding: ItemMenuBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(food: Food, position: Int) {
            binding.menuTxt.setText(food.foodName)
            binding.imageView.setImageResource(food.foodImg)

            if (position == selectedPosition) {
                binding.menuTxt.setTextColor(
                    ContextCompat.getColor(
                        binding.menuContainer.context,
                        R.color.white
                    )
                )
                binding.menuContainer.setBackgroundColor(
                    ContextCompat.getColor(
                        binding.menuContainer.context,
                        R.color.light_red
                    )
                )
            } else {
                binding.menuTxt.setTextColor(
                    ContextCompat.getColor(
                        binding.menuContainer.context,
                        R.color.gray
                    )
                )
                binding.menuContainer.setBackgroundColor(
                    ContextCompat.getColor(
                        binding.menuContainer.context,
                        R.color.white
                    )
                )
                binding.imageView.setImageResource(food.foodImg)
            }

            binding.menuContainer.setOnClickListener { v: View? ->
                onItemRecyclerViewClickListener?.onFoodClick(food, adapterPosition)
                selectedPosition = position
                notifyDataSetChanged()
            }
        }
    }
}

