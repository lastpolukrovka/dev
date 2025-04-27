package com.kotlin_android_dev.named_theme

import androidx.compose.ui.graphics.Color

class LightTheme : BaseNamedTheme() {
    override fun backgroundPrimary(): Color {
        return Color(255,255,255)
    }

    override fun backgroundSecondary(): Color {
        return Color(245,247,250)
    }

    override fun border(): Color {
        return Color(230,234,239)
    }

    override fun brand(): Color {
        return Color(255,119,0)
    }

    override fun onBrand(): Color {
        return Color(255,255,255)
    }

    override fun text(): Color {
        return Color(34,34,34)
    }

    override fun hintText(): Color {
        return Color(160,160,160)
    }
}