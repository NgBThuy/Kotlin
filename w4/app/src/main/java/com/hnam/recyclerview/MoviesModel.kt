package com.hnam.recyclerview

data class MoviesModel(val id:Int,
                       val vote_average: Float,
                       val video: Boolean,
                       val title: String,
                       val poster_path: String,
                       val backdrop_path: String,
                       val overview: String,
                       val release_date: String)