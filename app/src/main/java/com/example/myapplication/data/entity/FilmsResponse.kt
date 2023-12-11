package com.example.myapplication.data.entity

data class FilmsResponse(
    val total: Int,
    val totalPages: Int,
    val items: List<FilmResponse>,
)
