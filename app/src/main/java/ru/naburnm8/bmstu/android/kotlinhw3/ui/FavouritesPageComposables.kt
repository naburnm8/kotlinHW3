package ru.naburnm8.bmstu.android.kotlinhw3.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.naburnm8.bmstu.android.kotlinhw3.R
import ru.naburnm8.bmstu.android.kotlinhw3.network.MovieShort
import ru.naburnm8.bmstu.android.kotlinhw3.network.defaultMovieShortList



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FavouritesScreen(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    launchFullMovieScreen: (Int) -> Unit = {},
    onBookmarkPress: (Int) -> Unit = {},
    onRefreshPress: () -> Unit = {},
    backgroundColor: Color = colorResource(R.color.background),
    tint: Color = colorResource(R.color.black),
    dataList: List<MovieShort> = defaultMovieShortList,
    isLoading: Boolean = false,
    isFailed: Boolean = false,
){
    Column(
        modifier = modifier.fillMaxSize().background(backgroundColor),
    ) {
        Row (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.pump),
                contentDescription = context.getString(R.string.favourites),
                modifier = Modifier.align(Alignment.CenterVertically).padding(8.dp).height(32.dp).width(32.dp)
            )
            Text(
                text = context.getString(R.string.favourites),
                modifier = Modifier.align(Alignment.CenterVertically).padding(8.dp),
                style = MaterialTheme.typography.labelLarge,
                fontSize = 24.sp,
            )
        }
        when {
            (isLoading) -> {
                Loading()
            }
            (isFailed) -> {
                Error(onRefresh = onRefreshPress)
            }
            else -> {
                PullToRefreshBox(
                    isRefreshing = isLoading,
                    onRefresh = onRefreshPress,
                ) {
                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxSize(),
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(8.dp)
                    ) {
                        items(dataList) { data ->
                            MovieItem(data = data, context = context, modifier = Modifier.padding(8.dp))
                        }
                    }
                }
            }
        }

    }
}