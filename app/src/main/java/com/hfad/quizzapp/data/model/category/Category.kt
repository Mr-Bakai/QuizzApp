package com.example.example

import com.google.gson.annotations.SerializedName

   
data class Category (

   @SerializedName("trivia_categories") var triviaCategories : List<TriviaCategories>

)


data class TriviaCategories (

   @SerializedName("id") var id : Int,
   @SerializedName("name") var name : String

)