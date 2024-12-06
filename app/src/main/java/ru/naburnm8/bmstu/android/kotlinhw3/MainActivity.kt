package ru.naburnm8.bmstu.android.kotlinhw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.naburnm8.bmstu.android.kotlinhw3.ui.HomeScreen
import ru.naburnm8.bmstu.android.kotlinhw3.ui.LowerScreen


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
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        HomeScreen(modifier = Modifier.weight(1f))
        LowerScreen()
    }
}

