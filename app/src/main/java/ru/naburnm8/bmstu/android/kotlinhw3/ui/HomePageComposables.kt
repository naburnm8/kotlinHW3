package ru.naburnm8.bmstu.android.kotlinhw3.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import okhttp3.internal.wait
import ru.naburnm8.bmstu.android.kotlinhw3.R
import ru.naburnm8.bmstu.android.kotlinhw3.network.MovieShort
import ru.naburnm8.bmstu.android.kotlinhw3.network.defaultMovieShort
import ru.naburnm8.bmstu.android.kotlinhw3.network.defaultMovieShortList

@Preview(showBackground = true)
@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    launchFullMovieScreen: (Int) -> Unit = {},
    onBookmarkPress: (Int) -> Unit = {},
    backgroundColor: Color = colorResource(R.color.background),
    tint: Color = colorResource(R.color.black),
    data: MovieShort = defaultMovieShort
){
    var isBookmarked by rememberSaveable { mutableStateOf(data.isBookmarked) }
    Card(
        modifier = modifier.width(160.dp).height(240.dp).shadow(elevation = 4.dp, clip = true, shape = RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
        Box (modifier = Modifier.weight(1f)) {
            AsyncImage(
                model = data.imgUrl,
                contentDescription = data.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize().clickable{launchFullMovieScreen(data.id)},
            )

            Box(
                modifier = Modifier.align(Alignment.TopEnd).padding(8.dp)
                    .shadow(elevation = 16.dp, clip = false, shape = RoundedCornerShape(12.dp))
                    .size(36.dp).background(colorResource(R.color.orange))
            ) {
                IconButton(onClick = {
                    onBookmarkPress(data.id)
                    isBookmarked = !isBookmarked
                }){
                    Icon(
                        imageVector = if (isBookmarked) Bookmark_check else Bookmark,
                        contentDescription = context.getString(R.string.toFavourites),
                        tint = Color.White
                    )
                }
            }

            Box(
                modifier = Modifier.align(Alignment.BottomEnd).padding(8.dp)
                    .shadow(elevation = 16.dp, clip = false, shape = RoundedCornerShape(12.dp))
                    .size(36.dp)
                    .background(
                        when {
                            (data.rating < 5.0) -> colorResource(R.color.red)
                            (data.rating in 5.0..8.0) -> colorResource(R.color.orange)
                            (data.rating > 8.0) -> colorResource(R.color.green)
                            else -> colorResource(R.color.white)
                        }
                    )
            ) {
                Text(
                    text = data.rating.toString(),
                    color = colorResource(R.color.white),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth().align(Alignment.Start).background(
                Brush.verticalGradient(
                    colors = listOf(tint, Color.Transparent),
                    startY = 0f,
                    endY = 200f,
                )
            ).padding(8.dp)
        ) {
            Column {
                Text(
                    text = data.title,
                    color = colorResource(R.color.white),
                    style = MaterialTheme.typography.labelLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = data.year.toString(),
                    color = colorResource(R.color.white),
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(
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
                contentDescription = context.getString(R.string.popular),
                modifier = Modifier.align(Alignment.CenterVertically).padding(8.dp).height(32.dp).width(32.dp)
            )
            Text(
                text = context.getString(R.string.popular),
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
                LazyVerticalGrid(modifier = Modifier.fillMaxSize(), columns = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp)) {
                    items(dataList){
                        data -> MovieItem(data = data, context = context, modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }

    }
}