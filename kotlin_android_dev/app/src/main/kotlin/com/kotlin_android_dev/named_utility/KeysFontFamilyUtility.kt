package com.kotlin_android_dev.named_utility

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.kotlin_android_dev.R

class KeysFontFamilyUtility private constructor() {
    companion object {
        /* Inter */
        val INTER_QQ_SEMI_BOLD: FontFamily = FontFamily(
            Font(R.font.inter_18pt_semi_bold, FontWeight.SemiBold),
            Font(R.font.inter_24pt_semi_bold, FontWeight.SemiBold),
            Font(R.font.inter_28pt_semi_bold, FontWeight.SemiBold)
        )
        val INTER_QQ_MEDIUM: FontFamily = FontFamily(
            Font(R.font.inter_18pt_medium, FontWeight.Medium),
            Font(R.font.inter_24pt_medium, FontWeight.Medium),
            Font(R.font.inter_28pt_medium, FontWeight.Medium)
        )
        val INTER_QQ_REGULAR: FontFamily = FontFamily(
            Font(R.font.inter_18pt_regular, FontWeight.Normal),
            Font(R.font.inter_24pt_regular, FontWeight.Normal),
            Font(R.font.inter_28pt_regular, FontWeight.Normal)
        )
    }
}