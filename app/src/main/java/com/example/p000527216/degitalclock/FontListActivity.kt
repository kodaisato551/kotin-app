package com.example.p000527216.degitalclock

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import kotlinx.android.synthetic.main.font_selection_list.*

class FontListActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.font_selection_list)

        val list: ArrayList<String> = arrayListOf("DEFAULT","DEFAULT_BOLD","SANS_SERIF","SERIF","MONOSPACE")

        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice,list)
        font_family_list.adapter = adapter

        val button : Button = findViewById(R.id.font_family_button)
        button.setOnClickListener{
            val intent = Intent()
            intent.putExtra("Result", font_family_list.selectedItem as String)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

    }
}
