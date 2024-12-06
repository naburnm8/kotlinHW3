package ru.naburnm8.bmstu.android.kotlinhw3.network

data class MovieShort(
    val id: Int,
    val title: String,
    val year: Int,
    val rating: Double,
    val imgUrl: String,
    val isBookmarked: Boolean = false
)

public val defaultMovieShort = MovieShort(
    id = 1,
    title = "Astral",
    year = 2013,
    rating = 9.0,
    imgUrl = "https://cdn2.rzn.info/data/image/afisha/event/26667/250x230/26667_673675d0c7404.jpg"
)

public val defaultMovieShortList = listOf(
    MovieShort(id = 1, title = "Astral", year = 2013, rating = 9.0, imgUrl = "https://cdn2.rzn.info/data/image/afisha/event/26667/250x230/26667_673675d0c7404.jpg"),
    MovieShort(id = 2, title = "The Ring", year = 2002, rating = 7.4, imgUrl = "https://b1.filmpro.ru/c/108719.jpg"),
    MovieShort(id = 3, title = "Astral 2", year = 2013, rating = 3.0, imgUrl = "https://cdn2.rzn.info/data/image/afisha/event/26667/250x230/26667_673675d0c7404.jpg"),
    MovieShort(id = 4, title = "Astral 3", year = 2013, rating = 10.0, imgUrl = "https://cdn2.rzn.info/data/image/afisha/event/26667/250x230/26667_673675d0c7404.jpg"),
    MovieShort(id = 5, title = "Astral 4", year = 2013, rating = 4.9, imgUrl = "https://cdn2.rzn.info/data/image/afisha/event/26667/250x230/26667_673675d0c7404.jpg")
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

