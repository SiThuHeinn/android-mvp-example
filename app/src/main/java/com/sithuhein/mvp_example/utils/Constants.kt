package com.sithuhein.mvp_example.utils


object Constants{
     const val BASE_URL = "https://api.themoviedb.org/3/"

     private const val PHOTO_BASE_URL = "http://image.tmdb.org/t/p/w185"

    fun getPosterPath(path : String) : String = PHOTO_BASE_URL + path

    fun getMovieTitleQueryMap(title : String) : HashMap<String, String> {
        val queryMap = hashMapOf<String, String>()
        queryMap["query"] = title
        return queryMap
    }

    fun getMovieYearQueryMap(year : Int) : HashMap<String, Int> {
        val queryMap = hashMapOf<String, Int>()
        queryMap["year"] = year
        return queryMap
    }

}

