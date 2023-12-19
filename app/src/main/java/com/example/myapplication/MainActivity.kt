package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.api.KinopoiskService
import com.example.myapplication.data.repository.KinopoiskRepositoryImpl
import com.example.myapplication.domain.entity.Film
import com.example.myapplication.domain.repository.KinopoiskRepository
import com.example.myapplication.presentation.adapters.FilmRecyclerAdapter
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.cancellation.CancellationException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val repository = KinopoiskRepositoryImpl(provideKinopoiskService())
        lifecycleScope.launch {

            val films = repository.getFilms()
            val adapter = FilmRecyclerAdapter(films)
            recyclerView.adapter = adapter

        }

    }

    fun provideKinopoiskService(): KinopoiskService {
        return Retrofit.Builder()
            .baseUrl("https://kinopoiskapiunofficial.tech")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KinopoiskService::class.java)
    }

    inline fun <R> runSuspendCatching(block: () -> R): Result<R> {
        return try {
            Result.success(block())
        } catch (c: CancellationException) {
            throw c
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }

}

