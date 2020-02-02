package com.fgrangeiro.movies.di

import com.fgrangeiro.movies.service.base.RetrofitGenerator
import com.fgrangeiro.movies.service.movieGenre.MovieGenreApi
import com.fgrangeiro.movies.service.movieGenre.MovieGenreService
import com.fgrangeiro.movies.ui.movieGenre.MovieGenreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieGenreModule = module {

    single { RetrofitGenerator().getClient(MovieGenreApi::class.java) }
    single { MovieGenreService(get()) }
    viewModel { MovieGenreViewModel(get()) }

}