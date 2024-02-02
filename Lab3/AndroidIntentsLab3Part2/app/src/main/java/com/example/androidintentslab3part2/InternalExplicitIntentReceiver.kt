package com.example.androidintentslab3part2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class InternalExplicitIntentReceiver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal_explicit_intent_receiver)

        val extras = intent.extras
        val i1 = extras!!.getInt("i1")
        val i2 = extras!!.getInt("i2")
        val resIntent = Intent()
        if (i1 != null && i2 != null) {
            val result = i1 * i2
            resIntent.putExtra("r", result)
        }
        setResult(RESULT_OK, resIntent)
        finish()
    }
}