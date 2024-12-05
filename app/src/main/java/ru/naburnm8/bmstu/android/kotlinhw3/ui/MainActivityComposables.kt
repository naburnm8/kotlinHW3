package ru.naburnm8.bmstu.android.kotlinhw3.ui

import android.content.Context
import android.provider.ContactsContract.Profile
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.naburnm8.bmstu.android.kotlinhw3.R

@Preview(showBackground = true)
@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector = Ghost,
    contentDescription: String = "Account",
    isSelected: Boolean = false,
    tint: Color = colorResource(R.color.black),
    selectedTint: Color = colorResource(R.color.orange),
    backgroundColor: Color = colorResource(R.color.white),
    onClick: () -> Unit = {}
)
{
    Column(
        modifier = modifier.padding(4.dp).wrapContentSize(Alignment.Center)
            .shadow(
                elevation = if (isSelected) 2.dp else 2.dp, clip = false,
                shape = RoundedCornerShape(10.dp), spotColor = if (isSelected) selectedTint else tint,
                ambientColor = if (isSelected) selectedTint else tint
            ).padding(4.dp).background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        IconButton(onClick = {onClick()}, modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally).wrapContentHeight(
            Alignment.CenterVertically)) {
            Icon(
                imageVector = imageVector,
                contentDescription = "",
                tint = if (isSelected) selectedTint else tint
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
            imageVector = Home,
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
            imageVector = Favorite,
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
            imageVector = Search,
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
            imageVector = Ghost,
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
