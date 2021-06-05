package com.hfad.quizzapp.data.api

import com.hfad.quizzapp.data.model.Quiz
import retrofit2.Response
import retrofit2.http.*

interface QuizApi {

    @GET("api.php")
    suspend fun getQuiz(
        @Query("amount") amount:Int
    ):Response<Any>


     @GET("api_category.php")
    suspend fun getCategory(
    ):Response<Any>


    @FormUrlEncoded
    @POST("create.php")
    fun createQuiz(
            @Field("category") category:String,
            @Field("type") type:String
    )

    @POST("create.php")
    fun createQuiz(
            @Body quiz: Quiz
    )

    @GET("user/post/{id}/")
    fun getPost(
            @Path("id") id:Int,
            @Query("amount") amount:Int
    )
}