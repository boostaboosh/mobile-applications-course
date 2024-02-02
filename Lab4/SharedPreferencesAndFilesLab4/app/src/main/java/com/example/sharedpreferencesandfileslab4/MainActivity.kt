package com.example.sharedpreferencesandfileslab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting value previously stored in shared preferences file called input with key value
        val preferences = getSharedPreferences("input", MODE_PRIVATE); // first string is preferences file name and second int is public or private mode
        val value = preferences.getString("key", "reference does not exist for this key"); // the second string is the value to return if there is no reference for this key

        // setting output text to the value stored in the input shared references file with the key "key"
        val outputText = findViewById<View>(R.id.outputTextField) as EditText;
        outputText.isFocusable = false;
        outputText.setText(value);

        // setting input text to the input text box
        val inputText = findViewById<View>(R.id.inputTextField) as EditText;

        // making the write to shared preferences button write the text input to the shared preferences file
        val writeToSharedPreferencesButton = findViewById<View>(R.id.writeToSharedPreferencesButton) as Button;
        writeToSharedPreferencesButton.setOnClickListener{
            // getting the text inputted by the user and turning it into a string
            val inputString = inputText.text.toString();
            var outputMessage = "";

            if (inputString != value) // if the input value was not previously stored
            {
                // store the value as a shared preference
                val edit = preferences.edit();
                edit.clear();
                edit.putString("key", inputString);
                edit.commit();
                // message = value has now been stored
                outputMessage = inputString + " now in SP file";
            } else // if a value was previously stored
            {
                // message = value was previously stored
                outputMessage = inputString + " already in SP file";
            }

            // output the message to the user
            outputText.setText(outputMessage)
        }

        // making the write to file button write the input text to a file
        val writeToFileButton = findViewById<View>(R.id.writeToFileButton) as Button;
        writeToFileButton.setOnClickListener{
            // get the input text
            // getting the text inputted by the user and turning it into a string
            val inputString = inputText.text.toString();
            // write the input text to a file
            var fileOutput: FileOutputStream? = null
            try {
                fileOutput = applicationContext.openFileOutput("file.txt", MODE_PRIVATE);

                val outputStream = OutputStreamWriter(fileOutput);
                outputStream.write(inputString);

                // ensure that everything is really written out
                outputStream.flush()
                outputStream.close()
                fileOutput.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        // making the read from file button to make the output text read from an external file
        val readFromFileButton = findViewById<View>(R.id.readFromFileButton) as Button;
        readFromFileButton.setOnClickListener{
            // create the output text string
            var outputString = "no value read from file";
            // read the file
            try {
                val fileInput = openFileInput("file.txt");
                val inputStream = InputStreamReader(fileInput);
                val inputBuffer = CharArray(128);
                inputStream.read(inputBuffer);
                val inputString = String(inputBuffer);
                outputString = inputString;
                inputStream.close();
                fileInput.close();
            } catch (e: Exception) {
                e.printStackTrace();
            }

            // set the output text to the file contents
            outputText.setText(outputString);
        }
    }
}