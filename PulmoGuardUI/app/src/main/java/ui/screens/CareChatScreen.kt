package com.example.pulmoguardui.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CareChatScreen(navController: NavController? = null) {
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

            Text("Care Chat", color = coffeeBrown, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text("Connect with your care provider instantly", color = coffeeBrown.copy(0.7f), fontSize = 14.sp)
            Spacer(modifier = Modifier.height(18.dp))

            // Doctor card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(coffeeBrown),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Dr.", color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {
                        Text("Dr. John Doe", fontSize = 17.sp, color = coffeeBrown, fontWeight = FontWeight.Bold)
                        Text("Pulmonologist", fontSize = 14.sp, color = coffeeBrown.copy(0.7f))
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Chat bubbles
            ChatBubble("Hello Abdul! How are your breathing levels this week?", fromDoctor = true)
            ChatBubble("I'm feeling good, thank you. No major tightness or fatigue.", fromDoctor = false)
            ChatBubble("That's great! Keep using your inhaler daily. Let's review your latest FEV₁ values tomorrow.", fromDoctor = true)

            Spacer(modifier = Modifier.height(24.dp))

            // Generate Health Report button
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(55.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(coffeeBrown)
                    .clickable {
                        navController?.navigate("healthReport")
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Generate Health Report",
                    fontSize = 15.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun ChatBubble(text: String, fromDoctor: Boolean) {
    val coffeeBrown = Color(0xFF6B4F3A)
    val bubbleColor = if (fromDoctor) Color.White else Color(0xFFF4E3D0)
    val alignment = if (fromDoctor) Arrangement.Start else Arrangement.End

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp),
        horizontalArrangement = alignment
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = bubbleColor),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Text(
                text = text,
                color = coffeeBrown,
                modifier = Modifier
                    .padding(horizontal = 14.dp, vertical = 10.dp)
                    .widthIn(max = 260.dp),
                fontSize = 15.sp,
                textAlign = TextAlign.Start
            )
        }
    }
}
