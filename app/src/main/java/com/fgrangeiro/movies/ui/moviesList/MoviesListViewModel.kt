package com.fgrangeiro.movies.ui.moviesList

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.fgrangeiro.movies.entities.movieList.Movie
import com.fgrangeiro.movies.service.movieList.MovieListService
import com.fgrangeiro.movies.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MoviesListViewModel(private val service: MovieListService) : BaseViewModel() {

    val movieListLiveData = MutableLiveData<List<Movie>>()
    val errorLiveData = MutableLiveData<Unit>()

    fun getMovieList() {
        val disposable = service.getMovieList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response, error ->
                response?.let {
                    Log.d("asdad", it.toString())
                    movieListLiveData.postValue(it.results)
                }
                error?.let {
                    errorLiveData.postValue(Unit)
                }
            }

        disposables.add(disposable)
    }

}