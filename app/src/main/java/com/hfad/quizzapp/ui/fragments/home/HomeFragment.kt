package com.hfad.quizzapp.ui.fragments.home
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.core.ui.base.BaseFragment
import com.hfad.ad4assignment3.ui.adapter.PagerAdapter
import com.hfad.quizzapp.R
import com.hfad.quizzapp.databinding.HomeFragmentBinding
import com.hfad.quizzapp.ui.fragments.discover.DiscoverFragment
import com.hfad.quizzapp.ui.fragments.map.MapFragment
import com.hfad.quizzapp.ui.fragments.profile.ProfileFragment

class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>(
    HomeFragmentBinding::inflate,
    HomeViewModel::class.java
) {

    private lateinit var previewMenuItem: MenuItem
    override fun setupLiveData() {
    }

    override fun setupUI() {

        val adapter = PagerAdapter(initFragments(), this)
        binding.viewPager.adapter = adapter
        binding.viewPager.isUserInputEnabled = false

        binding.navView.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.main -> binding.viewPager.currentItem = 0
                R.id.map -> binding.viewPager.currentItem = 1
                R.id.profile -> binding.viewPager.currentItem = 2
            }
            true
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                onPageSelectedF(position)
            }
        })
    }

    private fun onPageSelectedF(position: Int) {
        if (::previewMenuItem.isInitialized) {
            previewMenuItem.isChecked = true
        } else {
            binding.navView.menu.getItem(position).isChecked = true
        }
        binding.navView.menu.getItem(position).isChecked = true
        previewMenuItem = binding.navView.menu.getItem(position)
    }

    private fun initFragments(): ArrayList<Fragment> {
        return arrayListOf(
            DiscoverFragment.newInstance(),
            MapFragment.newInstance(),
            ProfileFragment.newInstance()
        )
    }
}