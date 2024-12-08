package ru.naburnm8.bmstu.android.kotlinhw3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import ru.naburnm8.bmstu.android.kotlinhw3.network.MovieShort
import ru.naburnm8.bmstu.android.kotlinhw3.network.getFavourites
import ru.naburnm8.bmstu.android.kotlinhw3.network.getPopularMovies
import ru.naburnm8.bmstu.android.kotlinhw3.ui.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityScreen()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainActivityScreen() {
    var currentScreen by rememberSaveable {mutableIntStateOf(1)}
    val coroutineScope = rememberCoroutineScope()
    var homeData by rememberSaveable {mutableStateOf<List<MovieShort>?>(null)}
    var homeError by rememberSaveable {mutableStateOf(false)}
    var homeLoading by rememberSaveable {mutableStateOf(false)}
    if (homeData == null) {
        getPopularMovies(
            setLoading = {homeLoading = it},
            setError = {_, status -> run { homeError = status }},
            coroutineScope = coroutineScope,
            setData = {homeData = it})
    }

    var favouritesData by rememberSaveable {mutableStateOf<List<MovieShort>?>(null)}
    var favouritesError by rememberSaveable {mutableStateOf(false)}
    var favouritesLoading by rememberSaveable {mutableStateOf(false)}
    if (favouritesData == null) {
        getFavourites(
            setLoading = {favouritesLoading = it},
            setError = {_, status -> run { favouritesError = status} },
            setData = {favouritesData = it},
            coroutineScope = coroutineScope,
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        when (currentScreen) {
            1 -> {
                HomeScreen(modifier = Modifier.weight(1f), isLoading = homeLoading, isFailed = homeError, dataList = homeData ?: emptyList(), onRefreshPress = {homeData = null})
            }
            2 -> {
                FavouritesScreen(modifier = Modifier.weight(1f), isLoading = favouritesLoading, isFailed = favouritesError, onRefreshPress = {favouritesData = null}, dataList = favouritesData ?: emptyList())
            }
            3 -> {
                SearchScreen(modifier = Modifier.weight(1f))
            }
            4 -> {
                ProfileScreen(modifier = Modifier.weight(1f))
            }
        }
        LowerScreen(setCurrentScreen = {currentScreen = it})
    }
}

