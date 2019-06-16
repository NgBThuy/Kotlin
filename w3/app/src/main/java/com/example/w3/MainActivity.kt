package com.example.w3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text=intent.dataString
        btnback.setOnClickListener {
            // DO something here
            gotoChangeBackground()
        }
        btntitle.setOnClickListener {
            // DO something here
            gotoChangeTitle()
        }
        val data = intent.extras

        if (data != null) {
            val text= data.getString("text")
            val color= data.getInt("color")
            val anh= data.getInt("anh")
            textView1.text =text
            textView1.setTextColor(color)
            when (anh){
                1->imageView1.setBackgroundResource(R.drawable.ic_local_cafe_black_24dp)
                2->imageView1.setBackgroundResource(R.drawable.ic_memory_black_24dp)
                else->imageView1.setBackgroundResource(R.drawable.ic_wb_cloudy_black_24dp)
            }
            Toast.makeText(this, anh.toString(), Toast.LENGTH_LONG).show()
        }

    }
    private fun gotoChangeBackground(){
        val intent = Intent(this, BackgroundActivity::class.java)
        startActivity(intent)
    }
    private fun gotoChangeTitle(){
        val intent = Intent(this, TitleActivity::class.java)
        startActivity(intent)
    }

}
