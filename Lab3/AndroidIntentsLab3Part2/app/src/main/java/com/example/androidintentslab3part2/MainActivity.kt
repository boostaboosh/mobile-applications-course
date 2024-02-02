package com.example.androidintentslab3part2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val r = data!!.getIntExtra("r", 0)
                if (r != null) {
                    val t = findViewById<View>(R.id.outputTextView) as TextView
                    t.text = r.toString()
                }
            }
        }

        // binding the button
        val internalIntentButton = findViewById<View>(R.id.explicitInternalIntentButton) as Button
        internalIntentButton.setOnClickListener{
            val i = Intent()
            i.setClassName(this, "com.example.androidintentslab3part2.InternalExplicitIntentReceiver")
            i.putExtra("i1", 2)
            i.putExtra("i2", 3)
            resultLauncher.launch(i)
        }

        val externalIntentButton = findViewById<View>(R.id.externalIntentButton) as Button
        externalIntentButton.setOnClickListener{
            val externalIntent = Intent()
            externalIntent.setClassName("com.example.androidintentslab3part2externalactivity", "com.example.androidintentslab3part2externalactivity.MainActivity")
            externalIntent.putExtra("i1", 4)
            externalIntent.putExtra("i2", 5)
            resultLauncher.launch(externalIntent)
        }

        val implicitExternalIntentWithActionButton = findViewById<View>(R.id.implicitIntentExternalActivity) as Button
        implicitExternalIntentWithActionButton.setOnClickListener{
            val implicitIntent = Intent()
            implicitIntent.action = "mko.intentsender.add"
            implicitIntent.putExtra("i1", 5)
            implicitIntent.putExtra("i2",6)
            resultLauncher.launch(implicitIntent)
        }
    }
}