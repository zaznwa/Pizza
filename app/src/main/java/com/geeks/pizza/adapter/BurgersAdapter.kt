package com.geeks.pizza.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.geeks.pizza.Burgers
import com.geeks.pizza.R
import com.geeks.pizza.adapter.BurgersAdapter.BurgersViewHolder
import com.geeks.pizza.databinding.ItemBurgersBinding

class BurgersAdapter(private val list: ArrayList<Burgers>) :
    RecyclerView.Adapter<BurgersViewHolder>() {
    private var selectedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BurgersViewHolder {
        val binding = ItemBurgersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BurgersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BurgersViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class BurgersViewHolder(var binding: ItemBurgersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(burgers: Burgers, position: Int) {
            binding.burgerImg.setImageResource(burgers.burgerImg)
            binding.burgerTxt.setText(burgers.burgerName)

            if (position == selectedPosition) {
                binding.burgerTxt.setTextColor(
                    ContextCompat.getColor(
                        binding.burgerContainer.context,
                        R.color.white
                    )
                )
                binding.burgerContainer.setBackgroundColor(
                    ContextCompat.getColor(
                        binding.burgerContainer.context,
                        R.color.light_red
                    )
                )
            } else {
                binding.burgerTxt.setTextColor(
                    ContextCompat.getColor(
                        binding.burgerContainer.context,
                        R.color.gray
                    )
                )
                binding.burgerContainer.setBackgroundColor(
                    ContextCompat.getColor(
                        binding.burgerContainer.context,
                        R.color.white
                    )
                )
            }

            binding.burgerContainer.setOnClickListener { v: View? ->
                selectedPosition = position
                notifyDataSetChanged()
            }
        }
    }
}
