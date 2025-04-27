package com.kotlin_android_dev.named_composable

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotlin_android_dev.named_utility.KeysFontFamilyUtility

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun PlatformComposable(
    callbackWTablet: @Composable () -> Unit,
    callbackWLargeTablet: @Composable () -> Unit,
    content: @Composable () -> Unit)
{
    BoxWithConstraints {
        when {
            maxWidth >= 600.dp && maxWidth <= 900.dp -> callbackWTablet()
            maxWidth >= 901.dp -> callbackWLargeTablet()
            else -> content()
        }
    }
}

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun TypographyComposable(color: Color): Typography {
    var typography = remember { Typography() }
    BoxWithConstraints {
        when {
            maxWidth >= 600.dp && maxWidth <= 900.dp -> {
                typography = Typography(
                    headlineMedium = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = KeysFontFamilyUtility.INTER_QQ_SEMI_BOLD,
                        letterSpacing = 0.sp,
                        color = color
                    ),
                    bodyLarge = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = KeysFontFamilyUtility.INTER_QQ_MEDIUM,
                        letterSpacing = 0.sp,
                        color = color
                    ),
                    bodyMedium = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = KeysFontFamilyUtility.INTER_QQ_MEDIUM,
                        letterSpacing = 0.sp,
                        color = color
                    ),
                    bodySmall = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = KeysFontFamilyUtility.INTER_QQ_REGULAR,
                        letterSpacing = 0.sp,
                        color = color
                    ),
                )
            }
            maxWidth >= 901.dp -> {
                typography = Typography(
                    headlineMedium = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = KeysFontFamilyUtility.INTER_QQ_SEMI_BOLD,
                        letterSpacing = 0.sp,
                        color = color
                    ),
                    bodyLarge = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = KeysFontFamilyUtility.INTER_QQ_MEDIUM,
                        letterSpacing = 0.sp,
                        color = color
                    ),
                    bodyMedium = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = KeysFontFamilyUtility.INTER_QQ_MEDIUM,
                        letterSpacing = 0.sp,
                        color = color
                    ),
                    bodySmall = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = KeysFontFamilyUtility.INTER_QQ_REGULAR,
                        letterSpacing = 0.sp,
                        color = color
                    ),
                )
            }
            else -> {
                typography = Typography(
                    headlineMedium = TextStyle(
                        fontSize = 26.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = KeysFontFamilyUtility.INTER_QQ_SEMI_BOLD,
                        letterSpacing = 0.sp,
                        color = color
                    ),
                    bodyLarge = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = KeysFontFamilyUtility.INTER_QQ_MEDIUM,
                        letterSpacing = 0.sp,
                        color = color
                    ),
                    bodyMedium = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = KeysFontFamilyUtility.INTER_QQ_MEDIUM,
                        letterSpacing = 0.sp,
                        color = color
                    ),
                    bodySmall = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = KeysFontFamilyUtility.INTER_QQ_REGULAR,
                        letterSpacing = 0.sp,
                        color = color
                    ),
                )
            }
        }
    }
    return typography
}