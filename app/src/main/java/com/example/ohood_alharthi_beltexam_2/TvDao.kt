package com.example.ohood_alharthi_beltexam2

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TvDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTvShow(tvShow: TvShow)

    @Query("SELECT * FROM TvShowTable ORDER BY id ASC")
    fun getTvShow() : LiveData<List<TvShow>>

    @Delete
    suspend fun deleteTvShow(tvShow:TvShow)


}