package com.example.assignment_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CustomInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_input)

        val editText = findViewById<EditText>(R.id.editTextMessage)
        val button = findViewById<Button>(R.id.btnSend)

        button.setOnClickListener {

            val message = editText.text.toString()
            val broadcastIntent = Intent("com.example.assignment_2.CUSTOM_ACTION")
            broadcastIntent.setPackage(packageName)
            broadcastIntent.putExtra("message", message)

            sendBroadcast(broadcastIntent)
        }
    }
}