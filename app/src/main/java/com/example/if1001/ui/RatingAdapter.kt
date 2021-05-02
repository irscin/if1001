package com.example.if1001.ui

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.if1001.models.RatingModel
import com.example.if1001.R
import kotlinx.android.synthetic.main.rating_layout_holder.view.*

class RatingAdapter(private val rates : ArrayList<RatingModel>,
                    private val context : Context) : RecyclerView.Adapter<RatingAdapter.ViewHolder>(){

    override fun getItemCount(): Int {
        return rates.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rating = rates[position]
        holder.ratingComment.text = rating.comment

        for(star in 0 until rating.rating.toInt()) {
            holder.stars[star].setImageResource(android.R.drawable.star_on)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rating_layout_holder, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val ratingComment : TextView = itemView.rating_comment_lbl
        val stars = arrayListOf<ImageView>(
            itemView.rating_star_1,
            itemView.rating_star_2,
            itemView.rating_star_3,
            itemView.rating_star_4,
            itemView.rating_star_5
        )
    }

}