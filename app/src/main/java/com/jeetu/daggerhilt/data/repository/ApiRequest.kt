package com.jeetu.daggerhilt.data.repository

import com.jeetu.daggerhilt.data.model.Post
import retrofit2.http.GET

interface ApiRequest {
    @GET("posts")
    suspend fun getPost() : List<Post>
}