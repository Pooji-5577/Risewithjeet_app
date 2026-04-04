package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient

private val BsBg = Color(0xFF232427)
private val BsHero = Color(0xFF0D1A3A)
private val BsSurface = Color(0xFFECEFF5)
private val BsCard = Color(0xFFFFFFFF)
private val BsField = Color(0xFFE6EAF0)
private val BsBorder = Color(0xFFD9DFEA)
private val BsText = Color(0xFF2A3553)
private val BsMuted = Color(0xFF7C87A4)

private data class StudyTypeOption(val emoji: String, val label: String)

private val studyTypes = listOf(
    StudyTypeOption("🎥", "Video\nLectures"),
    StudyTypeOption("📖", "Reading"),
    StudyTypeOption("✅", "Practice"),
    StudyTypeOption("🔄", "Revision"),
    StudyTypeOption("📝", "Test"),
    StudyTypeOption("✏️", "Note\nMaking"),
    StudyTypeOption("✍️", "Answer\nWriting"),
    StudyTypeOption("💡", "Other")
)

private val subjects = listOf("Indian Polity", "Modern History", "Geography", "Economy", "Environment", "Science & Technology", "GS Paper 1", "GS Paper 2", "GS Paper 3", "GS Paper 4")
private val startTimes = listOf("06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00")
private val endTimes = listOf("07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00")

@Composable
fun BuildStudyPlanScreen(
    onBack: () -> Unit,
    onTaskAdded: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var selectedSubject by remember { mutableStateOf("") }
    var subjectExpanded by remember { mutableStateOf(false) }
    var selectedType by remember { mutableStateOf(2) }
    var startExpanded by remember { mutableStateOf(false) }
    var endExpanded by remember { mutableStateOf(false) }
    var startIdx by remember { mutableStateOf(3) }
    var endIdx by remember { mutableStateOf(5) }

    val startHour = startTimes[startIdx].split(":")[0].toInt()
    val endHour = endTimes[endIdx].split(":")[0].toInt()
    val durationText = if (endHour > startHour) "Duration: ${endHour - startHour} hours" else "Duration: -"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BsBg)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp)
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
                    .background(BsHero)
                    .padding(vertical = 18.dp, horizontal = 18.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                    Text("📝", fontSize = 40.sp)
                    Spacer(Modifier.height(4.dp))
                    Text("Build Your Study Plan", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
                    Text("Thursday, Mar 19 · Add a task to get started", color = Color(0xFF95A0BD), fontSize = 12.sp)
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .background(BsSurface)
                    .padding(12.dp)
            ) {
                FormCard {
                    FieldLabel("📝", "TASK TITLE")
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(BsField)
                            .border(1.dp, BsBorder, RoundedCornerShape(10.dp))
                            .padding(horizontal = 12.dp, vertical = 12.dp)
                    ) {
                        Text(if (title.isBlank()) "e.g. Polity Study Session" else title, color = if (title.isBlank()) Color(0xFFA0A9BF) else BsText, fontSize = 14.sp)
                    }
                }

                Spacer(Modifier.height(10.dp))

                FormCard {
                    FieldLabel("🎓", "SUBJECT")
                    Spacer(Modifier.height(8.dp))
                    Box {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(BsField)
                                .border(1.dp, BsBorder, RoundedCornerShape(10.dp))
                                .clickable { subjectExpanded = true }
                                .padding(horizontal = 12.dp, vertical = 12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(if (selectedSubject.isBlank()) "Choose subject..." else selectedSubject, color = if (selectedSubject.isBlank()) BsMuted else BsText, fontSize = 14.sp)
                            Text("⌄", color = BsMuted, fontSize = 14.sp)
                        }
                        DropdownMenu(expanded = subjectExpanded, onDismissRequest = { subjectExpanded = false }) {
                            subjects.forEach {
                                DropdownMenuItem(text = { Text(it) }, onClick = { selectedSubject = it; subjectExpanded = false })
                            }
                        }
                    }
                }

                Spacer(Modifier.height(10.dp))

                FormCard {
                    FieldLabel("🗂️", "STUDY TYPE")
                    Spacer(Modifier.height(8.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        studyTypes.chunked(4).forEachIndexed { rowIndex, row ->
                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                row.forEachIndexed { columnIndex, option ->
                                    val idx = rowIndex * 4 + columnIndex
                                    val selected = idx == selectedType
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(if (selected) Color(0xFF202A4A) else BsField)
                                            .border(1.dp, if (selected) Color(0xFF202A4A) else BsBorder, RoundedCornerShape(10.dp))
                                            .clickable { selectedType = idx }
                                            .padding(vertical = 10.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                            Text(option.emoji, fontSize = 18.sp)
                                            val parts = option.label.split("\\n")
                                            Text(parts[0], color = if (selected) Color.White else BsText, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center)
                                            if (parts.size > 1) Text(parts[1], color = if (selected) Color(0xFFC6D0E8) else BsMuted, fontSize = 10.sp, textAlign = TextAlign.Center)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                Spacer(Modifier.height(10.dp))

                FormCard {
                    FieldLabel("⏰", "TIME SLOT")
                    Spacer(Modifier.height(8.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        TimeField("Start Time", startTimes[startIdx], onClick = { startExpanded = true }, modifier = Modifier.weight(1f))
                        TimeField("End Time", endTimes[endIdx], onClick = { endExpanded = true }, modifier = Modifier.weight(1f))
                    }
                    DropdownMenu(expanded = startExpanded, onDismissRequest = { startExpanded = false }) {
                        startTimes.forEachIndexed { idx, t ->
                            DropdownMenuItem(text = { Text(t) }, onClick = { startIdx = idx; startExpanded = false })
                        }
                    }
                    DropdownMenu(expanded = endExpanded, onDismissRequest = { endExpanded = false }) {
                        endTimes.forEachIndexed { idx, t ->
                            DropdownMenuItem(text = { Text(t) }, onClick = { endIdx = idx; endExpanded = false })
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFFFF6E3))
                            .border(1.dp, Color(0xFFF2E2BF), RoundedCornerShape(8.dp))
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("⏱ $durationText", color = Color(0xFFC48621), fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    }
                }

                Spacer(Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(GoldGradient)
                        .clickable { onTaskAdded() },
                    contentAlignment = Alignment.Center
                ) {
                    Text("+ Add to Today's Study Plan →", color = Color(0xFF1A223B), fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
                }

                Spacer(Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(38.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFFFFFFF))
                        .border(1.dp, BsBorder, RoundedCornerShape(10.dp))
                        .clickable { onBack() },
                    contentAlignment = Alignment.Center
                ) {
                    Text("View Today's Study Plan →", color = BsText, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        }
    }
}

@Composable
private fun FormCard(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(2.dp, RoundedCornerShape(14.dp))
            .clip(RoundedCornerShape(14.dp))
            .background(BsCard)
            .padding(12.dp),
        content = content
    )
}

@Composable
private fun FieldLabel(icon: String, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(icon, fontSize = 12.sp)
        Spacer(Modifier.width(5.dp))
        Text(label, color = BsMuted, fontSize = 12.sp, fontWeight = FontWeight.ExtraBold)
    }
}

@Composable
private fun TimeField(label: String, value: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(label, color = BsMuted, fontSize = 11.sp)
        Spacer(Modifier.height(4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(BsField)
                .border(1.dp, BsBorder, RoundedCornerShape(10.dp))
                .clickable { onClick() }
                .padding(horizontal = 10.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(value, color = BsText, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
            Text("⌄", color = BsMuted, fontSize = 12.sp)
        }
    }
}
