package com.geeks.pizza

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.geeks.pizza.adapter.BurgersAdapter
import com.geeks.pizza.adapter.FoodAdapter
import com.geeks.pizza.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity(), OnItemRecyclerViewClickListener {
    var binding: ActivityMenuBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val url =
            "https://cdn.vox-cdn.com/thumbor/fHO4vVH9RErPIIMT5MOUvXiCwao=/0x0:5568x3712/1200x800/filters:focal(2092x831:2982x1721)/cdn.vox-cdn.com/uploads/chorus_image/image/64665883/667326876.jpg.0.jpg"
        Glide.with(this)
            .load(url)
            .circleCrop()
            .placeholder(R.color.milk)
            .into(binding!!.avatarImage)

        val food1 = Food("Burgers", R.drawable.burger_svg)
        val food2 = Food("Pizza", R.drawable.pizza_svg)
        val food3 = Food("Chickens", R.drawable.chicken_svg)
        val food4 = Food("Sushi", R.drawable.sushi_svg)
        val food5 = Food("Drinks", R.drawable.drinks_svg)
        val food6 = Food("Deserts", R.drawable.desert_svg)

        val foodsList = ArrayList<Food>()
        foodsList.add(food1)
        foodsList.add(food2)
        foodsList.add(food3)
        foodsList.add(food4)
        foodsList.add(food5)
        foodsList.add(food6)

        val foodAdapter = FoodAdapter(foodsList, this)
        binding!!.recyclerView.adapter = foodAdapter
        binding!!.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val burger1 = Burgers("Burger", R.drawable.burger1)
        val burger2 = Burgers("Cheese Burger", R.drawable.cheeseburger)
        val burger3 = Burgers("Burger3", R.drawable.burger1)
        val burger4 = Burgers("Crabs Burger", R.drawable.crabs)
        val burger5 = Burgers("Burger4", R.drawable.burger1)
        val burger6 = Burgers("Burger5", R.drawable.burger5)

        val burgersList = ArrayList<Burgers>()
        burgersList.add(burger1)
        burgersList.add(burger2)
        burgersList.add(burger3)
        burgersList.add(burger4)
        burgersList.add(burger5)
        burgersList.add(burger6)

        val burgersAdapter = BurgersAdapter(burgersList)
        binding!!.recyclerViewBurger.adapter = burgersAdapter
        binding!!.recyclerViewBurger.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding!!.recyclerViewBurger.visibility = View.GONE
    }



    override fun onFoodClick(food: Food?, position: Int) {
        if (position == 0) {
            binding!!.recyclerViewBurger.visibility = View.VISIBLE
        } else {
            binding!!.recyclerViewBurger.visibility = View.GONE
        }
    }
}
