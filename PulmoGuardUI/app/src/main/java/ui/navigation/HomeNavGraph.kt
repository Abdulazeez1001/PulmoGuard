package com.example.pulmoguardui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pulmoguardui.ui.screens.VitalScreen
import com.example.pulmoguardui.ui.screens.InsightsScreen
import com.example.pulmoguardui.ui.screens.CareChatScreen
import com.example.pulmoguardui.ui.screens.HealthReportScreen
import com.example.pulmoguardui.ui.screens.ProfileScreen

/**
 * Main Navigation Graph for the PulmoGuard UI app.
 * Handles all 4 tabs + nested screens.
 */
@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Vitals.route
    ) {
        // 🫁 Vitals
        composable(Screen.Vitals.route) {
            VitalScreen()
        }

        // 📊 Insights
        composable(Screen.Insights.route) {
            InsightsScreen()
        }

        // 💬 Care Chat
        composable(Screen.CareChat.route) {
            CareChatScreen(navController)
        }

        // 👤 Profile
        composable(Screen.Profile.route) {
            ProfileScreen()
        }

        // 🩺 Health Report (nested under Care Chat)
        composable("healthReport") {
            HealthReportScreen(navController)
        }
    }
}
