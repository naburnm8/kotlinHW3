package ru.naburnm8.bmstu.android.kotlinhw3.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import ru.naburnm8.bmstu.android.kotlinhw3.network.serialization.LocalDateSerializer
import java.time.LocalDate

@Serializable
@Parcelize
data class MovieShort(
    val id: Int,
    val title: String,
    val year: Int,
    val rating: Double,
    val imgUrl: String,
    val isBookmarked: Boolean = false
): Parcelable

public val defaultMovieShort = MovieShort(
    id = 1,
    title = "Astral",
    year = 2013,
    rating = 9.0,
    imgUrl = "https://cdn2.rzn.info/data/image/afisha/event/26667/250x230/26667_673675d0c7404.jpg",
    isBookmarked = true
)

public val defaultMovieShortList = listOf(
    MovieShort(id = 1, title = "Astral", year = 2013, rating = 9.0, imgUrl = "https://cdn2.rzn.info/data/image/afisha/event/26667/250x230/26667_673675d0c7404.jpg"),
    MovieShort(id = 2, title = "The Ring", year = 2002, rating = 7.4, imgUrl = "https://b1.filmpro.ru/c/108719.jpg"),
    MovieShort(id = 3, title = "Astral 2", year = 2013, rating = 3.0, imgUrl = "https://cdn2.rzn.info/data/image/afisha/event/26667/250x230/26667_673675d0c7404.jpg"),
    MovieShort(id = 4, title = "Astral 3", year = 2013, rating = 10.0, imgUrl = "https://cdn2.rzn.info/data/image/afisha/event/26667/250x230/26667_673675d0c7404.jpg"),
    MovieShort(id = 5, title = "Astral 4", year = 2013, rating = 4.9, imgUrl = "https://cdn2.rzn.info/data/image/afisha/event/26667/250x230/26667_673675d0c7404.jpg")
)

@Serializable
@Parcelize
data class Tag(
    val id: Int,
    val title: String,
    val color: Long
): Parcelable

val tagsList = listOf(
    Tag(id = 1, title = "Scary!", color = 0xFFFAB75A),
    Tag(id = 2, title = "NSFW", color = 0xFFFF6F6F),
    Tag(id = 3, title = "New!", color = 0xFF85e37b)
)

@Serializable
@Parcelize
data class MovieFull(
    val id: Int,
    val movieShort: MovieShort,
    val desc: String,
    val isWatchable: Boolean,
    val bigImgUrl: String,
    val tags: List<Tag>,
): Parcelable

@Serializable
@Parcelize
data class SubscriptionLevel(
    val id: Int,
    val price: Int,
    val title: String,
): Parcelable

@Serializable
@Parcelize
data class Subscription(
    val id: Int,
    val isValid: Boolean,
    @Serializable(with = LocalDateSerializer::class)
    val validUntil: LocalDate,
    val subscriptionLevel: SubscriptionLevel,
): Parcelable

@Serializable
@Parcelize
data class User(
    val id: Int,
    val username: String,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val subscription: Subscription,
    val avatarImgUrl: String
): Parcelable

public val defaultSubLevel = SubscriptionLevel(id = 1, price = 500, title = "Movies Plus")

public val defaultSubscription = Subscription(id = 1, isValid = true, validUntil = LocalDate.parse("2024-12-30"), subscriptionLevel = defaultSubLevel)

const val mockupDescription = "A young journalist, Ellie Marshall, investigates decades of disappearances tied to the eerie Blackwood Orphanage." +
        " Locals whisper of a malevolent entity that feeds on fear," +
        " erasing its victims from existence. As Ellie unravels the orphanage’s dark secrets," +
        " she must confront the lurking presence before becoming its next forgotten soul. "

public val defaultUser = User(id = 0, username = "naburnm8", firstName = "Artem", lastName = "Lint", phoneNumber = "+79996783412", email= "blabla@bk.ru", subscription = defaultSubscription, avatarImgUrl = "https://static.wikia.nocookie.net/c9dde1fd-8d96-4288-97ea-6dca45a39891/scale-to-width/755")
public val emptyUser = User(id = -1, username = "", firstName = "", lastName = "", phoneNumber = "", email= "", subscription = defaultSubscription, avatarImgUrl = "")
public val defaultMovieFull = MovieFull(id = 1, movieShort = defaultMovieShort, desc = mockupDescription, isWatchable = false, bigImgUrl = "https://variety.com/wp-content/uploads/2018/11/astral.jpg?w=1000&h=500&crop=1", tags = tagsList)
public val emptyMovieFull = MovieFull(id = -1, movieShort = defaultMovieShort, desc = "", isWatchable = false, bigImgUrl = "", tags = emptyList())
public val defaultTags = tagsList