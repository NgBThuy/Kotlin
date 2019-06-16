package com.hnam.recyclerview


import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken

class JsonFactory {
    companion object {
        fun readJson(Json: String): ArrayList<MoviesModel> {
            val gson = Gson()
            var json: JsonObject
            json = JsonObject()
            json = gson.fromJson(Json, object : TypeToken<JsonObject>() {}.type)

            var data: ArrayList<MoviesModel>

            data = gson.fromJson(json.get("results"), object : TypeToken<ArrayList<MoviesModel>>() {}.type)
            return data
        }
    }
}