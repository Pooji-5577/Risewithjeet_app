package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.*

private val MVBg    = Color(0xFF111827)
private val MVCard  = Color(0xFF1A2540)
private val MVWhite = Color.White
private val MVGray  = Color(0xFF9CA3AF)
private val MVLight = Color(0xFFF4F6FB)

@Composable
fun MindMapViewScreen(
    topicId: String,
    onBack: () -> Unit
) {
    val topic = polityTopics.find { it.id == topicId } ?: polityTopics[0]

    Column(modifier = Modifier.fillMaxSize().background(MVBg).verticalScroll(rememberScrollState())) {
        // ── Dark header ──────────────────────────────────────
        Column(
            modifier = Modifier.fillMaxWidth().background(MVBg).statusBarsPadding().padding(horizontal = 20.dp, vertical = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text("←", color = White70, fontSize = 20.sp, modifier = Modifier.clickable { onBack() })
            }
            Spacer(Modifier.height(6.dp))
            Text(topic.emoji, fontSize = 36.sp)
            Spacer(Modifier.height(6.dp))
            Text(topic.name.replace("\n", " "), color = MVWhite, fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.height(4.dp))
            Text("${topic.nodeCount} nodes · Polity · Last updated Mar 19", color = MVGray, fontSize = 13.sp)
            Spacer(Modifier.height(14.dp))
        }

        // ── Mindmap canvas card ───────────────────────────────
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(MVLight)
                .padding(top = 24.dp, bottom = 0.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                MindMapCanvas(modifier = Modifier.fillMaxWidth().height(340.dp))
                Spacer(Modifier.height(20.dp))

                // Action buttons
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = onBack,
                        modifier = Modifier.weight(1f).height(50.dp),
                        shape = RoundedCornerShape(14.dp),
                        border = ButtonDefaults.outlinedButtonBorder
                    ) {
                        Text("← Back to Topics", color = Color(0xFF374151), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    }
                    Box(
                        modifier = Modifier.weight(1f).height(50.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(GoldGradient)
                            .clickable {},
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Add to Bookmarks →", color = Color(0xFF111827), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }
                }
                Spacer(Modifier.height(280.dp)) // extra scroll space below
            }
        }
    }
}

@Composable
private fun MindMapCanvas(modifier: Modifier) {
    // Center node + satellite nodes drawn with Canvas + Box overlays
    Box(modifier = modifier) {
        // Draw connecting lines
        Canvas(modifier = Modifier.fillMaxSize()) {
            val cx = size.width / 2f
            val cy = size.height / 2f

            val nodeOffsets = listOf(
                Offset(0f, -130f),
                Offset(140f, -70f),
                Offset(140f,  60f),
                Offset(-20f,  140f),
                Offset( 60f,  140f),
                Offset(-150f,  30f),
            )
            val dashEffect = PathEffect.dashPathEffect(floatArrayOf(8f, 6f), 0f)
            nodeOffsets.forEach { off ->
                drawLine(
                    color = Color(0xFFD1D5DB),
                    start = Offset(cx, cy),
                    end   = Offset(cx + off.x, cy + off.y),
                    strokeWidth = 1.5f,
                    pathEffect  = dashEffect
                )
            }
        }

        // Center node
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .clip(RoundedCornerShape(10.dp))
                .background(GoldGradient)
                .padding(horizontal = 20.dp, vertical = 12.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("POLITY", color = Color(0xFF111827), fontSize = 13.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = 1.sp)
                Text("Constitution", color = Color(0xFF111827), fontSize = 11.sp)
            }
        }

        // Satellite nodes
        val satelliteNodes = listOf(
            Triple("Basic Structure",    "Kesavananda 1973",  Offset(-100f, -110f)),
            Triple("Executive",          "President, PM",      Offset( 80f,  -110f)),
            Triple("Judiciary",          "SC, HC, Others",     Offset( 80f,   20f)),
            Triple("Parliament",         "Art. 79 · Bicam.",  Offset(-120f,  100f)),
            Triple("Fundamental\nRights","Art. 12-35",         Offset(  20f,  100f)),
            Triple("DPSP",               "Art. 36-51",         Offset(-160f,  -10f)),
        )

        satelliteNodes.forEach { (title, sub, off) ->
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(off.x.dp, off.y.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MVCard)
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(title, color = MVWhite, fontSize = 11.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, lineHeight = 15.sp)
                    Text(sub, color = MVGray, fontSize = 9.sp, textAlign = TextAlign.Center)
                }
            }
        }
    }
}
