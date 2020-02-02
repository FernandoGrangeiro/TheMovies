package com.fgrangeiro.movies

import android.app.Application
import com.fgrangeiro.movies.di.movieDetailModule
import com.fgrangeiro.movies.di.movieGenreModule
import com.fgrangeiro.movies.di.movieListModule
import org.koin.core.context.startKoin

class MoviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin { modules(listOf(movieGenreModule, movieListModule, movieDetailModule)) }
    }
}