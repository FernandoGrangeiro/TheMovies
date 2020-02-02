package com.fgrangeiro.movies.service.movieDetail

import android.util.Log
import com.fgrangeiro.movies.entities.movieList.Movie
import io.reactivex.Single

class MovieDetailService(val api: MovieDetailApi) {

    fun getMovieDetail(id: Int): Single<Movie> {
        return api.getMovieDetail(id)
    }
}