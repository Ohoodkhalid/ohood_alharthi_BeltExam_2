package com.example.ohood_alharthi_beltexam2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TvShowTable")
data class TvShow(
    @PrimaryKey(autoGenerate = true)
val id: Int,
val name: String,
val language: String,
val summary: String,
val image: String,
    val premiered:String,
    val ended:String, val rating:String)

