package com.fgrangeiro.movies.service.movieDetail

import com.fgrangeiro.movies.BuildConfig
import com.fgrangeiro.movies.entities.movieList.Movie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailApi {

    @GET("movie/{movieId}?api_key=${BuildConfig.API_KEY}&language=pt-br")
    fun getMovieDetail(@Path("movieId") movieId: Int): Single<Movie>
}