package com.example.currencylab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//adding imports from practical sheet
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // adding practical sheet code
        // defining constants for currency conversion rates
        val GBPtoEUR: Float = 1.16136f;
        val GBPtoDOL: Float = 1.23827F;
        // defining variables
        lateinit var poundText: EditText;
        lateinit var euroText: EditText;
        lateinit var dollarText: EditText;

        poundText = findViewById<View>(R.id.poundValue) as EditText;
        euroText = findViewById<View>(R.id.euroValue) as EditText;
        euroText.isFocusable = false;
        dollarText = findViewById<View>(R.id.dollarValue) as EditText;
        dollarText.isFocusable = false;

        // when convert is clicked convert pounds to dollars and euros
        val convertButton = findViewById<View>(R.id.convertButton) as Button;
        convertButton.setOnClickListener { view ->
            try {
                // convert pounds to other currencies with two decimal places
                val poundString = poundText.text.toString();
                val pounds = poundString.toFloat();
                val euros = Math.round(pounds * GBPtoEUR * 100) / 100f;
                euroText.setText(euros.toString());
                val dollars = Math.round(pounds * GBPtoDOL * 100) / 100f;
                dollarText.setText(dollars.toString());
            } catch (exception: Exception) {
                // report problem in pop-up window
                Toast.makeText(view.context, "Invalid data - try again",
                    Toast.LENGTH_SHORT).show();
            }
        }
        // when clear is clicked, empty the currency fields
        val clearButton = findViewById<View>(R.id.clearButton) as Button;
        clearButton.setOnClickListener { view ->
            try {
                //clear the currency fields
                poundText.setText("");
                euroText.setText("");
                dollarText.setText("");
            } catch (exception : Exception) {
                // report problem in pop-up window
                Toast.makeText(view.context, "something when wrong when clearing entries",
                    Toast.LENGTH_SHORT).show();
            }
        }
    }
}