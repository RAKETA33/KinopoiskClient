package com.example.myapplication.data.api

import com.example.myapplication.data.entity.FilmsResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface KinopoiskService {
    @Headers(
        "X-API-KEY: 74c7df42-a7e0-4af1-a7cb-c28bda342693"

    )
    @GET("/api/v2.2/films")
    suspend fun getFilms(): FilmsResponse

}