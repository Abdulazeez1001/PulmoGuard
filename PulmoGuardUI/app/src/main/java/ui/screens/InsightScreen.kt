package com.example.pulmoguardui.ui.screens

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InsightsScreen() {
    // 🌤️ soft gradient and color scheme
    val sand = Color(0xFFF6EDE4)
    val almond = Color(0xFFF2E6DA)
    val cocoa = Color(0xFF5B4636)
    val barFill = Color(0xFFE8D7C9)

    var tabIndex by remember { mutableStateOf(1) } // Weekly default

    // FEV₁ sample data
    val dataToday = listOf(2.7f, 2.9f, 2.8f, 3.0f)
    val dataWeek = listOf(2.5f, 2.7f, 2.9f, 2.85f, 2.95f, 2.9f, 3.1f)
    val dataMonth = listOf(2.4f, 2.55f, 2.7f, 2.8f, 3.0f) // only 5 weeks for a month ✅

    val (activeData, xLabels) = when (tabIndex) {
        0 -> dataToday to listOf("8a", "12p", "4p", "8p")
        1 -> dataWeek to listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
        else -> dataMonth to listOf("W1", "W2", "W3", "W4")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(sand, almond)))
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Insights", fontSize = 22.sp, fontWeight = FontWeight.SemiBold, color = cocoa)
        Spacer(Modifier.height(4.dp))
        Text("Your lung health trend", color = cocoa.copy(.7f), fontSize = 14.sp)

        Spacer(Modifier.height(16.dp))

        // 📊 Tabs for day / week / month
        TabRow(
            selectedTabIndex = tabIndex,
            containerColor = Color.Transparent,
            contentColor = cocoa,
            indicator = { positions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(positions[tabIndex]).height(3.dp),
                    color = cocoa
                )
            },
            divider = { Divider(color = cocoa.copy(.12f)) }
        ) {
            listOf("Today", "Weekly", "Monthly").forEachIndexed { i, title ->
                Tab(
                    selected = tabIndex == i,
                    onClick = { tabIndex = i },
                    text = {
                        Text(
                            text = title,
                            fontWeight = if (tabIndex == i) FontWeight.SemiBold else FontWeight.Normal,
                            color = if (tabIndex == i) cocoa else cocoa.copy(.55f)
                        )
                    }
                )
            }
        }

        Spacer(Modifier.height(20.dp))

        // 📈 Graph animation when switching
        Crossfade(targetState = tabIndex, label = "") { idx ->
            val showBars = idx != 0
            TrendChart(
                data = activeData,
                labels = xLabels.take(activeData.size),
                lineColor = cocoa,
                barColor = barFill,
                height = 180.dp,
                showBars = showBars
            )
        }

        Spacer(Modifier.height(16.dp))

        // 🪶 Summary banner
        SummaryBanner(
            text = "You breathed easier this ${
                when (tabIndex) {
                    1 -> "week"
                    2 -> "month"
                    else -> "day"
                }
            } – avg FEV₁ ${String.format("%.2f", activeData.averageSafe())} L/sec at 95% O₂.",
            bg = Color.White.copy(.85f),
            fg = cocoa
        )

        Spacer(Modifier.height(24.dp))

        // 📊 Stat cards row
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            InsightStatCard(
                title = "Avg. FEV₁",
                value = "${String.format("%.2f", activeData.averageSafe())} L/sec",
                fg = cocoa,
                modifier = Modifier.weight(1f)
            )
            InsightStatCard("Avg. Steps", "6,240", cocoa, Modifier.weight(1f))
            InsightStatCard("Avg. HR", "76 bpm", cocoa, Modifier.weight(1f))
        }

        Spacer(Modifier.height(28.dp))
    }
}

@Composable
private fun TrendChart(
    data: List<Float>,
    labels: List<String>,
    lineColor: Color,
    barColor: Color,
    height: Dp,
    showBars: Boolean
) {
    val min = data.minOrNull() ?: 0f
    val max = data.maxOrNull() ?: 1f
    val range = (max - min).takeIf { it != 0f } ?: 1f

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .padding(horizontal = 8.dp)
        ) {
            val w = size.width
            val h = size.height
            val stepX = if (data.size > 1) w / (data.size - 1) else w

            if (showBars) {
                val barW = (w / (data.size * 1.6f)).coerceAtMost(28f)
                data.forEachIndexed { i, v ->
                    val x = stepX * i
                    val y = h - ((v - min) / range) * h
                    drawLine(
                        color = barColor,
                        start = Offset(x, h),
                        end = Offset(x, y),
                        strokeWidth = barW,
                        cap = StrokeCap.Round
                    )
                }
            }

            val path = Path().apply {
                data.forEachIndexed { i, v ->
                    val x = stepX * i
                    val y = h - ((v - min) / range) * h
                    if (i == 0) moveTo(x, y) else lineTo(x, y)
                }
            }
            drawPath(path, color = lineColor, style = Stroke(width = 4f, cap = StrokeCap.Round))

            data.forEachIndexed { i, v ->
                val x = stepX * i
                val y = h - ((v - min) / range) * h
                drawCircle(color = lineColor, radius = 5f, center = Offset(x, y))
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            labels.forEach { Text(it, color = Color(0xFF5B4636).copy(.75f), fontSize = 12.sp) }
        }
    }
}

@Composable
private fun SummaryBanner(text: String, bg: Color, fg: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = bg),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Text(
            text = text,
            color = fg,
            fontSize = 14.sp,
            modifier = Modifier.padding(14.dp)
        )
    }
}

@Composable
private fun InsightStatCard(
    title: String,
    value: String,
    fg: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(.9f)),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(title, color = fg.copy(.7f), fontSize = 12.sp)
            Spacer(Modifier.height(6.dp))
            Text(value, color = fg, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

private fun List<Float>.averageSafe(): Double =
    if (isEmpty()) 0.0 else (sum() / size).toDouble()
