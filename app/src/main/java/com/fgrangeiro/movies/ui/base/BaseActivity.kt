package com.fgrangeiro.movies.ui.base

import android.content.Context
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.fgrangeiro.movies.R
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseActivity : AppCompatActivity() {

    open val viewModel: BaseViewModel by viewModel()


    fun setupToolbar(
        toolbarTitleString: String,
        setDisplayShowTitleEnabled: Boolean = false,
        setDisplayHomeAsUpEnabled: Boolean = true
    ) {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        if (toolbar != null) {
            toolbar.apply {
                setOnTouchListener { view, _ ->
                    hideKeyboard(view)
                    return@setOnTouchListener false
                }
            }
            setSupportActionBar(toolbar)
            supportActionBar?.run {
                setDisplayShowTitleEnabled(setDisplayShowTitleEnabled)
                setDisplayHomeAsUpEnabled(setDisplayHomeAsUpEnabled)
                title = ""
            }
            toolbarTitle.text = toolbarTitleString.toLowerCase()
        }
    }


    protected fun hideKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun disableNavigationIcon() {
        toolbar.navigationIcon = null

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}