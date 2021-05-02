package com.example.if1001.ui.fragments


import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.if1001.models.DishModel
import com.example.if1001.ui.MenuAdapter
import com.example.if1001.R
import com.example.if1001.firebase.FirebaseManager
import kotlinx.android.synthetic.main.fragment_about.view.*

/**
 * A simple [Fragment] subclass.
 *
 */
class MenuFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_menu, container, false)
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.menu_recycler_view)
        val layoutManager = LinearLayoutManager(this.context)
        val firebaseManager = FirebaseManager()
        val restaurants = firebaseManager.loadDatabase()
        for(e in restaurants){
            if(activity?.title.toString() == e.name){
                recyclerView.adapter = MenuAdapter(e.menu, this.context!!)
            }
        }
        recyclerView.layoutManager = layoutManager

        return rootView
    }


}