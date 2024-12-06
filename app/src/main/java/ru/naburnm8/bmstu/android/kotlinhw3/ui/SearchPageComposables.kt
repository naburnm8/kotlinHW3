package ru.naburnm8.bmstu.android.kotlinhw3.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
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


@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit = {},
    context: Context = LocalContext.current,
) {
    var textState by remember { mutableStateOf("") }

    TextField(
        value = textState,
        onValueChange = {
            textState = it
            onSearch(it)
        },
        placeholder = {
            Text(
                text = context.getString(R.string.search),
                color = Color.Gray,
                fontSize = 16.sp
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = context.getString(R.string.search),
                tint = Color.Gray
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFF5F5F5),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp).shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp))
            .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    launchFullMovieScreen: (Int) -> Unit = {},
    onBookmarkPress: (Int) -> Unit = {},
    onRefreshPress: () -> Unit = {},
    onSearchPress: (String) -> Unit = {},
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
                contentDescription = context.getString(R.string.search),
                modifier = Modifier.align(Alignment.CenterVertically).padding(8.dp).height(32.dp).width(32.dp)
            )
            Text(
                text = context.getString(R.string.search),
                modifier = Modifier.align(Alignment.CenterVertically).padding(8.dp),
                style = MaterialTheme.typography.labelLarge,
                fontSize = 24.sp,
            )
        }

        Row (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
        ) {
            SearchBar(onSearch = {onSearchPress(it)})
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