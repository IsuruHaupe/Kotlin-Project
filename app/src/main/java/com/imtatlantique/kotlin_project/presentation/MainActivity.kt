package com.imtatlantique.kotlin_project.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.imtatlantique.kotlin_project.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        val service = Retrofit.Builder()
            .baseUrl("https://henri-potier.techx.fr/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(BookService::class.java)

        CoroutineScope(IO).launch {
            val book = service.query()
            Log.d("MainActivity", "onCreate : ${book.map { it.title }}")
        }
        */
    }
}