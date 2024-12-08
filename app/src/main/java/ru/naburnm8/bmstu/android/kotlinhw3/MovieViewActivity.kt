package ru.naburnm8.bmstu.android.kotlinhw3

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import ru.naburnm8.bmstu.android.kotlinhw3.network.*
import ru.naburnm8.bmstu.android.kotlinhw3.ui.MovieView


class MovieViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movieId = intent.getIntExtra("movie_id", -1)
        val userHasSubscription = intent.getBooleanExtra("user_has_subscription", false)
        setContent {
            MovieViewScreen(movieId = movieId, userHasSubscription = userHasSubscription)
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}

@Composable
fun MovieViewScreen(
    context: Context = LocalContext.current,
    movieId: Int,
    userHasSubscription: Boolean
){
    val coroutineScope = rememberCoroutineScope()

    var movieData by rememberSaveable{mutableStateOf<MovieFull?>(null)}
    var isLoading by rememberSaveable{mutableStateOf(false)}
    var hasError by rememberSaveable{mutableStateOf(false)}

    if (movieData == null) {
        getMovie(
            id = movieId,
            setLoading = {isLoading = it },
            setError = {_, status -> run { hasError = status } },
            coroutineScope = coroutineScope,
            setData = {movieData = it}
        )
    }

    MovieView(
        context = context,
        onRefreshPress = {movieData = null},
        isLoading = isLoading,
        isFailed = hasError,
        data = movieData ?: emptyMovieFull,
        userHasSubscription = userHasSubscription,
    )


}


