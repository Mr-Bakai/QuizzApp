package com.hfad.ad4assignment3.ui.adapter
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hfad.quizzapp.ui.fragments.home.HomeFragment

class PagerAdapter(
    private val items: ArrayList<Fragment>,
    fragmentActivity: HomeFragment
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }
}