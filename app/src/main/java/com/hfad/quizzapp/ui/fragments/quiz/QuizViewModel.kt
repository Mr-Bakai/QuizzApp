package com.hfad.quizzapp.ui.fragments.quiz

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.core.ui.base.BaseViewModel
import com.hfad.quizzapp.data.repository.MainRepo
import kotlinx.coroutines.launch

class QuizViewModel(private val repo: MainRepo) : BaseViewModel() {

    fun getQuiz(amount: Int){
        viewModelScope.launch {
            Log.e("QUIZ",repo.getQuiz(amount)!!.body().toString())
        }
    }
}