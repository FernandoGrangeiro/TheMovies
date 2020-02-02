package com.fgrangeiro.movies.ui.movieDetail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.fgrangeiro.movies.entities.movieList.Movie
import com.fgrangeiro.movies.service.movieDetail.MovieDetailService
import com.fgrangeiro.movies.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieDetailViewModel(private val service: MovieDetailService) : BaseViewModel() {

    val movieDetailLiveData = MutableLiveData<Movie>()
    val errorLiveData = MutableLiveData<Unit>()

    fun getMovieDetail(id: Int) {
        val disposable = service.getMovieDetail(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response, error ->
                response?.let {
                    movieDetailLiveData.postValue(it)
                }
                error?.let {
                    Log.d(
                        "dasdadawdawa", it.localizedMessage
                    )

                    errorLiveData.postValue(Unit)
                }
            }

        disposables.add(disposable)
    }

}