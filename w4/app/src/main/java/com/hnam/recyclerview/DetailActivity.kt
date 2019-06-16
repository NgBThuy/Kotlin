package com.hnam.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setcontrol()
    }
    fun setcontrol(){
        var listMovie:ArrayList<MoviesModel>
        listMovie= arrayListOf()
        listMovie= JsonFactory.readJson(FakeService.getMovieRaw())
        var Detail: MoviesModel
        Detail = listMovie[0]
        var extra= intent.extras
        val id:Int=extra.getInt("id")

        listMovie.forEach {
            if(it.id==id) {
                Detail = it
            }
        }
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/"+Detail.backdrop_path)
            .into(iposter)
        rate.numStars  = 8
        rate.rating    = Detail.vote_average
        idate.text     = Detail.release_date
        ititle.text    = Detail.title
        ioverview.text = Detail.overview
        /*val play:Boolean
        play = Detail.video
        if (play)
            dplay.show()
        else dplay.hide()*/
    }
}



