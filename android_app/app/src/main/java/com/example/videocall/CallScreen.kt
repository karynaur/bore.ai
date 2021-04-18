package com.example.videocall

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Camera
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.nio.channels.AsynchronousFileChannel.open
import java.util.*

class CallScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_screen)


    }

    fun connect_video(view: View) {
       // Toast.makeText(applicationContext, "Speak now to send your message.", Toast.LENGTH_SHORT).show()

        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, 10)
        } else {
            Toast.makeText(applicationContext, "Your device does not support speech recognition", Toast.LENGTH_SHORT).show()
            Log.e("err", "errrrorrr")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            10 -> if (resultCode == RESULT_OK && data != null) {
                val result: ArrayList<String> = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<String>
                findViewById<TextView>(R.id.speech).text = result.get(0)
                // pass $result to the server
                //
                //
            }
        }
    }
}