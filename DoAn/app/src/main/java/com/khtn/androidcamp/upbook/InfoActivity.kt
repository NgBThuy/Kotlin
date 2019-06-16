package com.khtn.androidcamp.upbook

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.khtn.androidcamp.MainActivity
import com.khtn.androidcamp.R
import com.khtn.androidcamp.models.Book
import kotlinx.android.synthetic.main.activity_book_info.*

class InfoActivity : AppCompatActivity() {

    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val rootDB = firebaseDatabase.reference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_info)

        btn_upbook.setOnClickListener{

            val name_book = ed_name_book.text.toString().trim()
            val author = ed_author.text.toString().trim()
            val city = ed_city.text.toString().trim()
            val info = ed_info.text.toString().trim()
            val contact = ed_contact.text.toString().trim()

            val book = Book(name_book,author,info,city,contact)
            rootDB.child("Information").push().setValue(book)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}
