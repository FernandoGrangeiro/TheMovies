package com.fgrangeiro.movies.service.movieList

import com.fgrangeiro.movies.entities.movieList.MovieListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieListApi {

    @GET("movie/now_playing?api_key=2976f1fea52bc5d5a136db9f81a36714&language=pt-br")
    fun getMovieList(@Query("page") page: Int): Single<MovieListResponse>
}