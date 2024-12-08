package ru.naburnm8.bmstu.android.kotlinhw3.ui

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import ru.naburnm8.bmstu.android.kotlinhw3.R
import ru.naburnm8.bmstu.android.kotlinhw3.network.*


@Preview(showBackground = true)
@Composable
fun MovieView(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    onRefreshPress: () -> Unit = {},
    onBookmarkPress: () -> Unit = {},
    onWatchPress: () -> Unit = {},
    backgroundColor: Color = colorResource(R.color.background),
    tint: Color = colorResource(R.color.black),
    isLoading: Boolean = false,
    isFailed: Boolean = false,
    data: MovieFull = defaultMovieFull,
    userHasSubscription: Boolean = true
){
    var isBookmarked by rememberSaveable { mutableStateOf(data.movieShort.isBookmarked) }
    when{
        (isLoading) -> {
            Loading()
        }
        (isFailed) -> {
            Error(onRefresh = onRefreshPress)
        }
        else -> {
            Column(modifier = modifier.fillMaxSize()) {
                AsyncImage(
                    model = data.bigImgUrl,
                    contentDescription = data.movieShort.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth().padding(2.dp).shadow(elevation = 4.dp, clip = false, shape = RoundedCornerShape(12.dp)).height(256.dp),
                )
                Text(
                    text = data.movieShort.title,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 38.sp,
                )
                Row(modifier = Modifier.fillMaxWidth().padding(2.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Icon(
                        painter = painterResource(R.drawable.star),
                        contentDescription = data.movieShort.rating.toString(),
                    )

                    Text(
                        text = data.movieShort.rating.toString(),
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = 18.sp,
                        color = when {
                            (data.movieShort.rating < 5.0) -> colorResource(R.color.red)
                            (data.movieShort.rating in 5.0..8.0) -> colorResource(R.color.orange)
                            (data.movieShort.rating > 8.0) -> colorResource(R.color.green)
                            else -> colorResource(R.color.white)
                        }
                    )
                    Text(
                        text = ", ",
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = 18.sp
                    )
                    Text(
                        text = data.movieShort.year.toString(),
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = 18.sp
                    )
                }
                Row(modifier = Modifier.fillMaxWidth().padding(2.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,) {
                    Button(
                        onClick = {onBookmarkPress(); isBookmarked = !isBookmarked},
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.orange)),
                        elevation = ButtonDefaults.elevatedButtonElevation(4.dp, 2.dp),
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier) {
                            Text(
                                text = if (isBookmarked) context.getString(R.string.removeFromFavourites) else context.getString(R.string.addToFavourites),
                            )
                            Icon(
                                painter = if (isBookmarked) painterResource(R.drawable.bookmarkcheck) else painterResource(R.drawable.bookmark),
                                tint = colorResource(R.color.white),
                                contentDescription = if (isBookmarked) context.getString(R.string.removeFromFavourites) else context.getString(R.string.addToFavourites),
                            )
                        }
                    }
                    Button(
                        onClick = {onWatchPress()},
                        colors = if (data.isWatchable && userHasSubscription) ButtonDefaults.buttonColors(containerColor = colorResource(R.color.green)) else ButtonDefaults.buttonColors(containerColor = colorResource(R.color.gray)),
                        modifier = Modifier.padding(8.dp),
                        elevation = ButtonDefaults.elevatedButtonElevation(4.dp, 2.dp),
                    ){
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                            when {
                                (data.isWatchable && userHasSubscription) -> {
                                    Text(
                                        text = context.getString(R.string.watchNow)
                                    )
                                    Icon(
                                        painter = painterResource(R.drawable.play),
                                        contentDescription = context.getString(R.string.watchNow)
                                    )
                                }

                                (data.isWatchable && !userHasSubscription) -> {
                                    Text(
                                        text = context.getString(R.string.choosePlan)
                                    )
                                    Icon(
                                        painter = painterResource(R.drawable.card),
                                        contentDescription = context.getString(R.string.choosePlan)
                                    )
                                }

                                (!data.isWatchable) -> {
                                    Text(
                                        text = context.getString(R.string.contentIsUnavailable)
                                    )
                                    Icon(
                                        painter = painterResource(R.drawable.play_disabled),
                                        contentDescription = context.getString(R.string.contentIsUnavailable)
                                    )
                                }
                            }
                        }
                    }
                }

                HorizontalDivider(color = colorResource(R.color.black), thickness = 2.dp, modifier = Modifier.padding(8.dp))

                Text(
                    text = context.getString(R.string.description),
                    modifier = Modifier.padding(8.dp),
                    fontStyle = FontStyle.Italic,
                    fontSize = 24.sp
                )

                Text(
                    text = data.desc,
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                )
            }
        }
    }
}