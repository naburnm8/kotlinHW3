package ru.naburnm8.bmstu.android.kotlinhw3.network

import kotlinx.serialization.Serializable

@Serializable
data class MovieListResponse(val movies: List<MovieShort>)