package com.example.if1001.ui.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.if1001.R
import com.example.if1001.firebase.FirebaseManager
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_about.view.*


class AboutFragment : Fragment() {
    /*companion object {
        fun newInstance(about: String): AboutFragment {
            val fragment = AboutFragment()
            val args = Bundle()
            args.putString("restaurantAbout", about)
            fragment.arguments = args
            return fragment
        }
    }*/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_about, container, false)
        val firebaseManager = FirebaseManager()
        val restaurants = firebaseManager.loadDatabase()
        for(e in restaurants){
            if(activity?.title.toString() == e.name){
                rootView.about_lbl.text = e.about
            }
        }
        return rootView
    }

}