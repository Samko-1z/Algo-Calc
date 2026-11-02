package com.example.calculatorapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary       = DarkPrimary,
    onPrimary     = DarkOnPrimary,
    secondary     = DarkSecondary,
    onSecondary   = DarkOnSecondary,
    tertiary      = DarkTertiary,
    onTertiary    = DarkOnTertiary,
    background    = DarkBackground,
    onBackground  = DarkOnBackground,
    surface       = DarkSurface,
    onSurface     = DarkOnSurface,
)

private val LightColorScheme = lightColorScheme(
    primary       = LightPrimary,
    onPrimary     = LightOnPrimary,
    secondary     = LightSecondary,
    onSecondary   = LightOnSecondary,
    tertiary      = LightTertiary,
    onTertiary    = LightOnTertiary,
    background    = LightBackground,
    onBackground  = LightOnBackground,
    surface       = LightSurface,
    onSurface     = LightOnSurface,
)

@Composable
fun CalculatorAppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography  = Typography,
        content     = content
    )
}
