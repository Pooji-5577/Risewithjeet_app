package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient
import kotlinx.coroutines.delay

private val FsBg = Color(0xFF202327)
private val FsHero = Color(0xFF0D1A3A)
private val FsSurface = Color(0xFFECEFF5)
private val FsCard = Color(0xFFFFFFFF)
private val FsText = Color(0xFF2A3553)
private val FsMuted = Color(0xFF7C87A4)
private val FsBorder = Color(0xFFD9DFEA)

private data class FocusTask(
    val title: String,
    val done: Boolean,
    val tag: String,
    val tagBg: Color,
    val tagFg: Color
)

private val todayTasks = listOf(
    FocusTask("Daily MCQ Practice (20-Q)", true, "MCQ", Color(0xFFE7EEFF), Color(0xFF4F81D9)),
    FocusTask("Current Affairs Reading", true, "CA", Color(0xFFE7F7F9), Color(0xFF4FA3B8)),
    FocusTask("FlasheardReview(50)", true, "Rev", Color(0xFFE9F7E9), Color(0xFF4CA960)),
    FocusTask("Mains Answer Writing", false, "Mains", Color(0xFFFFEDDB), Color(0xFFCC8A2A)),
    FocusTask("Mock Test — GS2 Paper", false, "Test", Color(0xFFFFF5DF), Color(0xFFB8983A))
)

@Composable
fun FocusSessionScreen(
    onBack: () -> Unit,
    onComplete: () -> Unit
) {
    var paused by remember { mutableStateOf(false) }
    var secondsLeft by remember { mutableStateOf(15 * 60) }

    LaunchedEffect(paused) {
        if (!paused) {
            while (secondsLeft > 0) {
                delay(1000L)
                if (!paused) secondsLeft-- else break
            }
        }
    }

    val min = secondsLeft / 60
    val sec = secondsLeft % 60
    val timer = "%02d:%02d".format(min, sec)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FsBg)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("←", color = Color(0xFFAEB5C2), fontSize = 18.sp, modifier = Modifier.clickable { onBack() })
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .background(FsHero)
                    .padding(horizontal = 14.dp, vertical = 14.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFF1B5333))
                            .border(1.dp, Color(0xFF4CAA69), RoundedCornerShape(16.dp))
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(Color(0xFF6FD28B)))
                            Spacer(Modifier.width(5.dp))
                            Text("FOCUS SESSION ACTIVE", color = Color(0xFF8CE2A5), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                    Text("Mains Answer Writing", color = Color.White, fontSize = 33.sp, fontWeight = FontWeight.ExtraBold)
                    Text("GS Paper 2 · 6:00-7:00 PM · 1 hour", color = Color(0xFFA4B0C9), fontSize = 12.sp)
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp))
                    .background(FsSurface)
                    .padding(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(FsCard)
                        .border(1.dp, FsBorder, RoundedCornerShape(16.dp))
                        .padding(12.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                        Text("TIMER", color = FsMuted, fontSize = 10.sp)
                        Spacer(Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .size(108.dp)
                                .clip(CircleShape)
                                .border(6.dp, Color(0xFF1E2945), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(timer, color = Color(0xFF1E2945), fontSize = 40.sp, fontWeight = FontWeight.ExtraBold)
                        }
                        Spacer(Modifier.height(8.dp))
                        Text("READY TO START", color = FsMuted, fontSize = 10.sp)
                        Spacer(Modifier.height(10.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(42.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color(0xFFF7F8FB))
                                    .border(1.dp, Color(0xFFBDC6D9), RoundedCornerShape(10.dp))
                                    .clickable { paused = !paused },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(if (paused) "▶ Resume" else "⏸ Pause", color = FsText, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                            }
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(42.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(GoldGradient)
                                    .clickable { onComplete() },
                                contentAlignment = Alignment.Center
                            ) {
                                Text("✓ Mark Complete", color = Color(0xFF1A223B), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }

                Spacer(Modifier.height(8.dp))

                Text("📅  Today's Study Plan", color = FsText, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(6.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(FsCard)
                        .border(1.dp, FsBorder, RoundedCornerShape(14.dp))
                        .padding(10.dp)
                ) {
                    Column {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("Today's Plan", color = FsText, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                            Text("3 / 5 done", color = FsMuted, fontSize = 11.sp)
                        }
                        Spacer(Modifier.height(8.dp))

                        todayTasks.forEachIndexed { idx, task ->
                            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(18.dp)
                                        .clip(RoundedCornerShape(5.dp))
                                        .background(if (task.done) Color(0xFF4CA960) else Color.Transparent)
                                        .border(1.dp, if (task.done) Color(0xFF4CA960) else Color(0xFFD1D7E5), RoundedCornerShape(5.dp)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    if (task.done) Text("✓", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                }
                                Spacer(Modifier.width(8.dp))
                                Text(
                                    task.title,
                                    color = if (task.done) FsMuted else FsText,
                                    fontSize = 12.sp,
                                    textDecoration = if (task.done) TextDecoration.LineThrough else TextDecoration.None,
                                    modifier = Modifier.weight(1f)
                                )
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(task.tagBg)
                                        .padding(horizontal = 8.dp, vertical = 3.dp)
                                ) {
                                    Text(task.tag, color = task.tagFg, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                                }
                            }
                            if (idx < todayTasks.lastIndex) {
                                Spacer(Modifier.height(6.dp))
                                Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFFE8EDF6)))
                                Spacer(Modifier.height(6.dp))
                            }
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(18.dp))
    }
}
