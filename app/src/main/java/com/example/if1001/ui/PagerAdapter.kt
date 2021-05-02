package com.example.if1001.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.if1001.ui.fragments.AboutFragment
import com.example.if1001.ui.fragments.MenuFragment
import com.example.if1001.ui.fragments.ReviewFragment

class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    var menuFragment = MenuFragment()
    var reviewFragment = ReviewFragment()
    var aboutFragment = AboutFragment()

    // Returns the number of pages. We can return an constant number if we know how many tabs we have
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                menuFragment
            }
            1 -> {
                reviewFragment
            }
            else -> {
                return aboutFragment
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> {
                "Menu"
            }
            1 -> {
                "Review"
            }
            else -> {
                return "About"
            }
        }
    }
}