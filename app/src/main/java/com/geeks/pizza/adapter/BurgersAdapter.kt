package com.geeks.pizza.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.geeks.pizza.Burgers;
import com.geeks.pizza.R;
import com.geeks.pizza.databinding.ItemBurgersBinding;

import java.util.ArrayList;

public class BurgersAdapter extends RecyclerView.Adapter<BurgersAdapter.BurgersViewHolder> {
    private ArrayList<Burgers> list;
    private int selectedPosition = -1;

    public BurgersAdapter(ArrayList<Burgers> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public BurgersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBurgersBinding binding = ItemBurgersBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BurgersViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BurgersViewHolder holder, int position) {
        holder.bind(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BurgersViewHolder extends RecyclerView.ViewHolder {
        ItemBurgersBinding binding;

        public BurgersViewHolder(ItemBurgersBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Burgers burgers, int position) {
            binding.burgerImg.setImageResource(burgers.getBurgerImg());
            binding.burgerTxt.setText(burgers.getBurgerName());

            if (position == selectedPosition) {
                binding.burgerTxt.setTextColor(ContextCompat.getColor(binding.burgerContainer.getContext(), R.color.white));
                binding.burgerContainer.setBackgroundColor(ContextCompat.getColor(binding.burgerContainer.getContext(), R.color.light_red));
            } else {
                binding.burgerTxt.setTextColor(ContextCompat.getColor(binding.burgerContainer.getContext(), R.color.gray));
                binding.burgerContainer.setBackgroundColor(ContextCompat.getColor(binding.burgerContainer.getContext(), R.color.white));
            }

            binding.burgerContainer.setOnClickListener(v -> {
                selectedPosition = position;
                notifyDataSetChanged();
            });
        }
    }
}
