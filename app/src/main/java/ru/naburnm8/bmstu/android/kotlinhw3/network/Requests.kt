package ru.naburnm8.bmstu.android.kotlinhw3.network


import android.content.Context
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

//used in default models for previews









fun getPopularMovies(
    setLoading: (Boolean) -> Unit,
    setError: (String, Boolean) -> Unit,
    coroutineScope: CoroutineScope,
    setData: (List<MovieShort>) -> Unit,
    context: Context
) {
    setLoading(true)
    setError("", false)
    coroutineScope.launch {
        try{
            val jsonString = context.assets.open("popular_mockup.json").bufferedReader().use {it.readText()}
            val responseMovie = Json.decodeFromString<MovieListResponse>(jsonString)
            val response = responseMovie.movies
            delay(500L)
            setData(response)
        } catch (e: Exception){
            setError(e.message ?: "", true)
            setData(emptyList())
        }
        finally {
            setLoading(false)
        }
    }
}

fun getFavourites(
    setLoading: (Boolean) -> Unit,
    setError: (String, Boolean) -> Unit,
    coroutineScope: CoroutineScope,
    setData: (List<MovieShort>) -> Unit,
    context: Context
) {
    setLoading(true)
    setError("", false)
    coroutineScope.launch {
        try{
            val jsonString = context.assets.open("favourites_mockup.json").bufferedReader().use {it.readText()}
            val responseMovie = Json.decodeFromString<MovieListResponse>(jsonString)
            val response = responseMovie.movies
            delay(500L)
            setData(response)
        } catch (e: Exception){
            setError(e.message ?: "", true)
            setData(emptyList())
        }
        finally {
            setLoading(false)
        }
    }
}

fun getMovie(
    id: Int,
    setLoading: (Boolean) -> Unit,
    setError: (String, Boolean) -> Unit,
    coroutineScope: CoroutineScope,
    setData: (MovieFull) -> Unit,
    context: Context
    ) {
    setLoading(true)
    setError("", false)
    coroutineScope.launch {
        try{
            val jsonString = context.assets.open("movie$id.json").bufferedReader().use {it.readText()}
            val response = Json.decodeFromString<MovieFull>(jsonString)
            delay(500L)
            setData(response)
        } catch (e: Exception){
            setError(e.message ?: "", true)
            println(e.message)
            setData(emptyMovieFull)
        }
        finally {
            setLoading(false)
        }
    }
}

fun getMoviesByQuery(
    query: String,
    setLoading: (Boolean) -> Unit,
    setError: (String, Boolean) -> Unit,
    coroutineScope: CoroutineScope,
    setData: (List<MovieShort>) -> Unit,
    context: Context
) {
    setLoading(true)
    setError("", false)
    coroutineScope.launch {
        try{
            val jsonString = context.assets.open("popular_mockup.json").bufferedReader().use {it.readText()}
            val responseMovie = Json.decodeFromString<MovieListResponse>(jsonString)
            val response = responseMovie.movies.filter {it.title.contains(query)}
            delay(500L)
            setData(response)
        } catch (e: Exception){
            setError(e.message ?: "", true)
            setData(emptyList())
        }
        finally {
            setLoading(false)
        }
    }
}

fun getUser(
    id: Int,
    setLoading: (Boolean) -> Unit,
    setError: (String, Boolean) -> Unit,
    coroutineScope: CoroutineScope,
    setData: (User) -> Unit,
    context: Context
) {
    setLoading(true)
    setError("", false)
    coroutineScope.launch {
        try{
            val jsonString = context.assets.open("user$id.json").bufferedReader().use {it.readText()}
            val response = Json.decodeFromString<User>(jsonString)
            delay(500L)
            setData(response)
        } catch (e: Exception){
            setError(e.message ?: "", true)
            println(e.message)
            setData(emptyUser)
        }
        finally {
            setLoading(false)
        }
    }
}