package com.example.p000527216.degitalclock

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

const val FONT_SIZE_REQUEST_CODE = 0

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item != null) {
            when(item.itemId){
                R.id.fontSize ->{
                    val intent: Intent = Intent(this,InputSizeActivity::class.java)
                    startActivityForResult(intent,FONT_SIZE_REQUEST_CODE)
                }
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == FONT_SIZE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // リクエストコードが一致してかつアクティビティが正常に終了していた場合、受け取った値を表示
            val receivedIntent = data!!
            clock.setTextSize(receivedIntent.extras.get("fontSize").toString().toFloat()) }
    }
}
