package ru.naburnm8.bmstu.android.kotlinhw3.network

data class MovieShort(
    val id: Int,
    val title: String,
    val year: Int,
    val rating: Double,
    val imgUrl: String
)

public val defaultMovieShort = MovieShort(
    id = 1,
    title = "Astral",
    year = 2013,
    rating = 9.0,
    imgUrl = "https://cdn2.rzn.info/data/image/afisha/event/26667/250x230/26667_673675d0c7404.jpg"
)

data class Tag(
    val id: Int,
    val title: String,
)

data class MovieFull(
    val id: Int,
    val movieShort: MovieShort,
    val desc: String,
    val isWatchable: Boolean,
    val bigImgUrl: String,
    val tags: List<Tag>,
)

