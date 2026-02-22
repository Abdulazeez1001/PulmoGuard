package com.example.pulmoguardui.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val PulmoGuardLightColors = lightColorScheme(
    primary = PeachAccent,
    secondary = BeigePrimary,
    background = OffWhite,
    surface = OffWhite,
    onPrimary = TextDark,
    onBackground = TextDark,
    onSurface = TextDark
)

@Composable
fun PulmoGuardUITheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = PulmoGuardLightColors,
        typography = Typography,
        content = content
    )
}
