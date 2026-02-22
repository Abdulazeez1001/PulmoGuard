package com.example.pulmoguardui.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// New, unique names to avoid any overlap with old files
@Composable
fun VitalsPage() { ScreenTemplate(title = "Vitals") }

@Composable
fun InsightsPage() { ScreenTemplate(title = "Insights") }

@Composable
fun ChatPage() { ScreenTemplate(title = "Care Chat") }

@Composable
fun ProfilePage() { ScreenTemplate(title = "Profile") }

@Composable
private fun ScreenTemplate(title: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$title Screen",
            fontSize = 24.sp,
            color = Color(0xFFFAF3E0) // off-white text
        )
    }
}
