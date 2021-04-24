package com.e.booking_tables

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.if1001.R

class RestaurantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)
        val intent = intent
        val name_lbl: TextView = findViewById(R.id.name_lbl) as TextView
        name_lbl.setOnClickListener {
            name_lbl.text = intent.getStringExtra("restaurantName")
        }
    }
}