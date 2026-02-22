package com.example.pulmoguardui.ui.navigation

import androidx.annotation.DrawableRes
import com.example.pulmoguardui.R

/**
 * Defines the navigation destinations (tabs) in PulmoGuard.
 * Each Screen has a route, a title, and an associated icon resource.
 */

sealed class Screen(
    val route: String,
    val title: String,
    @DrawableRes val iconRes: Int
) {

    // 🫁 Vitals - respiratory metrics and FEV1 values
    object Vitals : Screen(
        route = "vitals",
        title = "Vitals",
        iconRes = R.drawable.ic_heart // 💡 ensure this file exists
    )

    // 📊 Insights - weekly/monthly charts and analysis
    object Insights : Screen(
        route = "insights",
        title = "Insights",
        iconRes = R.drawable.ic_chart // 💡 ensure you create this icon
    )

    // 💬 Care Chat - chat interface with clinicians
    object CareChat : Screen(
        route = "care_chat",
        title = "Care Chat",
        iconRes = R.drawable.ic_chat // 💡 ensure you create this icon
    )

    // 👤 Profile - user info, settings, reports
    object Profile : Screen(
        route = "profile",
        title = "Profile",
        iconRes = R.drawable.ic_profile // 💡 ensure you create this icon
    )
}
