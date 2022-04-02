package com.jeetu.apparchitectwithdaggerhilt.data.repository

import com.jeetu.apparchitectwithdaggerhilt.data.model.Post
import retrofit2.http.GET

interface ApiRequest {
    @GET("posts")
    suspend fun getPost() : List<Post>
}