package ru.naburnm8.bmstu.android.kotlinhw3.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Home: ImageVector
    get() {
        if (_Home != null) {
            return _Home!!
        }
        _Home = ImageVector.Builder(
            name = "Home",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(240f, 760f)
                horizontalLineToRelative(120f)
                verticalLineToRelative(-240f)
                horizontalLineToRelative(240f)
                verticalLineToRelative(240f)
                horizontalLineToRelative(120f)
                verticalLineToRelative(-360f)
                lineTo(480f, 220f)
                lineTo(240f, 400f)
                close()
                moveToRelative(-80f, 80f)
                verticalLineToRelative(-480f)
                lineToRelative(320f, -240f)
                lineToRelative(320f, 240f)
                verticalLineToRelative(480f)
                horizontalLineTo(520f)
                verticalLineToRelative(-240f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(240f)
                close()
                moveToRelative(320f, -350f)
            }
        }.build()
        return _Home!!
    }

private var _Home: ImageVector? = null

public val Favorite: ImageVector
    get() {
        if (_Favorite != null) {
            return _Favorite!!
        }
        _Favorite = ImageVector.Builder(
            name = "Favorite",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(480f, 840f)
                lineToRelative(-58f, -52f)
                quadToRelative(-101f, -91f, -167f, -157f)
                reflectiveQuadTo(150f, 512.5f)
                reflectiveQuadTo(95.5f, 416f)
                reflectiveQuadTo(80f, 326f)
                quadToRelative(0f, -94f, 63f, -157f)
                reflectiveQuadToRelative(157f, -63f)
                quadToRelative(52f, 0f, 99f, 22f)
                reflectiveQuadToRelative(81f, 62f)
                quadToRelative(34f, -40f, 81f, -62f)
                reflectiveQuadToRelative(99f, -22f)
                quadToRelative(94f, 0f, 157f, 63f)
                reflectiveQuadToRelative(63f, 157f)
                quadToRelative(0f, 46f, -15.5f, 90f)
                reflectiveQuadTo(810f, 512.5f)
                reflectiveQuadTo(705f, 631f)
                reflectiveQuadTo(538f, 788f)
                close()
                moveToRelative(0f, -108f)
                quadToRelative(96f, -86f, 158f, -147.5f)
                reflectiveQuadToRelative(98f, -107f)
                reflectiveQuadToRelative(50f, -81f)
                reflectiveQuadToRelative(14f, -70.5f)
                quadToRelative(0f, -60f, -40f, -100f)
                reflectiveQuadToRelative(-100f, -40f)
                quadToRelative(-47f, 0f, -87f, 26.5f)
                reflectiveQuadTo(518f, 280f)
                horizontalLineToRelative(-76f)
                quadToRelative(-15f, -41f, -55f, -67.5f)
                reflectiveQuadTo(300f, 186f)
                quadToRelative(-60f, 0f, -100f, 40f)
                reflectiveQuadToRelative(-40f, 100f)
                quadToRelative(0f, 35f, 14f, 70.5f)
                reflectiveQuadToRelative(50f, 81f)
                reflectiveQuadToRelative(98f, 107f)
                reflectiveQuadTo(480f, 732f)
                moveToRelative(0f, -273f)
            }
        }.build()
        return _Favorite!!
    }

private var _Favorite: ImageVector? = null

public val Search: ImageVector
    get() {
        if (_Search != null) {
            return _Search!!
        }
        _Search = ImageVector.Builder(
            name = "Search",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(784f, 840f)
                lineTo(532f, 588f)
                quadToRelative(-30f, 24f, -69f, 38f)
                reflectiveQuadToRelative(-83f, 14f)
                quadToRelative(-109f, 0f, -184.5f, -75.5f)
                reflectiveQuadTo(120f, 380f)
                reflectiveQuadToRelative(75.5f, -184.5f)
                reflectiveQuadTo(380f, 120f)
                reflectiveQuadToRelative(184.5f, 75.5f)
                reflectiveQuadTo(640f, 380f)
                quadToRelative(0f, 44f, -14f, 83f)
                reflectiveQuadToRelative(-38f, 69f)
                lineToRelative(252f, 252f)
                close()
                moveTo(380f, 560f)
                quadToRelative(75f, 0f, 127.5f, -52.5f)
                reflectiveQuadTo(560f, 380f)
                reflectiveQuadToRelative(-52.5f, -127.5f)
                reflectiveQuadTo(380f, 200f)
                reflectiveQuadToRelative(-127.5f, 52.5f)
                reflectiveQuadTo(200f, 380f)
                reflectiveQuadToRelative(52.5f, 127.5f)
                reflectiveQuadTo(380f, 560f)
            }
        }.build()
        return _Search!!
    }

