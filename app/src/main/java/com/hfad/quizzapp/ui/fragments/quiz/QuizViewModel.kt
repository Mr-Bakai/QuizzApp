package com.hfad.quizzapp.ui.fragments.quiz

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.ui.base.BaseViewModel
import com.hfad.quizzapp.data.model.quizModel.QuizModel
import com.hfad.quizzapp.data.repository.MainRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class QuizViewModel(private val repo: MainRepo) : BaseViewModel() {

    var quizLiveData = MutableLiveData<Response<QuizModel>>()

    fun getQuiz() {
        viewModelScope.launch {
            quizLiveData.value = repo.getQuiz()
        }
    }
}