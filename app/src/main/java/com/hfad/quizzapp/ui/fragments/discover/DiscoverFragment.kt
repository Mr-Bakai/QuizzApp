package com.hfad.quizzapp.ui.fragments.discover

import com.example.core.ui.base.BaseFragment
import com.hfad.quizzapp.databinding.FragmentDiscoverBinding

class DiscoverFragment : BaseFragment<FragmentDiscoverBinding, DiscoverViewModel>(
    FragmentDiscoverBinding::inflate,
    DiscoverViewModel::class.java
) {

    override fun setupLiveData() {}
    override fun setupUI() {}

    companion object {
        fun newInstance() = DiscoverFragment()
    }
}