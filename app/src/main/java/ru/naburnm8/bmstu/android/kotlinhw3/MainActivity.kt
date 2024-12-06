package ru.naburnm8.bmstu.android.kotlinhw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    var currentScreen by rememberSaveable { mutableIntStateOf(1) }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        when (currentScreen) {
            1 -> {
                HomeScreen(modifier = Modifier.weight(1f))
            }
            2 -> {
                FavouritesScreen(modifier = Modifier.weight(1f))
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

