package com.geeks.pizza;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.geeks.pizza.adapter.BurgersAdapter;
import com.geeks.pizza.adapter.FoodAdapter;
import com.geeks.pizza.databinding.ActivityMenuBinding;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements OnItemRecyclerViewClickListener {
    ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String url = "https://cdn.vox-cdn.com/thumbor/fHO4vVH9RErPIIMT5MOUvXiCwao=/0x0:5568x3712/1200x800/filters:focal(2092x831:2982x1721)/cdn.vox-cdn.com/uploads/chorus_image/image/64665883/667326876.jpg.0.jpg";
        Glide.with(this)
                .load(url)
                .circleCrop()
                .placeholder(R.color.milk)
                .into(binding.avatarImage);

        Food food1 = new Food("Burgers", R.drawable.burger_svg);
        Food food2 = new Food("Pizza", R.drawable.pizza_svg);
        Food food3 = new Food("Chickens", R.drawable.chicken_svg);
        Food food4 = new Food("Sushi", R.drawable.sushi_svg);
        Food food5 = new Food("Drinks", R.drawable.drinks_svg);
        Food food6 = new Food("Deserts", R.drawable.desert_svg);

        ArrayList<Food> foodsList = new ArrayList<>();
        foodsList.add(food1);
        foodsList.add(food2);
        foodsList.add(food3);
        foodsList.add(food4);
        foodsList.add(food5);
        foodsList.add(food6);

        FoodAdapter foodAdapter = new FoodAdapter(foodsList, this);
        binding.recyclerView.setAdapter(foodAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Burgers burger1 = new Burgers("Burger", R.drawable.burger1);
        Burgers burger2 = new Burgers("Cheese Burger", R.drawable.cheeseburger);
        Burgers burger3 = new Burgers("Burger3", R.drawable.burger1);
        Burgers burger4 = new Burgers("Crabs Burger", R.drawable.crabs);
        Burgers burger5 = new Burgers("Burger4", R.drawable.burger1);
        Burgers burger6 = new Burgers("Burger5", R.drawable.burger5);

        ArrayList<Burgers> burgersList = new ArrayList<>();
        burgersList.add(burger1);
        burgersList.add(burger2);
        burgersList.add(burger3);
        burgersList.add(burger4);
        burgersList.add(burger5);
        burgersList.add(burger6);

        BurgersAdapter burgersAdapter = new BurgersAdapter(burgersList);
        binding.recyclerViewBurger.setAdapter(burgersAdapter);
        binding.recyclerViewBurger.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        binding.recyclerViewBurger.setVisibility(View.GONE);

    }

    public void onFoodClick(Food food, int position) {
        if (position == 0) {
            binding.recyclerViewBurger.setVisibility(View.VISIBLE);
        } else {
            binding.recyclerViewBurger.setVisibility(View.GONE);
        }

    }


}
