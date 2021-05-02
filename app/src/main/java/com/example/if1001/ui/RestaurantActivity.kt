package com.example.if1001.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.if1001.R
import kotlinx.android.synthetic.main.activity_restaurant.*

class RestaurantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)
        val intent = intent
        val fragmentAdapter = PagerAdapter(supportFragmentManager)
        val nameLbl: TextView = findViewById<TextView>(R.id.name_lbl)
        val addressLabel: TextView = findViewById<TextView>(R.id.address_label)
        val ratingLabel: TextView = findViewById<TextView>(R.id.rating_label)

        view_pager_restaurant.adapter = fragmentAdapter

        tabs_restaurant.setupWithViewPager(view_pager_restaurant)

        nameLbl.text = intent.extras?.get("restaurantName").toString()
        addressLabel.text = intent.extras?.get("restaurantAddress").toString()
        ratingLabel.text = intent.extras?.get("restaurantRating").toString()


        this.title = intent.extras?.get("restaurantName").toString()
    }
}