package com.fgrangeiro.movies.service.movieGenre

import android.util.Log
import com.fgrangeiro.movies.entities.movieGenre.MovieGenreListResponse
import io.reactivex.Single

class MovieGenreService(val api: MovieGenreApi) {


    fun getMovieGenres(): Single<MovieGenreListResponse> {
        val a = api.getMeetingExchanges()

        Log.d("asdada", a.toString())
        return a

    }
}