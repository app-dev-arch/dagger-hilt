package com.jeetu.daggerhilt.di

import android.content.Context
import androidx.databinding.library.BuildConfig
import com.jeetu.daggerhilt.data.repository.ApiKeyHeaderNetworkInterceptor
import com.jeetu.daggerhilt.data.repository.ApiRequest
import com.jeetu.daggerhilt.utils.NetworkConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    @Named("base_url")
    fun getBaseUrl() : String = NetworkConstant.BASE_URL

    @Singleton
    @Provides
    fun getHttpLoggingInterceptor() : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG){ HttpLoggingInterceptor.Level.BODY } else { HttpLoggingInterceptor.Level.NONE }
    }

    @Singleton
    @Provides
    fun getApiKeyHeaderNetworkIntercepter(@ApplicationContext context: Context) : ApiKeyHeaderNetworkInterceptor = ApiKeyHeaderNetworkInterceptor(context)

    @Singleton
    @Provides
    fun getOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, apiKeyHeaderNetworkInterceptor: ApiKeyHeaderNetworkInterceptor) : OkHttpClient =
        OkHttpClient.Builder().apply {
            addInterceptor(httpLoggingInterceptor)
            addInterceptor(apiKeyHeaderNetworkInterceptor)
            connectTimeout(30L,TimeUnit.SECONDS)
            readTimeout(30L,TimeUnit.SECONDS)
        }.build()

    @Singleton
    @Provides
    fun getRetrofit(@Named("base_url") baseUrl : String, okHttpClient: OkHttpClient) : Retrofit =
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()

    @Singleton
    @Provides
    fun getApiRequest(retrofit: Retrofit) : ApiRequest = retrofit.create(ApiRequest::class.java)

    /*@Singleton
    @Provides
    fun getApiRepository(apiRequest: ApiRequest) : ApiRepository = ApiRepository(apiRequest)*/
    //note above api repository comment bcos ApiRepository is created by us so inject using constructor
}