package com.example.ohood_alharthi_beltexam_2.API

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("search/shows?q=:query")
fun getData(@Query(value ="q")searchText :String): Call<List<TvItem>>

}