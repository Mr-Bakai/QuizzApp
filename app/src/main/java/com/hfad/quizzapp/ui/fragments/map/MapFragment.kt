package com.hfad.quizzapp.ui.fragments.map

import com.example.core.ui.base.BaseFragment
import com.hfad.quizzapp.databinding.FragmentMapBinding

class MapFragment : BaseFragment<FragmentMapBinding, MapViewModel>(
    FragmentMapBinding::inflate,
    MapViewModel::class.java
) {
    override fun setupLiveData() {}
    override fun setupUI() {}

    companion object {
        fun newInstance() = MapFragment()
    }
}