private var _Search: ImageVector? = null

public val Ghost: ImageVector
    get() {
        if (_Ghost != null) {
            return _Ghost!!
        }
        _Ghost = ImageVector.Builder(
            name = "Ghost",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(9f, 10f)
                horizontalLineToRelative(0.01f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(15f, 10f)
                horizontalLineToRelative(0.01f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(12f, 2f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -8f, 8f)
                verticalLineToRelative(12f)
                lineToRelative(3f, -3f)
                lineToRelative(2.5f, 2.5f)
                lineTo(12f, 19f)
                lineToRelative(2.5f, 2.5f)
                lineTo(17f, 19f)
                lineToRelative(3f, 3f)
                verticalLineTo(10f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -8f, -8f)
                close()
            }
        }.build()
        return _Ghost!!
    }

private var _Ghost: ImageVector? = null

public val Bookmark: ImageVector
    get() {
        if (_Bookmark != null) {
            return _Bookmark!!
        }
        _Bookmark = ImageVector.Builder(
            name = "Bookmark",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(200f, 840f)
                verticalLineToRelative(-640f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(280f, 120f)
                horizontalLineToRelative(400f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(760f, 200f)
                verticalLineToRelative(640f)
                lineTo(480f, 720f)
                close()
                moveToRelative(80f, -122f)
                lineToRelative(200f, -86f)
                lineToRelative(200f, 86f)
                verticalLineToRelative(-518f)
                horizontalLineTo(280f)
                close()
                moveToRelative(0f, -518f)
                horizontalLineToRelative(400f)
                close()
            }
        }.build()
        return _Bookmark!!
    }

private var _Bookmark: ImageVector? = null


public val Bookmark_check: ImageVector
    get() {
        if (_Bookmark_check != null) {
            return _Bookmark_check!!
        }
        _Bookmark_check = ImageVector.Builder(
            name = "Bookmark_check",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(438f, 560f)
                lineToRelative(198f, -198f)
                lineToRelative(-57f, -56f)
                lineToRelative(-141f, 141f)
                lineToRelative(-57f, -57f)
                lineToRelative(-57f, 57f)
                close()
                moveTo(200f, 840f)
                verticalLineToRelative(-640f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(280f, 120f)
                horizontalLineToRelative(400f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(760f, 200f)
                verticalLineToRelative(640f)
                lineTo(480f, 720f)
                close()
                moveToRelative(80f, -122f)
                lineToRelative(200f, -86f)
                lineToRelative(200f, 86f)
                verticalLineToRelative(-518f)
                horizontalLineTo(280f)
                close()
                moveToRelative(0f, -518f)
                horizontalLineToRelative(400f)
                close()
            }
        }.build()
        return _Bookmark_check!!
    }

private var _Bookmark_check: ImageVector? = null


public val Bookmarks: ImageVector
    get() {
        if (_Bookmarks != null) {
            return _Bookmarks!!
        }
        _Bookmarks = ImageVector.Builder(
            name = "Bookmarks",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(120f, 920f)
                verticalLineToRelative(-640f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(200f, 200f)
                horizontalLineToRelative(400f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(680f, 280f)
                verticalLineToRelative(640f)
                lineTo(400f, 800f)
                close()
                moveToRelative(80f, -122f)
                lineToRelative(200f, -86f)
                lineToRelative(200f, 86f)
                verticalLineToRelative(-518f)
                horizontalLineTo(200f)
                close()
                moveToRelative(560f, 2f)
                verticalLineToRelative(-680f)
                horizontalLineTo(240f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(520f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(840f, 120f)
                verticalLineToRelative(680f)
                close()
                moveTo(200f, 280f)
                horizontalLineToRelative(400f)
                close()
            }
        }.build()
        return _Bookmarks!!
    }

private var _Bookmarks: ImageVector? = null





