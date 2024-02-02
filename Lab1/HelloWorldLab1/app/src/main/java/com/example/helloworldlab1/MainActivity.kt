package com.example.helloworldlab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        val TextView = TextView(this)
        TextView.text = "Hello Android"
        setContentView(TextView)

         */

        setContentView(R.layout.activity_main)
    }
}