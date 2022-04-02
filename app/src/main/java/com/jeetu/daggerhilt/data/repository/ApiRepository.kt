package com.jeetu.daggerhilt.data.repository

import javax.inject.Inject

class ApiRepository @Inject constructor(val apiRequest: ApiRequest) {
    suspend fun getPost() = apiRequest.getPost()
}