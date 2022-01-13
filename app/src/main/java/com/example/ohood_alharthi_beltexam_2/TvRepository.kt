package com.example.ohood_alharthi_beltexam2

import androidx.lifecycle.LiveData

class TvRepository(private val tvDao: TvDao) {

    val getTvShow: LiveData<List<TvShow>> = tvDao.getTvShow()


    suspend fun addTvShow(tvShow: TvShow) {
        tvDao.addTvShow(tvShow)
    }


    suspend fun deleteTvShow(tvShow: TvShow) {
        tvDao.deleteTvShow(tvShow)
    }

}