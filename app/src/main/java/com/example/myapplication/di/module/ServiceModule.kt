package com.example.myapplication.di.module

import com.example.myapplication.data.api.KinopoiskService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ServiceModule {

    @Provides
    fun provideKinopoiskService(): KinopoiskService {
        return Retrofit.Builder()
            .baseUrl("https://kinopoiskapiunofficial.tech")
            .build()
            .create(KinopoiskService::class.java)
    }
}