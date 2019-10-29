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
import javax.xml.transform.Result

const val FONT_SIZE_REQUEST_CODE = 0
const val FONT_FAMILY_REQUEST_CODE = 1

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
                //fontsizeのオプションを選択
                R.id.fontSize ->{
                    val intent: Intent = Intent(this,InputSizeActivity::class.java)
                    startActivityForResult(intent,FONT_SIZE_REQUEST_CODE)
                }
                //fontfamilyのオプションを選択
                R.id.font_family_option ->{
                    val intent: Intent = Intent(this,FontListActivity::class.java)
                    startActivityForResult(intent,FONT_FAMILY_REQUEST_CODE)

                }
            }

        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * TODO　実装がくそださい
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == FONT_SIZE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // リクエストコードが一致してかつアクティビティが正常に終了していた場合、受け取った値を表示
            val receivedIntent = data!!
            clock.setTextSize(receivedIntent.extras.get("fontSize").toString().toFloat()) }
        if(requestCode == FONT_FAMILY_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val receivedIntent = data!!
            val result = receivedIntent.extras.get("Result").toString()
            clock.setTypeface(FontFamily.valueOf(result).tf)

        }
    }
}
