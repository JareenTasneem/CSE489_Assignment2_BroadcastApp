package com.example.assignment_2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyCustomReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        android.util.Log.d("BROADCAST_TEST", "Receiver triggered")

        val message = intent.getStringExtra("message")

        val resultIntent = Intent(context, CustomReceiverActivity::class.java)
        resultIntent.putExtra("message", message)

        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        context.startActivity(resultIntent)
    }
}