package com.hfad.quizzapp.ui.fragments.profile

import com.example.core.ui.base.BaseFragment
import com.hfad.quizzapp.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>(
    FragmentProfileBinding::inflate,
    ProfileViewModel::class.java
) {

    override fun setupLiveData() {}
    override fun setupUI() {}

    companion object {
        fun newInstance() = ProfileFragment()
    }
}