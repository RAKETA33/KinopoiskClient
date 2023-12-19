package com.example.myapplication.domain.entity

data class Film(
    val kinopoiskId: Int,
    val nameRu: String?,
    val countries: List<Country>,
    val genres: List<Genre>,
    val ratingKinopoisk: Float,
    val year: Int,
    val type: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val isFavorite: Boolean,
)
