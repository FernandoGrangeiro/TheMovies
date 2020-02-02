package com.fgrangeiro.movies.service.movieGenre

import com.fgrangeiro.movies.entities.movieGenre.MovieGenreListResponse
import io.reactivex.Single

class MovieGenreService(val api: MovieGenreApi) {

    fun getMovieGenres(): Single<MovieGenreListResponse> {
        return api.getMovieGenreList()
    }
}