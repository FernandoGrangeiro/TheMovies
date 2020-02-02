package com.fgrangeiro.movies.ui.movieGenre

import android.os.Bundle
import com.fgrangeiro.movies.R
import com.fgrangeiro.movies.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesGenreActivity : BaseActivity() {

    override val viewModel: MovieGenreViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_genre)
        setupToolbar("Feijao")

        viewModel.getMoviesGenres()


    }
}
