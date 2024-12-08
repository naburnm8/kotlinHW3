package ru.naburnm8.bmstu.android.kotlinhw3.network


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val mockupDescription = "A young journalist, Ellie Marshall, investigates decades of disappearances tied to the eerie Blackwood Orphanage." +
        " Locals whisper of a malevolent entity that feeds on fear," +
        " erasing its victims from existence. As Ellie unravels the orphanage’s dark secrets," +
        " she must confront the lurking presence before becoming its next forgotten soul. "

val popularMoviesList = listOf(
    MovieShort(id = 1, title = "Astral", year = 2013, rating = 9.0, imgUrl = "https://cdn2.rzn.info/data/image/afisha/event/26667/250x230/26667_673675d0c7404.jpg"),
    MovieShort(id = 2, title = "The Ring", year = 2002, rating = 7.4, imgUrl = "https://b1.filmpro.ru/c/108719.jpg"),
    MovieShort(id = 3, title = "Astral 2", year = 2014, rating = 3.0, imgUrl = "https://cdn2.rzn.info/data/image/afisha/event/26667/250x230/26667_673675d0c7404.jpg", isBookmarked = true),
    MovieShort(id = 4, title = "Astral 3", year = 2015, rating = 10.0, imgUrl = "https://cdn2.rzn.info/data/image/afisha/event/26667/250x230/26667_673675d0c7404.jpg"),
    MovieShort(id = 5, title = "It", year = 2019, rating = 9.9, imgUrl = "https://preview.redd.it/coa1blnnvip31.png?width=640&crop=smart&auto=webp&s=9e3aade822437532e0268548ba96a29a711c7987"),
    MovieShort(id = 6, title = "It: Part Two", year = 2021, rating = 8.7, imgUrl = "https://criticaldarling.com/wp-content/uploads/2019/09/it2-alt-1-sheet.jpg?w=1080", isBookmarked = true)
)

val tagsList = listOf(
    Tag(id = 1, title = "Scary!"),
    Tag(id = 2, title = "NSFW"),
    Tag(id = 3, title = "New!")
)

val moviesList = listOf(
    MovieFull(id = 1, movieShort = popularMoviesList[0], desc = mockupDescription, isWatchable = true, bigImgUrl = "https://variety.com/wp-content/uploads/2018/11/astral.jpg?w=1000&h=500&crop=1", tags = tagsList),
    MovieFull(id = 2, movieShort = popularMoviesList[1], desc = mockupDescription, isWatchable = true, bigImgUrl = "https://m.media-amazon.com/images/M/MV5BMTU4MzYzMzc4N15BMl5BanBnXkFtZTgwMTg3ODA3MzI@._V1_.jpg", tags = tagsList),
    MovieFull(id = 3, movieShort = popularMoviesList[2], desc = mockupDescription, isWatchable = false, bigImgUrl = "https://variety.com/wp-content/uploads/2018/11/astral.jpg?w=1000&h=500&crop=1", tags = tagsList),
    MovieFull(id = 4, movieShort = popularMoviesList[3], desc = mockupDescription, isWatchable = false, bigImgUrl = "https://variety.com/wp-content/uploads/2018/11/astral.jpg?w=1000&h=500&crop=1", tags = tagsList),
    MovieFull(id = 5, movieShort = popularMoviesList[4], desc = mockupDescription, isWatchable = true, bigImgUrl = "https://media.vanityfair.com/photos/59b00a448f880b1dd8acba4a/16:9/w_1280,c_limit/IT-Movie-Review.jpg", tags = tagsList),
    MovieFull(id = 6, movieShort = popularMoviesList[5], desc = mockupDescription, isWatchable = true, bigImgUrl = "https://a.ltrbxd.com/resized/sm/upload/5x/qd/4c/p8/87B6987C-2286-411B-97D4-84FF9520BD91-1200-1200-675-675-crop-000000.jpg?v=3dc1f473e4", tags = tagsList),
)

val usersList = listOf(
    User(id = 1, username = "naburnm8", firstName = "Artem", lastName = "Lint", phoneNumber = "+79996783412", email= "my_email@bk.ru", subscription = defaultSubscription, avatarImgUrl = "https://sun9-75.userapi.com/impg/_EUfPlKTG7rV6H0VbspwSLQEEviPxoBRzteRog/mtHlhs20Wrw.jpg?size=278x278&quality=95&sign=4a55f53e7b7f86d1b521613771add952&type=album")
)




fun getPopularMovies(
    setLoading: (Boolean) -> Unit,
    setError: (String, Boolean) -> Unit,
    coroutineScope: CoroutineScope,
    setData: (List<MovieShort>) -> Unit
) {
    setLoading(true)
    setError("", false)
    coroutineScope.launch {
        try{
            val response = popularMoviesList
            delay(500L)
            setData(response)
        } catch (e: Exception){
            setError(e.message ?: "", true)
            setData(emptyList())
        }
        finally {
            setLoading(false)
        }
    }
}

fun getFavourites(
    setLoading: (Boolean) -> Unit,
    setError: (String, Boolean) -> Unit,
    coroutineScope: CoroutineScope,
    setData: (List<MovieShort>) -> Unit
) {
    setLoading(true)
    setError("", false)
    coroutineScope.launch {
        try{
            val response = popularMoviesList.filter{it.isBookmarked}
            delay(500L)
            setData(response)
        } catch (e: Exception){
            setError(e.message ?: "", true)
            setData(emptyList())
        }
        finally {
            setLoading(false)
        }
    }
}

fun getMovie(
    id: Int,
    setLoading: (Boolean) -> Unit,
    setError: (String, Boolean) -> Unit,
    coroutineScope: CoroutineScope,
    setData: (MovieFull) -> Unit
    ) {
    setLoading(true)
    setError("", false)
    coroutineScope.launch {
        try{
            val response = moviesList[id - 1]
            delay(500L)
            setData(response)
        } catch (e: Exception){
            setError(e.message ?: "", true)
        }
        finally {
            setLoading(false)
        }
    }
}

fun getMoviesByQuery(
    query: String,
    setLoading: (Boolean) -> Unit,
    setError: (String, Boolean) -> Unit,
    coroutineScope: CoroutineScope,
    setData: (List<MovieShort>) -> Unit
) {
    setLoading(true)
    setError("", false)
    coroutineScope.launch {
        try{
            val response = popularMoviesList.filter {it.title.contains(query)}
            delay(500L)
            setData(response)
        } catch (e: Exception){
            setError(e.message ?: "", true)
            setData(emptyList())
        }
        finally {
            setLoading(false)
        }
    }
}

fun getUser(
    id: Int,
    setLoading: (Boolean) -> Unit,
    setError: (String, Boolean) -> Unit,
    coroutineScope: CoroutineScope,
    setData: (User) -> Unit
) {
    setLoading(true)
    setError("", false)
    coroutineScope.launch {
        try{
            val response = usersList[id]
            delay(500L)
            setData(response)
        } catch (e: Exception){
            setError(e.message ?: "", true)
            setData(emptyUser)
        }
        finally {
            setLoading(false)
        }
    }
}