package com.example.ohood_alharthi_beltexam_2.API


data class Show(
    val _links: Links,
    val averageRuntime: Int,
    val dvdCountry: Any,
    val ended: Any?=null,
    val externals: Externals,
    val genres: List<String>,
    val id: Int,
    val image: Image?=null,
    val language: String,
    val name: String,
    val network: Network,
    val officialSite: String,
    val premiered: String?=null,
    val rating: Rating?=null,
    val runtime: Int,
    val schedule: Schedule,
    val status: String,
    val summary: Any?=null,
    val type: String,
    val updated: Int,
    val url: String,
    val webChannel: Any,
    val weight: Int
)