package com.fgrangeiro.movies.ui.movieDetail

import android.os.Bundle
import androidx.lifecycle.Observer
import com.fgrangeiro.movies.R
import com.fgrangeiro.movies.ui.base.BaseActivity
import com.fgrangeiro.movies.ui.base.GlideApp
import com.fgrangeiro.movies.ui.extensions.hide
import com.fgrangeiro.movies.ui.extensions.removeFirstChar
import com.fgrangeiro.movies.ui.extensions.show
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_movie_detail.*

import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailActivity : BaseActivity() {

    override val viewModel: MovieDetailViewModel by viewModel()

    companion object {
        val MOVIE_ID = "MOVIE_ID"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setupToolbar(getString(R.string.movie_detail_toolbar))
        setViewModelListeners()
        showLoading()
        getMovieDetail()


    }

    private fun getMovieDetail() {
        val id = intent.getIntExtra(MOVIE_ID, 1)
        viewModel.getMovieDetail(id)
    }

    private fun setViewModelListeners() {
        viewModel.movieDetailLiveData.observe(this, Observer { movie ->
            hideLoading()
            movie?.let {
                movieName.text = it.title
                movieDescription.text = it.description
                movieReleaseDate.text =
                    getString(R.string.movie_detail_release_date, it.releaseDate)

                GlideApp.with(this)
                    .load(
                        "https://image.tmdb.org/t/p/original/${movie.backDropImage.removeFirstChar()}"
                    )
                    .into(movieImage)
            }
        })
        viewModel.errorLiveData.observe(this, Observer {
            showErrorMessage()
            hideLoading()
        })
    }

    private fun hideLoading() {
        loading.hide()
    }

    private fun showLoading() {
        loading.show()
    }

    private fun showErrorMessage() {
        Snackbar.make(
            loading,
            getString(R.string.movie_detail_request_error),
            Snackbar.LENGTH_SHORT
        ).show()
    }

}
