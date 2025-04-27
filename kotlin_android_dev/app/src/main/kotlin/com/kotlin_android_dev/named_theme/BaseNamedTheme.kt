package com.kotlin_android_dev.named_theme

import androidx.compose.ui.graphics.Color

abstract class BaseNamedTheme protected constructor() {
    abstract fun backgroundPrimary(): Color
    abstract fun backgroundSecondary(): Color
    abstract fun border(): Color
    abstract fun brand(): Color
    abstract fun onBrand(): Color
    abstract fun text(): Color
    abstract fun hintText(): Color
}