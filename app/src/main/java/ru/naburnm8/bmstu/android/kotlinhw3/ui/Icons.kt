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

public val Sparkle: ImageVector
    get() {
        if (_Sparkle != null) {
            return _Sparkle!!
        }
        _Sparkle = ImageVector.Builder(
            name = "Sparkle",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(5.39804f, 10.8069f)
                curveTo(5.5743f, 10.9312f, 5.7848f, 10.9977f, 6.0004f, 10.9973f)
                curveTo(6.2163f, 10.9975f, 6.4269f, 10.93f, 6.6024f, 10.8043f)
                curveTo(6.7799f, 10.6739f, 6.9146f, 10.4936f, 6.9894f, 10.2863f)
                lineTo(7.43643f, 8.91335f)
                curveTo(7.5509f, 8.5691f, 7.7439f, 8.2561f, 8.0003f, 7.9994f)
                curveTo(8.2567f, 7.7427f, 8.5693f, 7.5492f, 8.9134f, 7.4344f)
                lineTo(10.3044f, 6.98335f)
                curveTo(10.4564f, 6.929f, 10.5936f, 6.8402f, 10.7055f, 6.7239f)
                curveTo(10.8174f, 6.6076f, 10.9008f, 6.467f, 10.9492f, 6.3131f)
                curveTo(10.9977f, 6.1592f, 11.0098f, 5.9961f, 10.9847f, 5.8367f)
                curveTo(10.9596f, 5.6773f, 10.8979f, 5.5259f, 10.8044f, 5.3944f)
                curveTo(10.6703f, 5.2084f, 10.4794f, 5.0712f, 10.2604f, 5.0034f)
                lineTo(8.88543f, 4.55635f)
                curveTo(8.5409f, 4.4421f, 8.2278f, 4.2492f, 7.9709f, 3.9928f)
                curveTo(7.714f, 3.7364f, 7.5203f, 3.4236f, 7.4054f, 3.0793f)
                lineTo(6.95343f, 1.69135f)
                curveTo(6.8811f, 1.489f, 6.7476f, 1.3143f, 6.5714f, 1.1913f)
                curveTo(6.4388f, 1.0976f, 6.2861f, 1.0361f, 6.1255f, 1.0118f)
                curveTo(5.9649f, 0.9874f, 5.8008f, 1.0009f, 5.6464f, 1.0511f)
                curveTo(5.4919f, 1.1013f, 5.3513f, 1.1868f, 5.2356f, 1.301f)
                curveTo(5.12f, 1.415f, 5.0327f, 1.5545f, 4.9804f, 1.7084f)
                lineTo(4.52343f, 3.10835f)
                curveTo(4.4088f, 3.4432f, 4.2197f, 3.7476f, 3.9702f, 3.9986f)
                curveTo(3.7208f, 4.2496f, 3.4175f, 4.4407f, 3.0834f, 4.5573f)
                lineTo(1.69243f, 5.00535f)
                curveTo(1.5407f, 5.0597f, 1.4035f, 5.1485f, 1.2918f, 5.2647f)
                curveTo(1.18f, 5.381f, 1.0967f, 5.5214f, 1.0482f, 5.6752f)
                curveTo(0.9998f, 5.829f, 0.9876f, 5.9919f, 1.0127f, 6.1512f)
                curveTo(1.0377f, 6.3105f, 1.0992f, 6.4618f, 1.1924f, 6.5934f)
                curveTo(1.3203f, 6.7728f, 1.501f, 6.9078f, 1.7094f, 6.9794f)
                lineTo(3.08343f, 7.42435f)
                curveTo(3.5235f, 7.5708f, 3.91f, 7.8452f, 4.1934f, 8.2124f)
                curveTo(4.3559f, 8.423f, 4.4813f, 8.6597f, 4.5644f, 8.9123f)
                lineTo(5.01643f, 10.3033f)
                curveTo(5.0885f, 10.5066f, 5.2218f, 10.6826f, 5.398f, 10.8069f)
                close()
                moveTo(5.48343f, 3.39235f)
                lineTo(6.01043f, 2.01535f)
                lineTo(6.44943f, 3.39235f)
                curveTo(6.6131f, 3.8855f, 6.8899f, 4.3335f, 7.2577f, 4.7006f)
                curveTo(7.6254f, 5.0677f, 8.074f, 5.3436f, 8.5674f, 5.5064f)
                lineTo(9.97343f, 6.03535f)
                lineTo(8.59143f, 6.48335f)
                curveTo(8.0987f, 6.6476f, 7.6509f, 6.9245f, 7.2838f, 7.292f)
                curveTo(6.9167f, 7.6594f, 6.6403f, 8.1074f, 6.4764f, 8.6004f)
                lineTo(5.95343f, 9.97835f)
                lineTo(5.50443f, 8.59935f)
                curveTo(5.3434f, 8.1061f, 5.0694f, 7.6572f, 4.7044f, 7.2884f)
                curveTo(4.3356f, 6.9203f, 3.8865f, 6.6427f, 3.3924f, 6.4774f)
                lineTo(2.01443f, 5.95535f)
                lineTo(3.40043f, 5.50535f)
                curveTo(3.8867f, 5.3367f, 4.3277f, 5.0586f, 4.6894f, 4.6924f)
                curveTo(5.049f, 4.3246f, 5.3205f, 3.8802f, 5.4834f, 3.3923f)
                close()
                moveTo(11.5353f, 14.8494f)
                curveTo(11.6713f, 14.9456f, 11.8337f, 14.9973f, 12.0003f, 14.9974f)
                curveTo(12.1654f, 14.9974f, 12.3264f, 14.9464f, 12.4613f, 14.8514f)
                curveTo(12.6008f, 14.7529f, 12.7058f, 14.6129f, 12.7613f, 14.4514f)
                lineTo(13.0093f, 13.6894f)
                curveTo(13.0625f, 13.5309f, 13.1515f, 13.3869f, 13.2693f, 13.2684f)
                curveTo(13.3867f, 13.1498f, 13.5307f, 13.0611f, 13.6893f, 13.0094f)
                lineTo(14.4613f, 12.7574f)
                curveTo(14.619f, 12.7029f, 14.7557f, 12.6004f, 14.8523f, 12.4644f)
                curveTo(14.9257f, 12.3614f, 14.9736f, 12.2424f, 14.9921f, 12.1173f)
                curveTo(15.0106f, 11.9922f, 14.9992f, 11.8645f, 14.9588f, 11.7447f)
                curveTo(14.9184f, 11.6249f, 14.8501f, 11.5163f, 14.7597f, 11.428f)
                curveTo(14.6692f, 11.3396f, 14.5591f, 11.2739f, 14.4383f, 11.2364f)
                lineTo(13.6743f, 10.9874f)
                curveTo(13.5162f, 10.9348f, 13.3724f, 10.8462f, 13.2544f, 10.7285f)
                curveTo(13.1364f, 10.6109f, 13.0473f, 10.4674f, 12.9943f, 10.3094f)
                lineTo(12.7423f, 9.53638f)
                curveTo(12.6886f, 9.3785f, 12.586f, 9.2419f, 12.4493f, 9.1464f)
                curveTo(12.3473f, 9.0734f, 12.2295f, 9.0255f, 12.1056f, 9.0064f)
                curveTo(11.9816f, 8.9874f, 11.8549f, 8.9977f, 11.7357f, 9.0366f)
                curveTo(11.6164f, 9.0756f, 11.508f, 9.142f, 11.4192f, 9.2305f)
                curveTo(11.3304f, 9.3191f, 11.2636f, 9.4273f, 11.2243f, 9.5464f)
                lineTo(10.9773f, 10.3084f)
                curveTo(10.925f, 10.466f, 10.8375f, 10.6097f, 10.7213f, 10.7284f)
                curveTo(10.6066f, 10.8449f, 10.4667f, 10.9335f, 10.3123f, 10.9874f)
                lineTo(9.53931f, 11.2394f)
                curveTo(9.3803f, 11.2933f, 9.2422f, 11.3959f, 9.1447f, 11.5326f)
                curveTo(9.0472f, 11.6694f, 8.9952f, 11.8333f, 8.9961f, 12.0013f)
                curveTo(8.997f, 12.1692f, 9.0507f, 12.3326f, 9.1496f, 12.4683f)
                curveTo(9.2486f, 12.604f, 9.3877f, 12.7051f, 9.5473f, 12.7574f)
                lineTo(10.3103f, 13.0044f)
                curveTo(10.4692f, 13.0578f, 10.6136f, 13.1471f, 10.7323f, 13.2654f)
                curveTo(10.8505f, 13.3836f, 10.939f, 13.5283f, 10.9903f, 13.6874f)
                lineTo(11.2433f, 14.4614f)
                curveTo(11.2981f, 14.6178f, 11.4001f, 14.7534f, 11.5353f, 14.8494f)
                close()
                moveTo(10.6223f, 12.0564f)
                lineTo(10.4433f, 11.9974f)
                lineTo(10.6273f, 11.9334f)
                curveTo(10.9291f, 11.8284f, 11.2027f, 11.6556f, 11.4273f, 11.4284f)
                curveTo(11.6537f, 11.1994f, 11.8248f, 10.9216f, 11.9273f, 10.6164f)
                lineTo(11.9853f, 10.4384f)
                lineTo(12.0443f, 10.6194f)
                curveTo(12.1463f, 10.9261f, 12.3185f, 11.2047f, 12.5471f, 11.4332f)
                curveTo(12.7757f, 11.6617f, 13.0545f, 11.8336f, 13.3613f, 11.9354f)
                lineTo(13.5563f, 11.9984f)
                lineTo(13.3763f, 12.0574f)
                curveTo(13.0689f, 12.1596f, 12.7898f, 12.3322f, 12.5611f, 12.5616f)
                curveTo(12.3324f, 12.791f, 12.1606f, 13.0707f, 12.0593f, 13.3784f)
                lineTo(12.0003f, 13.5594f)
                lineTo(11.9423f, 13.3784f)
                curveTo(11.8409f, 13.0702f, 11.6687f, 12.7901f, 11.4394f, 12.5605f)
                curveTo(11.2102f, 12.3309f, 10.9303f, 12.1583f, 10.6223f, 12.0564f)
                close()
            }
        }.build()
        return _Sparkle!!
    }

private var _Sparkle: ImageVector? = null





