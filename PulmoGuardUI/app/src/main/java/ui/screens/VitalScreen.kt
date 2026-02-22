package com.example.pulmoguardui.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VitalScreen() {
    val sand = Color(0xFFF6EDE4)
    val almond = Color(0xFFF2E6DA)
    val cocoa = Color(0xFF5B4636)
    val gaugeBg = Color(0xFFE8D7C9)
    val gaugeFill = Color(0xFF5B4636)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(sand, almond)))
            .padding(horizontal = 24.dp, vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Good Afternoon, Abdul 👋",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = cocoa
        )
        Spacer(Modifier.height(6.dp))
        Text(
            text = "Breathing looks stable today.",
            color = cocoa.copy(alpha = 0.7f),
            fontSize = 14.sp
        )

        Spacer(Modifier.height(40.dp))

        // 🌀 Circular FEV1 Gauge
        Box(contentAlignment = Alignment.Center) {
            Canvas(modifier = Modifier.size(160.dp)) {
                drawArc(
                    color = gaugeBg,
                    startAngle = 135f,
                    sweepAngle = 270f,
                    useCenter = false,
                    style = Stroke(width = 22f, cap = StrokeCap.Round)
                )
                drawArc(
                    color = gaugeFill,
                    startAngle = 135f,
                    sweepAngle = 240f, // progress arc
                    useCenter = false,
                    style = Stroke(width = 22f, cap = StrokeCap.Round)
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "2.81", fontSize = 36.sp, fontWeight = FontWeight.Bold, color = cocoa)
                Text(text = "L/sec", fontSize = 14.sp, color = cocoa.copy(.8f))
                Text(text = "FEV₁", fontSize = 14.sp, color = cocoa.copy(.6f))
            }
        }

        Spacer(Modifier.height(40.dp))

        // 🩶 Metric cards row — handle weights here, not inside MetricCard()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            MetricCard(title = "Heart Rate", value = "78 bpm", fg = cocoa, modifier = Modifier.weight(1f))
            MetricCard(title = "O₂ Level", value = "96%", fg = cocoa, modifier = Modifier.weight(1f))
            MetricCard(title = "Steps", value = "6,482", fg = cocoa, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun MetricCard(title: String, value: String, fg: Color, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.height(80.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(.9f)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = title, color = fg.copy(.7f), fontSize = 13.sp)
            Spacer(Modifier.height(6.dp))
            Text(text = value, color = fg, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}
