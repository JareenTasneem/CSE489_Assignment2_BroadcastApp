package com.example.assignment_2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CustomReceiverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_receiver)

        val textView = findViewById<TextView>(R.id.textViewResult)

        val message = intent.getStringExtra("message")
        textView.text = message
    }
}