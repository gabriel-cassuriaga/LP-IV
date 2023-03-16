package com.example.atividade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.editText_id)
        val buttonOk = findViewById<Button>(R.id.okay_button)
        val buttonClear = findViewById<Button>(R.id.clean_button)
        val hello = findViewById<TextView>(R.id.helloName_id)

        buttonOk.setOnClickListener{
            hello.text = getString(R.string.helloname, name.text)
            hello.visibility = View.VISIBLE
        }

        buttonClear.setOnClickListener{
            hello.text = "";
            name.text.clear();
        }

    }
}