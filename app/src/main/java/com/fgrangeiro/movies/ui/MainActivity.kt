package com.fgrangeiro.movies.ui

import android.os.Bundle
import com.fgrangeiro.movies.R
import com.fgrangeiro.movies.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar("asdasd")

    }
}
