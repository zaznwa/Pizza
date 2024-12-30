package com.geeks.pizza.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.geeks.pizza.Food;
import com.geeks.pizza.OnItemRecyclerViewClickListener;
import com.geeks.pizza.R;
import com.geeks.pizza.databinding.ItemMenuBinding;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private ArrayList<Food> list;
    private OnItemRecyclerViewClickListener onItemRecyclerViewClickListener;
    private int selectedPosition = -1;

    public FoodAdapter(ArrayList<Food> list, OnItemRecyclerViewClickListener listener) {
        this.list = list;
        this.onItemRecyclerViewClickListener = listener;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMenuBinding binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FoodViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.bind(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        ItemMenuBinding binding;

        public FoodViewHolder(ItemMenuBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Food food, int position) {
            binding.menuTxt.setText(food.getFoodName());
            binding.imageView.setImageResource(food.getFoodImg());

            if (position == selectedPosition) {
                binding.menuTxt.setTextColor(ContextCompat.getColor(binding.menuContainer.getContext(), R.color.white));
                binding.menuContainer.setBackgroundColor(ContextCompat.getColor(binding.menuContainer.getContext(), R.color.light_red));
            } else {
                binding.menuTxt.setTextColor(ContextCompat.getColor(binding.menuContainer.getContext(), R.color.gray));
                binding.menuContainer.setBackgroundColor(ContextCompat.getColor(binding.menuContainer.getContext(), R.color.white));
                binding.imageView.setImageResource(food.getFoodImg());
            }

            binding.menuContainer.setOnClickListener(v -> {

                if (onItemRecyclerViewClickListener != null) {
                    onItemRecyclerViewClickListener.onFoodClick(food, getAdapterPosition());
                }
                selectedPosition = position;
                notifyDataSetChanged();
            });

        }
    }
}

