package com.hnam.recyclerview


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*



class MoviesActivity : AppCompatActivity() {

    lateinit var RVadapter: MoviesAdapter
    lateinit var movies: ArrayList<MoviesModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addStudents()

    }

   fun addStudents() {
        movies= ArrayList()
        movies=JsonFactory.readJson(FakeService.getMovieRaw())
        RVadapter= MoviesAdapter(movies,this)
        rvmovies.layoutManager=LinearLayoutManager(this)
        rvmovies.adapter=RVadapter
    }
}
