package com.hfad.quizzapp.ui.adapter
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hfad.quizzapp.core.ui.base.BaseFragment
import com.hfad.quizzapp.ui.fragments.home.HomeFragment

class PagerAdapter(
    private val items: ArrayList<Fragment>,
    fragmentActivity: Fragment
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }
}