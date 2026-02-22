package com.example.pulmoguardui.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    val sand = Color(0xFFF6EDE4)
    val almond = Color(0xFFF2E6DA)
    val cocoa = Color(0xFF5B4636)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(sand, almond)))
            .verticalScroll(rememberScrollState()) // ✅ enables scrolling for full screen
            .padding(horizontal = 20.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // 👤 Profile Header
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color(0xFFD8CFC4), shape = RoundedCornerShape(40.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text("AA", color = cocoa, fontWeight = FontWeight.Bold, fontSize = 22.sp)
        }

        Spacer(Modifier.height(12.dp))
        Text("Abdul Azeez", fontWeight = FontWeight.SemiBold, fontSize = 18.sp, color = cocoa)
        Text("COPD, Moderate", fontSize = 14.sp, color = cocoa.copy(.7f))

        Spacer(Modifier.height(30.dp))

        // 🩺 Doctor Info Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White.copy(.9f)),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Dr. John Doe", fontWeight = FontWeight.SemiBold, fontSize = 16.sp, color = cocoa)
                Text("Pulmonologist", fontSize = 14.sp, color = cocoa.copy(.7f))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Inhaler", fontSize = 14.sp, color = cocoa)
                    Switch(
                        checked = true,
                        onCheckedChange = {},
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = cocoa,
                            checkedTrackColor = cocoa.copy(.3f)
                        )
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        // 📝 Notes Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White.copy(.9f)),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Note", fontSize = 14.sp, color = cocoa.copy(.7f))
                Spacer(Modifier.height(6.dp))
                Text("Felt mild tightness after walk today.", color = cocoa, fontSize = 15.sp)
            }
        }

        Spacer(Modifier.height(28.dp))

        // ⚙️ Info Section (scrollable list)
        InfoSectionItem("Help & Settings", cocoa)
        InfoSectionItem("Emergency Contact", cocoa)
        InfoSectionItem("Privacy Policy", cocoa)
        InfoSectionItem("Terms of Use", cocoa)
        InfoSectionItem("Contact Support", cocoa)
    }
}

@Composable
private fun InfoSectionItem(label: String, color: Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.85f)),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp, horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(label, fontSize = 15.sp, color = color, fontWeight = FontWeight.Medium)
        }
    }
}
