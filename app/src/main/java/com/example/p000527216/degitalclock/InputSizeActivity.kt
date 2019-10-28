package com.example.p000527216.degitalclock

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.input_font_size.*

class InputSizeActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_font_size)

        val button : Button = findViewById(R.id.inputButton)
        button.setOnClickListener{
            val intent = Intent()
            intent.putExtra("fontSize",inputFontSize.text.toString().toFloat())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }

}