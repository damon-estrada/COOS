package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.kotlinapp.apiClasses.Apod
import com.example.kotlinapp.interfaces.NasaEndpointers
import com.example.kotlinapp.service.ApiServiceCreation
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get a retrofit service instance to start making api calls
        val request = ApiServiceCreation.buildService(NasaEndpointers::class.java)

        // Make the call to the NASA end point, which requires the user's api key.
        val call = request.getAPOD("")

        call.enqueue(object : Callback<Apod>{

            override fun onResponse(call: Call<Apod>, response: Response<Apod>) {
                if (response.isSuccessful) {
                    println("APOD DATE : ${response.body()?.date}")
                    println("APOD EXPLANATION : ${response.body()?.explanation}")
                    println("APOD HDURL : ${response.body()?.hdurl}")

                    // load image using picasso

                    requestsLeftNum.text = response.headers()["X-RateLimit-Remaining"]

                    Picasso.get()
                        .load(response.body()?.url)
                        .into(apodImage)
                }
            }

            override fun onFailure(call: Call<Apod>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}