package com.example.myapplication.domain.repository

import com.example.myapplication.domain.entity.Film

interface KinopoiskRepository {
     suspend fun getFilms(): List<Film>
}