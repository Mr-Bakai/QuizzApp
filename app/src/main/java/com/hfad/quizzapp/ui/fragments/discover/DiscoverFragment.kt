package com.hfad.quizzapp.ui.fragments.discover

import androidx.navigation.fragment.findNavController
import com.example.core.ui.base.BaseFragment
import com.hfad.quizzapp.R
import com.hfad.quizzapp.databinding.FragmentDiscoverBinding

class DiscoverFragment : BaseFragment<FragmentDiscoverBinding, DiscoverViewModel>(
    FragmentDiscoverBinding::inflate,
    DiscoverViewModel::class.java
) {

    override fun setupLiveData() {}
    override fun setupUI() {

        binding.startBtn.setOnClickListener{
            findNavController().navigate(R.id.quizFragment)
        }
    }

    companion object {
        fun newInstance() = DiscoverFragment()
    }
}