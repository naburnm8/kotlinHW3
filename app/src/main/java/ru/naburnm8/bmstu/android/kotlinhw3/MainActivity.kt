package ru.naburnm8.bmstu.android.kotlinhw3

import android.content.Context
import android.content.Intent
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
import ru.naburnm8.bmstu.android.kotlinhw3.network.*
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
fun MainActivityScreen(context: Context = LocalContext.current) {
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

    var searchData by rememberSaveable {mutableStateOf<List<MovieShort>?>(null)}
    var searchError by rememberSaveable {mutableStateOf(false)}
    var searchLoading by rememberSaveable {mutableStateOf(false)}
    var searchQuery by rememberSaveable {mutableStateOf("")}
    if (searchData == null && searchQuery != "") {
        getMoviesByQuery(
            query = searchQuery,
            setLoading = {searchLoading = it},
            setError = {_, status -> run { searchError = status}},
            coroutineScope = coroutineScope,
            setData = {searchData = it}
        )
    }

    var profileData by rememberSaveable {mutableStateOf<User?>(null)}
    var profileError by rememberSaveable {mutableStateOf(false)}
    var profileLoading by rememberSaveable {mutableStateOf(false)}
    if (profileData == null) {
        getUser(0,
            setLoading = {profileLoading = it},
            setError = {_, status -> run { profileError = status}},
            coroutineScope = coroutineScope,
            setData = {profileData = it})
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        when (currentScreen) {
            1 -> {
                HomeScreen(
                    modifier = Modifier.weight(1f),
                    isLoading = homeLoading,
                    isFailed = homeError,
                    dataList = homeData ?: emptyList(),
                    onRefreshPress = {homeData = null},
                    launchFullMovieScreen = {startMovieView(it, context = context)}
                )
            }
            2 -> {
                FavouritesScreen(
                    modifier = Modifier.weight(1f),
                    isLoading = favouritesLoading,
                    isFailed = favouritesError,
                    onRefreshPress = {favouritesData = null},
                    dataList = favouritesData ?: emptyList(),
                    launchFullMovieScreen = {startMovieView(it, context = context)}
                )
            }
            3 -> {
                SearchScreen(
                    modifier = Modifier.weight(1f),
                    isLoading = searchLoading,
                    isFailed = searchError,
                    dataList = searchData ?: emptyList(),
                    onRefreshPress = {searchData = null},
                    onSearchPress = {searchQuery = it; searchData = null},
                    launchFullMovieScreen = {startMovieView(it, context = context)}
                )
            }
            4 -> {
                ProfileScreen(
                    modifier = Modifier.weight(1f),
                    isLoading = profileLoading,
                    isFailed = profileError,
                    data = profileData ?: emptyUser
                )
            }
        }
        LowerScreen(setCurrentScreen = {currentScreen = it})
    }
}

fun startMovieView(id: Int, context: Context){
    val intent = Intent(context, MovieViewActivity::class.java)
    intent.putExtra("movie_id",id)
    context.startActivity(intent)
}

