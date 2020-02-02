package com.fgrangeiro.movies.service.movieList

import com.fgrangeiro.movies.entities.movieList.MovieListResponse
import io.reactivex.Single

class MovieListService(private val api: MovieListApi) {

    fun getMovieList(): Single<MovieListResponse> {
        return api.getMovieList(1)
    }
}