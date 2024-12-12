package ru.naburnm8.bmstu.android.kotlinhw3.ui

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.naburnm8.bmstu.android.kotlinhw3.R

@Preview(showBackground = true)
@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector = Ghost,
    painter: Painter = painterResource(id = R.drawable.bookmarks),
    contentDescription: String = "Account",
    isSelected: Boolean = false,
    tint: Color = colorResource(R.color.black),
    selectedTint: Color = colorResource(R.color.orange),
    backgroundColor: Color = colorResource(R.color.white),
    onClick: () -> Unit = {},
)
{
    Column(
        modifier = modifier.padding(4.dp)
            .shadow(
                elevation = if (isSelected) 20.dp else 10.dp, clip = false,
                shape = RoundedCornerShape(10.dp), spotColor = if (isSelected) selectedTint else tint,
                ambientColor = if (isSelected) selectedTint else tint
            ).background(backgroundColor).height(64.dp).width(72.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        IconButton(onClick = {onClick()}, modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally).wrapContentHeight(Alignment.CenterVertically)
        ) {
            Icon(
                painter = painter,
                contentDescription = contentDescription,
                tint = if (isSelected) selectedTint else tint,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(text=contentDescription, textAlign = TextAlign.Center, color = if (isSelected) selectedTint else tint)
    }
}

@Preview(showBackground = true)
@Composable
fun LowerScreen(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    setCurrentScreen: (Int) -> Unit = {},
    backgroundColor: Color = colorResource(R.color.white),
    tint: Color = colorResource(R.color.black),
    selectedTint: Color = colorResource(R.color.orange),
) {
    Row(modifier = modifier.fillMaxWidth().background(backgroundColor), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
        var buttonClicked by rememberSaveable { mutableIntStateOf(1) }
        BaseButton(
            painter = painterResource(id = R.drawable.home),
            onClick = {
                buttonClicked = 1
                setCurrentScreen(1)
            },
            contentDescription = context.getString(R.string.home),
            tint = tint,
            selectedTint = selectedTint,
            isSelected = buttonClicked == 1,
        )
        BaseButton(
            painter = painterResource(id = R.drawable.bookmarks),
            onClick = {
                buttonClicked = 2
                setCurrentScreen(2)
            },
            contentDescription = context.getString(R.string.favourites),
            tint = tint,
            selectedTint = selectedTint,
            isSelected = buttonClicked == 2,
        )
        BaseButton(
            painter = painterResource(id = R.drawable.search),
            onClick = {
                buttonClicked = 3
                setCurrentScreen(3)
            },
            contentDescription = context.getString(R.string.search),
            tint = tint,
            selectedTint = selectedTint,
            isSelected = buttonClicked == 3,
        )
        BaseButton(
            painter = painterResource(R.drawable.skull),
            onClick = {
                buttonClicked = 4
                setCurrentScreen(4)
            },
            contentDescription = context.getString(R.string.profile),
            tint = tint,
            selectedTint = selectedTint,
            isSelected = buttonClicked == 4,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Loading(
    modifier: Modifier = Modifier,
){
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun Error(
    modifier: Modifier = Modifier,
    onRefresh: () -> Unit = {},
    context: Context = LocalContext.current,
){
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        IconButton(onClick = {onRefresh()}){
            Icon(imageVector = Icons.Default.Refresh, contentDescription = context.getString(R.string.errorOccurred), modifier = Modifier.fillMaxSize())
        }
    }
}
