package com.example.pulmoguardui.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pulmoguardui.R
import com.example.pulmoguardui.ui.navigation.HomeNavGraph
import com.example.pulmoguardui.ui.navigation.Screen

@Composable
fun HomeScaffold() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFFFFF8F3), Color(0xFFFBECE1))
                    )
                )
        ) {
            // Backdrop
            Image(
                painter = painterResource(id = R.drawable.pulmoguard_backdrop),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Navigation graph
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                HomeNavGraph(navController = navController)
            }
        }
    }
}

@Composable
fun BottomBar(navController: androidx.navigation.NavHostController) {
    val items = listOf(
        Screen.Vitals,
        Screen.Insights,
        Screen.CareChat,
        Screen.Profile
    )

    // 🎨 New Pastel Tones
    val softBase = Color(0xFFF4E1D2)     // blush beige
    val activeTint = Color(0xFFD7BFAE)   // subtle highlight
    val textTint = Color(0xFF5E4B43)     // warm muted brown

    NavigationBar(
        containerColor = softBase,
        contentColor = textTint
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination: NavDestination? = navBackStackEntry?.destination

        items.forEach { screen ->
            val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = screen.iconRes),
                        contentDescription = screen.title,
                        tint = if (selected) textTint else textTint.copy(alpha = 0.5f)
                    )
                },
                label = {
                    Text(
                        text = screen.title,
                        fontSize = 12.sp,
                        fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                        color = if (selected) textTint else textTint.copy(alpha = 0.6f)
                    )
                },
                selected = selected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = if (selected) activeTint.copy(alpha = 0.3f) else Color.Transparent
                )
            )
        }
    }
}
