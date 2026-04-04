package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.data.model.upscSubjects
import com.example.myapplicationrisewithjeet.ui.theme.*

data class StudyTopic(
    val title: String,
    val subtopics: List<String>,
    val isCompleted: Boolean = false
)

val subjectTopics: Map<String, List<StudyTopic>> = mapOf(
    "polity" to listOf(
        StudyTopic("Preamble", listOf("Objectives", "Key words", "Amendments"), true),
        StudyTopic("Fundamental Rights", listOf("Articles 12-35", "Writs", "Exceptions"), true),
        StudyTopic("Directive Principles", listOf("Articles 36-51", "Classification"), true),
        StudyTopic("Fundamental Duties", listOf("Article 51A", "11 Duties"), false),
        StudyTopic("Parliament", listOf("Lok Sabha", "Rajya Sabha", "Sessions"), false),
        StudyTopic("President & Governor", listOf("Powers", "Election", "Removal"), false),
        StudyTopic("Judiciary", listOf("Supreme Court", "High Courts", "PILs"), false),
        StudyTopic("Federalism", listOf("Centre-State relations", "7th Schedule"), false),
    ),
    "history" to listOf(
        StudyTopic("Indus Valley Civilization", listOf("Sites", "Features", "Decline"), true),
        StudyTopic("Vedic Period", listOf("Rigveda", "Society", "Economy"), true),
        StudyTopic("Maurya Empire", listOf("Chandragupta", "Ashoka", "Decline"), true),
        StudyTopic("Gupta Empire", listOf("Golden Age", "Literature", "Science"), false),
        StudyTopic("Medieval India", listOf("Delhi Sultanate", "Mughals", "Regional kingdoms"), false),
        StudyTopic("Bhakti & Sufi", listOf("Saints", "Impact", "Teachings"), false),
        StudyTopic("Advent of Europeans", listOf("Portuguese", "British", "French"), false),
        StudyTopic("Freedom Struggle", listOf("1857", "INC", "Gandhi era"), false),
    ),
    "geography" to listOf(
        StudyTopic("Physical Features", listOf("Himalayas", "Peninsular Plateau", "Plains"), true),
        StudyTopic("Rivers", listOf("Himalayan rivers", "Peninsular rivers", "Tributaries"), false),
        StudyTopic("Climate", listOf("Monsoon", "Seasons", "Cyclones"), false),
        StudyTopic("Natural Vegetation", listOf("Forest types", "Wildlife", "Biomes"), false),
        StudyTopic("Population", listOf("Census 2011", "Density", "Migration"), false),
    )
)

@Composable
fun SubjectDetailScreen(
    subjectId: String,
    onBack: () -> Unit,
    onQuiz: () -> Unit
) {
    val subject = upscSubjects.find { it.id == subjectId } ?: return
    val topics = subjectTopics[subjectId] ?: generateTopics(subject.totalTopics)
    val (_, accentColor) = subjectColors(subject.color)
    val progress = subject.completedTopics.toFloat() / subject.totalTopics

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.verticalGradient(listOf(accentColor, accentColor.copy(0.8f))))
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextButton(onClick = onBack) {
                        Text("← Back", color = Color.White, fontWeight = FontWeight.Medium)
                    }
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(subject.emoji, fontSize = 36.sp)
                    Spacer(Modifier.width(12.dp))
                    Column {
                        Text(subject.name, color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                        Text(subject.description, color = Color.White.copy(0.85f), fontSize = 13.sp)
                    }
                }
                Spacer(Modifier.height(12.dp))
                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp)),
                    color = Color.White,
                    trackColor = Color.White.copy(0.3f)
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "${subject.completedTopics}/${subject.totalTopics} topics • ${(progress * 100).toInt()}% complete",
                    color = Color.White.copy(0.85f),
                    fontSize = 12.sp
                )
            }
        }

        // Quick action
        Card(
            onClick = onQuiz,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = SaffronContainer),
            elevation = CardDefaults.cardElevation(1.dp)
        ) {
            Row(
                modifier = Modifier.padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("⚡", fontSize = 24.sp)
                Spacer(Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text("Practice ${subject.name}", fontWeight = FontWeight.SemiBold, color = OnSurface)
                    Text("Test your knowledge with MCQs", fontSize = 12.sp, color = OnSurfaceVariant)
                }
                Button(
                    onClick = onQuiz,
                    colors = ButtonDefaults.buttonColors(containerColor = Saffron),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(start = 14.dp, end = 14.dp, top = 6.dp, bottom = 6.dp)
                ) {
                    Text("Quiz", fontWeight = FontWeight.Bold)
                }
            }
        }

        // Topics list
        Text(
            "Topics",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            color = OnSurface
        )

        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(topics) { topic ->
                TopicCard(topic = topic, accentColor = accentColor)
            }
        }
    }
}

@Composable
private fun TopicCard(topic: StudyTopic, accentColor: Color) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        onClick = { expanded = !expanded },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(if (topic.isCompleted) GreenContainer else SaffronContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Text(if (topic.isCompleted) "✓" else "○", fontSize = 12.sp,
                        color = if (topic.isCompleted) GreenIndia else Saffron,
                        fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.width(10.dp))
                Text(
                    topic.title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = OnSurface,
                    modifier = Modifier.weight(1f)
                )
                Text(if (expanded) "▲" else "▼", fontSize = 12.sp, color = OnSurfaceVariant)
            }

            if (expanded) {
                Spacer(Modifier.height(10.dp))
                HorizontalDivider(color = Outline)
                Spacer(Modifier.height(10.dp))
                topic.subtopics.forEach { subtopic ->
                    Row(
                        modifier = Modifier.padding(vertical = 3.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .background(accentColor)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(subtopic, fontSize = 13.sp, color = OnSurfaceVariant)
                    }
                }
            }
        }
    }
}

private fun generateTopics(count: Int): List<StudyTopic> {
    return (1..minOf(count, 10)).map { i ->
        StudyTopic("Topic $i", listOf("Subtopic A", "Subtopic B", "Subtopic C"), i <= 3)
    }
}
