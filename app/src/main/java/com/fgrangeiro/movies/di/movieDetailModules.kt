package com.fgrangeiro.movies.di

import com.fgrangeiro.movies.service.base.RetrofitGenerator
import com.fgrangeiro.movies.service.movieDetail.MovieDetailApi
import com.fgrangeiro.movies.service.movieDetail.MovieDetailService
import com.fgrangeiro.movies.service.movieList.MovieListApi
import com.fgrangeiro.movies.service.movieList.MovieListService
import com.fgrangeiro.movies.ui.movieDetail.MovieDetailViewModel
import com.fgrangeiro.movies.ui.moviesList.MoviesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieDetailModule = module {
    single { RetrofitGenerator().getClient(MovieDetailApi::class.java) }
    single { MovieDetailService(get()) }
    viewModel { MovieDetailViewModel(get()) }
}