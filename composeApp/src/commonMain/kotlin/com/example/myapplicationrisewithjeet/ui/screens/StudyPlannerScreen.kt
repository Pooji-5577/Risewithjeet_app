package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldAccent
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient
import myapplicationrisewithjeet.composeapp.generated.resources.Res
import myapplicationrisewithjeet.composeapp.generated.resources.planner_calendar
import myapplicationrisewithjeet.composeapp.generated.resources.planner_my_study
import myapplicationrisewithjeet.composeapp.generated.resources.planner_target
import org.jetbrains.compose.resources.painterResource

private val SpBackdrop = Color(0xFF222429)
private val SpHero = Color(0xFF0D1A3A)
private val SpSurface = Color(0xFFECEFF5)
private val SpCard = Color(0xFFFFFFFF)
private val SpText = Color(0xFF27314D)
private val SpMuted = Color(0xFF7481A2)
private val SpBorder = Color(0xFFD9DFEA)

internal data class StudyTask(
    val timeLabel: String,
    val title: String,
    val timeRange: String,
    val duration: String,
    val tag: String,
    val tagColor: Color,
    val status: TaskStatus
)

internal enum class TaskStatus { DONE, UP_NEXT, UPCOMING }

private val sampleTasks = listOf(
    StudyTask("6 AM", "Complete Polity Chapter 5", "9:00–11:00 AM", "2h", "Indian Polity", Color(0xFF4F81D9), TaskStatus.DONE),
    StudyTask("8 AM", "Watch Economics Lecture", "2:00–3:30 PM", "1.5h", "Economy", Color(0xFFF59E0B), TaskStatus.DONE),
    StudyTask("10 AM", "50 MCQs on Modern History", "4:00–5:00 PM", "44/50", "History", Color(0xFF7C6EE6), TaskStatus.DONE),
    StudyTask("2 PM", "Mains Answer Writing", "9:00–11:00 AM", "2h", "GS Paper 2", Color(0xFF5F7DB7), TaskStatus.UP_NEXT),
    StudyTask("5 PM", "Mock Test Generator – GS Paper 2", "4:00–5:00 PM", "", "Mock Test", Color(0xFF8FA0C9), TaskStatus.UPCOMING)
)

