package com.example.myapplication.data.api

import com.example.myapplication.data.entity.FilmsResponse
import retrofit2.http.GET

interface KinopoiskService {
    @GET("/api/v2.2/films")
    suspend fun getFilms(): FilmsResponse
}