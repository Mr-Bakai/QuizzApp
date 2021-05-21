package com.hfad.quizzapp.ui.main

import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.core.ui.base.BaseActivity
import com.hfad.ad4assignment3.ui.adapter.PagerAdapter
import com.hfad.quizzapp.R
import com.hfad.quizzapp.databinding.ActivityMainBinding
import com.hfad.quizzapp.ui.fragments.discover.DiscoverFragment
import com.hfad.quizzapp.ui.fragments.map.MapFragment
import com.hfad.quizzapp.ui.fragments.profile.ProfileFragment

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    ActivityMainBinding::inflate,
    MainViewModel::class.java
) {
    private lateinit var previewMenuItem: MenuItem

    override fun setUpView() {

        val adapter = PagerAdapter(initFragments(), this)
        ui.viewPager.adapter = adapter
        ui.viewPager.isUserInputEnabled = false

        ui.navView.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.main -> ui.viewPager.currentItem = 0
                R.id.map -> ui.viewPager.currentItem = 1
                R.id.profile -> ui.viewPager.currentItem = 2
            }
            true
        }

        ui.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
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
            ui.navView.menu.getItem(position).isChecked = true
        }
        ui.navView.menu.getItem(position).isChecked = true
        previewMenuItem = ui.navView.menu.getItem(position)
    }

    private fun initFragments(): ArrayList<Fragment> {
        return arrayListOf(
            DiscoverFragment.newInstance(),
            MapFragment.newInstance(),
            ProfileFragment.newInstance()
        )
    }
}