package com.fgrangeiro.movies.service.movieDetail

import com.fgrangeiro.movies.entities.movieList.Movie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailApi {

    @GET("movie/{movieId}?api_key=2976f1fea52bc5d5a136db9f81a36714&language=pt-br")
    fun getMovieDetail(@Path("movieId") movieId: Int): Single<Movie>
}