@Composable
fun StudyPlannerScreen(
    hasTasks: Boolean,
    onBack: () -> Unit,
    onBuildPlan: () -> Unit,
    onStartFocusSession: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SpBackdrop)
            .verticalScroll(rememberScrollState())
    ) {
        if (hasTasks) {
            PopulatedPlanner(onBack = onBack, onBuildPlan = onBuildPlan, onStartFocusSession = onStartFocusSession)
        } else {
            EmptyPlanner(onBack = onBack, onBuildPlan = onBuildPlan)
        }
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
private fun EmptyPlanner(onBack: () -> Unit, onBuildPlan: () -> Unit) {
    var selectedDayIdx by remember { mutableStateOf(3) }
    val weekDays = listOf("MON" to "16", "TUE" to "17", "WED" to "18", "THU" to "19", "FRI" to "20", "SAT" to "21", "SUN" to "22")

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
                .clip(RoundedCornerShape(0.dp))
                .background(SpHero)
                .padding(horizontal = 18.dp, vertical = 18.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFF3A3A35))
                        .padding(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Text("🗓 DAILY STUDY PLANNER", color = GoldAccent, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(16.dp))
                Text("Where planning meets", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center, lineHeight = 42.sp)
                Text("purpose", color = GoldAccent, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
                Spacer(Modifier.height(12.dp))
                Text(
                    "Plan every hour, track every milestone - built\naround your UPSC journey.",
                    color = Color(0xFF95A0BD),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp
                )
                Spacer(Modifier.height(14.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    HeroStat("0h", "PLANNED", GoldAccent)
                    HeroStat("0h", "DONE", Color.White)
                    HeroStat("0/0", "TASKS", Color.White)
                    HeroStat("-", "PROGRESS", Color(0xFF7BC96F))
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(SpSurface)
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                weekDays.forEachIndexed { idx, (day, date) ->
                    val sel = idx == selectedDayIdx
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(10.dp))
                            .background(if (sel) Color(0xFF202A4A) else Color.White)
                            .border(1.dp, if (sel) Color(0xFF202A4A) else SpBorder, RoundedCornerShape(10.dp))
                            .clickable { selectedDayIdx = idx }
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(day, color = if (sel) Color(0xFFB5C0DF) else SpMuted, fontSize = 8.sp, fontWeight = FontWeight.Bold)
                            Text(date, color = if (sel) Color.White else SpText, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                            Box(
                                modifier = Modifier
                                    .padding(top = 2.dp)
                                    .size(4.dp)
                                    .clip(CircleShape)
                                    .background(if (idx in setOf(0, 1, 2) && !sel) GoldAccent else Color.Transparent)
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(Res.drawable.planner_calendar),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text("Sat, Mar 22, 2026", color = SpText, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(GoldGradient)
                        .clickable { onBuildPlan() }
                        .padding(horizontal = 18.dp, vertical = 10.dp)
                ) {
                    Text("+ Add Task", color = Color(0xFF1A223B), fontSize = 13.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp))
                    .border(2.dp, Color(0xFFD9E0EC), RoundedCornerShape(18.dp))
                    .background(Color.White)
                    .padding(horizontal = 18.dp, vertical = 30.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(Res.drawable.planner_calendar),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(Modifier.height(10.dp))
                    Text("Your plan is empty", color = SpText, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Add study tasks to build your personalised schedule\nfor today. Start with your weakest subject!",
                        color = SpMuted,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 18.sp
                    )
                    Spacer(Modifier.height(18.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(GoldGradient)
                            .clickable { onBuildPlan() }
                            .padding(horizontal = 20.dp, vertical = 12.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(Res.drawable.planner_target),
                                contentDescription = null,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(Modifier.width(6.dp))
                            Text("Build My Study Plan →", color = Color(0xFF1A223B), fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PopulatedPlanner(onBack: () -> Unit, onBuildPlan: () -> Unit, onStartFocusSession: () -> Unit) {
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
                .background(SpHero)
                .padding(16.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(Res.drawable.planner_my_study),
                    contentDescription = null,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(Modifier.height(4.dp))
                Text("My Study", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
                Text("Planner", color = GoldAccent, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
                Text("January 2026", color = Color(0xFFB8C1D9), fontSize = 13.sp)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(SpSurface)
                .padding(12.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                LightStat(Modifier.weight(1f), "5.5h", "PLANNED", Color(0xFF3E4A6C))
                LightStat(Modifier.weight(1f), "3.5h", "DONE", Color(0xFF4CA960))
                LightStat(Modifier.weight(1f), "3/5", "TASKS", Color(0xFF3E4A6C))
                LightStat(Modifier.weight(1f), "63%", "PROGRESS", Color(0xFFD38D1E))
            }

            Spacer(Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(Res.drawable.planner_calendar),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text("Sat, Mar 22, 2026", color = SpText, fontSize = 15.sp, fontWeight = FontWeight.ExtraBold)
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(GoldGradient)
                        .clickable { onBuildPlan() }
                        .padding(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Text("+ Add Task", color = Color(0xFF1A223B), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(Modifier.height(8.dp))

            Text("Today's Progress", color = SpMuted, fontSize = 11.sp)
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                LinearProgressIndicator(
                    progress = { 0.63f },
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 7.dp, end = 8.dp)
                        .height(5.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = Color(0xFFBE8A2B),
                    trackColor = Color(0xFFD5D9E5)
                )
                Text("63% · 3.5h done", color = Color(0xFFBE8A2B), fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
            }

            Spacer(Modifier.height(10.dp))

            sampleTasks.forEachIndexed { index, task ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(task.timeLabel, color = SpMuted, fontSize = 10.sp, modifier = Modifier.width(34.dp).padding(top = 10.dp))
                    Spacer(Modifier.width(8.dp))
                    TaskCard(
                        modifier = Modifier.weight(1f),
                        task = task,
                        onStart = if (task.status == TaskStatus.UP_NEXT) onStartFocusSession else null
                    )
                }
                if (index < sampleTasks.lastIndex) Spacer(Modifier.height(8.dp))
            }

            Spacer(Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFF5FB466))
                    .clickable { onStartFocusSession() }
                    .padding(horizontal = 14.dp, vertical = 12.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Column {
                        Text("Start Focus Session", color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.ExtraBold)
                        Text("4:00-5:00 PM", color = Color(0xFFE7F7EA), fontSize = 12.sp)
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFF7AC984))
                            .padding(horizontal = 14.dp, vertical = 7.dp)
                    ) { Text("Start →", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold) }
                }
            }
        }
    }
}

@Composable
private fun HeroStat(value: String, label: String, valueColor: Color) {
    Column(
        modifier = Modifier
            .width(74.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF2A3553))
            .padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(value, color = valueColor, fontSize = 26.sp, fontWeight = FontWeight.ExtraBold)
        Text(label, color = Color(0xFF9AA5C0), fontSize = 10.sp)
    }
}

@Composable
private fun LightStat(modifier: Modifier, value: String, label: String, valueColor: Color) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .border(1.dp, SpBorder, RoundedCornerShape(10.dp))
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value, color = valueColor, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
            Text(label, color = SpMuted, fontSize = 8.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun TaskCard(modifier: Modifier, task: StudyTask, onStart: (() -> Unit)?) {
    val borderColor = when (task.status) {
        TaskStatus.DONE -> Color(0xFF7CB17D)
        TaskStatus.UP_NEXT -> Color(0xFFD7A341)
        TaskStatus.UPCOMING -> Color(0xFFD5D9E5)
    }
    val bgColor = when (task.status) {
        TaskStatus.UP_NEXT -> Color(0xFFF2E9DC)
        else -> SpCard
    }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(bgColor)
            .border(1.dp, borderColor, RoundedCornerShape(12.dp))
            .padding(10.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(task.title, color = SpText, fontSize = 13.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
            if (task.status == TaskStatus.DONE) {
                TagPill("✓ Done", Color(0xFFE7F4E8), Color(0xFF4CA960))
            }
            if (task.status == TaskStatus.UP_NEXT) {
                TagPill("Up Next", Color(0xFFFFE6BF), Color(0xFFC57F10))
            }
        }
        Spacer(Modifier.height(4.dp))
        Text("${task.timeRange}${if (task.duration.isNotEmpty()) " · ${task.duration}" else ""}", color = SpMuted, fontSize = 10.sp)
        Spacer(Modifier.height(4.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            TagPill(task.tag, task.tagColor.copy(alpha = 0.16f), task.tagColor)
            if (task.status == TaskStatus.UP_NEXT && onStart != null) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF1F2A4A))
                        .clickable { onStart() }
                        .padding(horizontal = 12.dp, vertical = 5.dp)
                ) { Text("Start →", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold) }
            }
        }
    }
}

@Composable
private fun TagPill(text: String, bg: Color, fg: Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(bg)
            .padding(horizontal = 8.dp, vertical = 3.dp)
    ) {
        Text(text, color = fg, fontSize = 9.sp, fontWeight = FontWeight.SemiBold, textDecoration = TextDecoration.None)
    }
}
