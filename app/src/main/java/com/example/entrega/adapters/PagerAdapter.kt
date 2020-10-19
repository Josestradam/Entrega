package com.example.entrega.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter (fm:FragmentManager)
    :FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val listFragments = ArrayList<Fragment>()

    override fun getCount() = listFragments.size
    override fun getItem(position: Int) = listFragments[position]
    fun addFrag(f: Fragment) = listFragments.add(f)

}