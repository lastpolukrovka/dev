package com.kotlin_android_dev.named_composable

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.kotlin_android_dev.named_theme.BaseNamedTheme
import com.kotlin_android_dev.named_theme.DarkTheme
import com.kotlin_android_dev.named_theme.LightTheme

@SuppressLint("ComposableNaming")
@Composable
fun AndroidThemeComposable(): BaseNamedTheme {
    if(isSystemInDarkTheme()) {
        return DarkTheme()
    }
    return LightTheme()
}