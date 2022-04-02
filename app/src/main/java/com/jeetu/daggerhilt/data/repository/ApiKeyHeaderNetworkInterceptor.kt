package com.jeetu.daggerhilt.data.repository

import android.content.Context
import com.jeetu.daggerhilt.R
import com.jeetu.daggerhilt.utils.isNetworkAvailable
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class ApiKeyHeaderNetworkInterceptor @Inject constructor(@ApplicationContext val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!context.isNetworkAvailable()){
            throw IOException(context.getString(R.string.noInternetConnection))
        }
        val originalRequest = chain.request()
        val newRequestBuilder = originalRequest.newBuilder().apply {
            addHeader("key","value")
            addHeader("key2","value2")
        }.build()
        return chain.proceed(newRequestBuilder)
    }
}