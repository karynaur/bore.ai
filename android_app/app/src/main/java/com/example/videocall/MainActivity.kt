package com.example.videocall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changescreen(view: View){
        val myIntent = Intent(this, CallScreen::class.java);
        Toast.makeText(applicationContext, "Connecting to the server...", Toast.LENGTH_SHORT).show()
        startActivity(myIntent)
    }
}