package ru.naburnm8.bmstu.android.kotlinhw3.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import ru.naburnm8.bmstu.android.kotlinhw3.R
import ru.naburnm8.bmstu.android.kotlinhw3.network.*

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    onRefreshPress: () -> Unit = {},
    backgroundColor: Color = colorResource(R.color.background),
    tint: Color = colorResource(R.color.black),
    isLoading: Boolean = false,
    isFailed: Boolean = false,
    data: User = emptyUser,
    onSubscriptionPress: (Int) -> Unit = {}
){
    Column(
        modifier = modifier.fillMaxSize().background(backgroundColor),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.pump),
                contentDescription = context.getString(R.string.profile),
                modifier = Modifier.align(Alignment.CenterVertically).padding(8.dp).height(32.dp).width(32.dp)
            )
            Text(
                text = context.getString(R.string.profile),
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
                if (data.id != -1){
                    AsyncImage(
                        model = data.avatarImgUrl,
                        contentDescription = context.getString(R.string.avatarImage),
                        modifier = Modifier.align(Alignment.CenterHorizontally).width(128.dp).height(128.dp).shadow(elevation = 6.dp, clip = false, shape = CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = data.firstName + " " + data.lastName,
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 28.sp
                    )
                    Text(
                        text = data.email,
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp
                    )
                SubscriptionView(context = context, backgroundColor = backgroundColor, tint = tint, data = data.subscription, onSubscriptionPress = {onSubscriptionPress(data.id)})
            } else {
                Box (modifier = Modifier.fillMaxSize()) {
                    Text (
                        text = context.getString(R.string.somethingWentWrong),
                        modifier = Modifier.align(Alignment.Center),
                    )
                }
            }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SubscriptionView(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    backgroundColor: Color = colorResource(R.color.background),
    tint: Color = colorResource(R.color.black),
    data: Subscription = defaultSubscription,
    onSubscriptionPress: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth().padding(8.dp).shadow(elevation = 20.dp, clip = false, shape = RoundedCornerShape(12.dp))
            .background(
                Brush.horizontalGradient(colors = listOf(colorResource(R.color.orange), colorResource(R.color.lightOrange)))
            )

    ) {
        Text(
            text = if (data.isValid) context.getString(R.string.subActive) else context.getString(R.string.subInactive),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(4.dp),
            style = MaterialTheme.typography.labelSmall,
            fontSize = 20.sp,
            color = tint
        )
        if (data.isValid)   {
            SubscriptionLevelView(context = context, backgroundColor = backgroundColor, tint = tint, data = data.subscriptionLevel)
        }
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp).shadow(elevation = 20.dp, clip = false, shape = RoundedCornerShape(12.dp)).clickable {
            if (!data.isValid) {
                onSubscriptionPress()
            }
        }
            .background(if (data.isValid) colorResource(R.color.white) else colorResource(R.color.lightGreen))) {
            Text(
                textAlign = TextAlign.Center,
                text = if (data.isValid) context.getString(R.string.subRenew) + " " + data.validUntil.toString() else context.getString(R.string.choosePlan),
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                fontStyle = if (data.isValid) FontStyle.Italic else FontStyle.Normal,
                color = if (data.isValid) colorResource(R.color.gray) else tint
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SubscriptionLevelView(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    backgroundColor: Color = colorResource(R.color.background),
    tint: Color = colorResource(R.color.black),
    data: SubscriptionLevel = defaultSubLevel
) {
    Row(modifier = modifier.fillMaxWidth()){
        Text(
            text = data.title + ", " + data.price + "₽ " + context.getString(R.string.perMonth),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            color = tint
        )
    }
}