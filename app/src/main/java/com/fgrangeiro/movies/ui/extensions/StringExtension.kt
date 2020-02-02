package com.fgrangeiro.movies.ui.extensions

fun String.removeFirstChar(): String {
    return this.removeRange(IntRange(0, 0))
}