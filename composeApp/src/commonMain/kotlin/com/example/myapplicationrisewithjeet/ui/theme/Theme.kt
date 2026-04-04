package com.example.myapplicationrisewithjeet.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val RiseWithJeetColorScheme = darkColorScheme(
    primary            = GoldAccent,
    onPrimary          = DarkBg,
    primaryContainer   = DarkCard,
    onPrimaryContainer = GoldLight,
    secondary          = White,
    onSecondary        = DarkBg,
    secondaryContainer = DarkCardAlt,
    onSecondaryContainer = White70,
    background         = DarkBg,
    onBackground       = White,
    surface            = DarkCard,
    onSurface          = White,
    onSurfaceVariant   = White70,
    outline            = DarkBorder,
)

@Composable
fun RiseWithJeetTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = RiseWithJeetColorScheme,
        content = content
    )
}
