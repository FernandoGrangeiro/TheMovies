package com.fgrangeiro.movies.di

import com.fgrangeiro.movies.service.base.RetrofitGenerator
import com.fgrangeiro.movies.service.movieList.MovieListApi
import com.fgrangeiro.movies.service.movieList.MovieListService
import com.fgrangeiro.movies.ui.moviesList.MoviesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieListModule = module {
    single { RetrofitGenerator().getClient(MovieListApi::class.java) }
    single { MovieListService(get()) }
    viewModel { MoviesListViewModel(get()) }
}