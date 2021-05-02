package com.example.if1001.ui.fragments


import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.if1001.models.RatingModel
import com.example.if1001.ui.RatingAdapter
import com.example.if1001.R
import com.example.if1001.firebase.FirebaseManager

/**
 * A simple [Fragment] subclass.
 *
 */
class ReviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView =  inflater.inflate(R.layout.fragment_review, container, false)
        var recyclerView = rootView.findViewById<RecyclerView>(R.id.review_recycler_view)
        val layoutManager = LinearLayoutManager(this.context)
        val firebaseManager = FirebaseManager()
        val restaurants = firebaseManager.loadDatabase()
        for(e in restaurants){
            if(activity?.title.toString() == e.name){
                recyclerView.adapter = RatingAdapter(e.rating, this.context!!)
            }
        }
        recyclerView.layoutManager = layoutManager
        return rootView
    }


}