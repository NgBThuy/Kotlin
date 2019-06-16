package com.example.w3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_background.*
import android.widget.Toast

class BackgroundActivity : AppCompatActivity() {
    var anh:Int = 0
    var anhkq:Int= 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background)

        val image = findViewById(R.id.imageView2) as ImageView
        imageView3.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            //Toast.makeText(this@BackgroundActivity, "You clicked on ImageView3.", Toast.LENGTH_SHORT).show()
            image.background = imageView3.background
            anh = 3
        }
        imageView4.setOnClickListener{
            //Toast.makeText(this@BackgroundActivity, "You clicked on ImageView4.", Toast.LENGTH_SHORT).show()
            image.background = imageView4.background
            anh = 4
        }
        imageView5.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            //Toast.makeText(this@BackgroundActivity, "You clicked on ImageView5.", Toast.LENGTH_SHORT).show()
            image.background = imageView5.background
            anh = 5
        }
        imageView6.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            //Toast.makeText(this@BackgroundActivity, "You clicked on ImageView6.", Toast.LENGTH_SHORT).show()
            image.background = imageView6.background
            anh =6
        }
        imageView7.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            //Toast.makeText(this@BackgroundActivity, "You clicked on ImageView7.", Toast.LENGTH_SHORT).show()
            image.background = imageView7.background
            anh = 7
        }
        imageView8.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            //Toast.makeText(this@BackgroundActivity, "You clicked on ImageView8.", Toast.LENGTH_SHORT).show()
            image.background = imageView8.background
            anh = 8
        }

        //click save background pass title activity
        btnsaveback.setOnClickListener {
            gotoChangeTitle()
        }

    }

    private fun gotoChangeTitle(){
        val intent = Intent(this, TitleActivity::class.java)
        anhkq = when (anh){
            3 ->1
            8 ->1
            4 ->2
            6 ->2
            else->3
        }
        intent.putExtra("anh", anhkq)
        Toast.makeText(this, anhkq.toString(), Toast.LENGTH_LONG).show()
        startActivity(intent)
    }
}


