package com.example.myapplication.data.repository

import com.example.myapplication.data.api.KinopoiskService
import com.example.myapplication.domain.entity.Country
import com.example.myapplication.domain.entity.Film
import com.example.myapplication.domain.entity.Genre
import com.example.myapplication.domain.repository.KinopoiskRepository
import javax.inject.Inject

class KinopoiskRepositoryImpl @Inject constructor(
    private val service: KinopoiskService,
) : KinopoiskRepository {

    override suspend fun getFilms(): List<Film> {
        return service.getFilms().items
            .map { filmResponse ->
                Film(
                    kinopoiskId = filmResponse.kinopoiskId,
                    nameRu = filmResponse.nameRu,
                    countries = filmResponse.countries.map { Country(it.country) },
                    genres = filmResponse.genres.map { Genre(it.genre) },
                    ratingKinopoisk = filmResponse.ratingKinopoisk,
                    year = filmResponse.year,
                    type = filmResponse.type,
                    posterUrl = filmResponse.posterUrl,
                    posterUrlPreview = filmResponse.posterUrlPreview,
                    isFavorite = false,
                )
            }
    }
}