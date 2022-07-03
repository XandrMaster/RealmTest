package com.example.realmtest.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.realmtest.Greeting
import android.widget.TextView
import com.example.realmtest.Repository

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()

        val repository = Repository()
        repository.deleteBooks()
        val book = repository.createBook(name = "The Two Towers", description = "Great Book")
    }
}
