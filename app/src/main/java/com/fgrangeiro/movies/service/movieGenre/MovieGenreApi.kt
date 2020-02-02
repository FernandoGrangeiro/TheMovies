package com.fgrangeiro.movies.service.movieGenre

import com.fgrangeiro.movies.BuildConfig
import com.fgrangeiro.movies.entities.movieGenre.MovieGenreListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface MovieGenreApi {

    @GET("genre/movie/list?api_key=${BuildConfig.API_KEY}&language=pt-br")
    fun getMovieGenreList(): Single<MovieGenreListResponse>
}