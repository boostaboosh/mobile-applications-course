package com.example.androidintentslab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // cast view from UI with ID startHelloActivity to Button type and assign this button to a variable named helloActivityButton
        val helloActivityButton = findViewById<View>(R.id.startHelloActivity) as Button;
        // set a clickListener on the helloActivityButton. When the button is pressed the onClick() method is called
        helloActivityButton.setOnClickListener{
            val intent = Intent();
            intent.setClassName("com.example.helloworldlab1",
                                "com.example.helloworldlab1.MainActivity");
            startActivity(intent);
        };

        // cast view from UI with ID startHelloActivity to Button type and assign this button to a variable named helloActivityButton
        val currencyConverterActivityButton = findViewById<View>(R.id.startCurrencyConverter) as Button;
        // set a clickListener on the helloActivityButton. When the button is pressed the onClick() method is called
        currencyConverterActivityButton.setOnClickListener{
            val intent = Intent();
            intent.setClassName("com.example.currencylab2",
                "com.example.currencylab2.MainActivity");
            startActivity(intent);
        };
    }
}
