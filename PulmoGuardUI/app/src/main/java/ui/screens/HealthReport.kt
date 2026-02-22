package com.example.pulmoguardui.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HealthReportScreen(navController: NavController? = null) {
    val coffeeBrown = Color(0xFF6B4F3A)
    val bgGradient = Brush.verticalGradient(listOf(Color(0xFFFFF4E6), Color(0xFFF8E9DA)))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bgGradient)
            .padding(horizontal = 20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(25.dp))

            // Back button
            TextButton(onClick = { navController?.popBackStack() }, modifier = Modifier.align(Alignment.Start)) {
                Text("← Back", color = coffeeBrown, fontSize = 15.sp, fontWeight = FontWeight.Medium)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text("PulmoGuard Health Report", color = coffeeBrown, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text("Generated: Nov 2 2025", color = coffeeBrown.copy(alpha = 0.6f), fontSize = 13.sp)

            Spacer(modifier = Modifier.height(20.dp))

            // LUNG HEALTH SUMMARY
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text("Lung Health Summary", color = coffeeBrown, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("FEV₁ Average: 2.85 L/sec    ↑ Stable", color = coffeeBrown, fontSize = 15.sp)
                    Text("Trend: +5 % since last week", color = coffeeBrown.copy(alpha = 0.8f), fontSize = 13.sp)
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // VITALS OVERVIEW
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                VitalReportCard("Heart Rate", "76 bpm", "Normal", coffeeBrown)
                VitalReportCard("O₂ Level", "96 %", "Healthy", coffeeBrown)
                VitalReportCard("Steps", "6,230", "Active", coffeeBrown)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // DOCTOR’S NOTE
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF5E8DD)),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text("Dr. John Doe — Pulmonologist", color = coffeeBrown, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        "Your respiratory performance remains stable. Continue your daily inhaler routine and light exercises. " +
                                "Schedule your next follow-up on Nov 6 2025.",
                        color = coffeeBrown.copy(alpha = 0.9f),
                        fontSize = 14.sp,
                        lineHeight = 20.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // DOWNLOAD BUTTON
            Button(
                onClick = { /* TODO: Export to PDF or Share */ },
                colors = ButtonDefaults.buttonColors(containerColor = coffeeBrown),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .height(50.dp)
            ) {
                Text("Download Detailed Report", color = Color.White, fontSize = 15.sp)
            }
        }
    }
}

@Composable
fun VitalReportCard(title: String, value: String, status: String, color: Color) {
    Card(
        modifier = Modifier
            .width(105.dp)
            .height(90.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(title, color = color.copy(alpha = 0.8f), fontSize = 13.sp)
            Text(value, color = color, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(status, color = color.copy(alpha = 0.6f), fontSize = 12.sp)
        }
    }
}
