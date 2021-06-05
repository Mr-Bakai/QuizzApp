package com.hfad.quizzapp.ui.fragments.discover

import androidx.lifecycle.viewModelScope
import com.example.core.ui.base.BaseViewModel
import com.hfad.quizzapp.data.repository.MainRepo
import kotlinx.coroutines.launch

class DiscoverViewModel(private val repo: MainRepo) : BaseViewModel() {


    fun getCategory(){
        viewModelScope.launch {
             repo.getCategory()
        }
    }
}