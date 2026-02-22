package com.example.pulmoguardui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { PulmoGuardLandingScreen() }
    }
}

@Composable
fun PulmoGuardLandingScreen() {
    val ctx = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.pulmoguard_backdrop),
            contentDescription = "Backdrop",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to PulmoGuard",
                fontSize = 26.sp,
                color = Color(0xFF3B2F2F)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Your personal COPD companion for early detection and care",
                fontSize = 14.sp,
                color = Color(0xFF6B5A53)
            )

            Spacer(Modifier.height(36.dp))

            val offWhite = Color(0xFFFFF5EE)

            Button(
                onClick = { ctx.startActivity(Intent(ctx, SignInActivity::class.java)) },
                colors = ButtonDefaults.buttonColors(containerColor = offWhite),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Sign In", color = Color(0xFF3B2F2F))
            }

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = { ctx.startActivity(Intent(ctx, CreateAccountActivity::class.java)) },
                colors = ButtonDefaults.buttonColors(containerColor = offWhite),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Create Account", color = Color(0xFF3B2F2F))
            }
        }
    }
}
