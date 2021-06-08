package com.hfad.quizzapp.data.repository

import com.hfad.quizzapp.data.api.QuizApi
import com.hfad.quizzapp.data.model.mainModel.MainModel


class MainRepo(private val api: QuizApi) {

    var model: MainModel = MainModel()

    suspend fun getCategory() = api.getCategory()

    suspend fun getQuiz() = api.getQuiz(model.amount, model.category, model.difficulty)
}