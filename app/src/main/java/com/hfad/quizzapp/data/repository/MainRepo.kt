package com.hfad.quizzapp.data.repository
import com.hfad.quizzapp.data.api.QuizApi
import retrofit2.Response


class MainRepo(private val api: QuizApi) {

    suspend fun getQuiz(amount: Int): Response<Any>? {
        return try {
            api.getQuiz(amount)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun getCategory() = api.getCategory()

}