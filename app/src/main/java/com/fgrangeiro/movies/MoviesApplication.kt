package com.fgrangeiro.movies

import android.app.Application
import com.fgrangeiro.movies.di.movieGenreModule
import org.koin.core.context.startKoin

class MoviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin { modules(movieGenreModule) }
    }
}