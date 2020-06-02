package com.example.kotlinapp.interfaces

import com.example.kotlinapp.apiClasses.Apod
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaEndpointers {

    // GET today's Astronomy Picture of the Day (APOD)
    @GET("/planetary/apod")
    fun getAPOD(@Query("api_key") apiKey: String): Call<Apod>

}