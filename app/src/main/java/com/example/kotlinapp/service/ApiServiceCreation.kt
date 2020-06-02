package com.example.kotlinapp.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Referenced from
 * @URL:
 *
 * This object will initialize a retrofit service object to make
 * the api calls.
 */
object ApiServiceCreation {

    private const val BASE_URL = "https://api.nasa.gov/"

    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}