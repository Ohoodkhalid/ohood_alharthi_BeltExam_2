package com.example.ohood_alharthi_beltexam2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TvRepository
    private val tvShow: LiveData<List<TvShow>>

    init {
        val TvDao = TvDatabase.getDatabase(application).TvDao()
        repository = TvRepository(TvDao)
        tvShow = repository.getTvShow

    }

    fun getTvShow(): LiveData<List<TvShow>> {
        return tvShow
    }
    fun addTvShow(tvShow: TvShow) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.addTvShow(tvShow)
       }

    }
    fun deleteTvShow(TvShow: TvShow){
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteTvShow(TvShow)
        }
    }


}