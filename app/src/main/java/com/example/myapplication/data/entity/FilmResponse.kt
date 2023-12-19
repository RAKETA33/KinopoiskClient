package com.example.myapplication.data.entity

data class FilmResponse(
    val kinopoiskId: Int,
    val imdbId: String,
    val nameRu: String?,
    val nameEn: String,
    val nameOriginal: String,
    val countries: List<CountryResponse>,
    val genres: List<GenreResponse>,
    val ratingKinopoisk: Float,
    val ratingImdb: Float,
    val year: Int,
    val type: String,
    val posterUrl: String,
    val posterUrlPreview: String,
)
