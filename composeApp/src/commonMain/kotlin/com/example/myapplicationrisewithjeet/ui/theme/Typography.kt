package com.example.myapplicationrisewithjeet.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import myapplicationrisewithjeet.composeapp.generated.resources.Res
import myapplicationrisewithjeet.composeapp.generated.resources.dm_sans_bold
import myapplicationrisewithjeet.composeapp.generated.resources.dm_sans_regular
import myapplicationrisewithjeet.composeapp.generated.resources.playfair_display_regular
import org.jetbrains.compose.resources.Font

@Composable
fun playfairDisplayFamily() = FontFamily(
    Font(Res.font.playfair_display_regular, weight = FontWeight.Normal)
)

@Composable
fun dmSansFamily() = FontFamily(
    Font(Res.font.dm_sans_regular, weight = FontWeight.Normal),
    Font(Res.font.dm_sans_bold, weight = FontWeight.Bold)
)
