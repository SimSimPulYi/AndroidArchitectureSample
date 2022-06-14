package com.saehyun.common_design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = primaryBlue,
    primaryVariant = primaryVariantColor,
    secondary = secondaryColor,
    secondaryVariant = secondaryVariantColor,
    background = darkBackgroundColor,
    surface = surfaceColor,
    error = errorColor,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.Red
)

private val LightColorPalette = lightColors(
    primary = primaryBlue,
    primaryVariant = primaryVariantColor,
    secondary = secondaryColor,
    secondaryVariant = secondaryVariantColor,
    background = backgroundColor,
    surface = surfaceColor,
    error = errorColor,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.Red
)

@Composable
fun SampleTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = SampleTypography,
        shapes = Shapes,
        content = content
    )
}