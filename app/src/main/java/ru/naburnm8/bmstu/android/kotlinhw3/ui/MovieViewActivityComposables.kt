package ru.naburnm8.bmstu.android.kotlinhw3.ui

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorInt
import coil3.compose.AsyncImage
import ru.naburnm8.bmstu.android.kotlinhw3.R
import ru.naburnm8.bmstu.android.kotlinhw3.network.*



@Preview(showBackground = true)
@Composable
fun TagsList(
    modifier: Modifier = Modifier,
    backgroundColor: Color = colorResource(R.color.background),
    tint: Color = colorResource(R.color.black),
    dataList: List<Tag> = defaultTags
) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        for (tag in dataList) {
            val tagColor = Color(tag.color)
            Spacer(Modifier.width(4.dp))
            Box(
                modifier = Modifier
                    .shadow(elevation = 10.dp, shape = RoundedCornerShape(8.dp))
                    .background(tagColor)
                    .padding(6.dp)
                    //.background(tagColor, shape = RoundedCornerShape(16.dp))


            ) {
                Text(
                    text = tag.title,
                    color = tint,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                )
            }
            Spacer(Modifier.width(4.dp))

        }
        }
    }


@Preview(showBackground = true)
@Composable
fun MovieView(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    onRefreshPress: () -> Unit = {},
    onBookmarkPress: () -> Unit = {},
    onWatchPress: () -> Unit = {},
    onChoosePlanPress: () -> Unit = {},
    backgroundColor: Color = colorResource(R.color.background),
    tint: Color = colorResource(R.color.black),
    isLoading: Boolean = false,
    isFailed: Boolean = false,
    data: MovieFull = defaultMovieFull,
    userData: User = defaultUser,
){
    var isBookmarked by rememberSaveable { mutableStateOf(data.movieShort.isBookmarked) }
    isBookmarked = data.movieShort.isBookmarked
    val userHasSubscription = userData.subscription.isValid
    when{
        (isLoading) -> {
            Loading()
        }
        (isFailed) -> {
            Error(onRefresh = onRefreshPress)
        }
        else -> {
            Column(modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
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
                Spacer(Modifier.height(8.dp))
                TagsList(dataList = data.tags)
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
                        onClick = {
                            when {
                                (!data.isWatchable) -> {
                                    //pass
                                }
                                (!userHasSubscription) -> {
                                    onChoosePlanPress()
                                }
                                else -> {
                                    onWatchPress()
                                }
                            }
                        },
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
                                        text = context.getString(R.string.contentIsUnavailable),
                                        fontSize = 10.sp
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