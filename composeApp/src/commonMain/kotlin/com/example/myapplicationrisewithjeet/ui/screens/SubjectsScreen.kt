package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.data.model.Subject
import com.example.myapplicationrisewithjeet.data.model.SubjectColor
import com.example.myapplicationrisewithjeet.data.model.upscSubjects
import com.example.myapplicationrisewithjeet.ui.theme.*

@Composable
fun SubjectsScreen(onSubjectClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Saffron)
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            Column {
                Text(
                    "📚 All Subjects",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Choose a subject to study",
                    color = Color.White.copy(alpha = 0.85f),
                    fontSize = 14.sp
                )
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(upscSubjects) { subject ->
                SubjectGridCard(subject = subject, onClick = { onSubjectClick(subject.id) })
            }
            item {
                Spacer(Modifier.height(70.dp))
            }
        }
    }
}

@Composable
fun SubjectGridCard(subject: Subject, onClick: () -> Unit) {
    val (bgColor, accentColor) = subjectColors(subject.color)
    val progress = subject.completedTopics.toFloat() / subject.totalTopics

    Card(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(subject.emoji, fontSize = 32.sp)
                Box(
                    modifier = Modifier
                        .background(accentColor.copy(alpha = 0.15f), RoundedCornerShape(8.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        "${(progress * 100).toInt()}%",
                        fontSize = 11.sp,
                        color = accentColor,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(Modifier.height(10.dp))
            Text(
                subject.name,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = OnSurface
            )
            Spacer(Modifier.height(2.dp))
            Text(
                subject.description,
                fontSize = 11.sp,
                color = OnSurfaceVariant,
                maxLines = 2
            )
            Spacer(Modifier.height(10.dp))
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .clip(RoundedCornerShape(3.dp)),
                color = accentColor,
                trackColor = Outline
            )
            Spacer(Modifier.height(4.dp))
            Text(
                "${subject.completedTopics} of ${subject.totalTopics} topics",
                fontSize = 11.sp,
                color = OnSurfaceVariant
            )
        }
    }
}

fun subjectColors(color: SubjectColor): Pair<Color, Color> = when (color) {
    SubjectColor.SAFFRON -> Pair(SaffronContainer, Saffron)
    SubjectColor.NAVY -> Pair(NavyBlueContainer, NavyBlue)
    SubjectColor.GREEN -> Pair(GreenContainer, GreenIndia)
    SubjectColor.GOLD -> Pair(GoldContainer, Gold)
    SubjectColor.TEAL -> Pair(Color(0xFFE0F2F1), Color(0xFF00897B))
    SubjectColor.PURPLE -> Pair(Color(0xFFF3E5F5), Color(0xFF7B1FA2))
    SubjectColor.RED -> Pair(Color(0xFFFFEBEE), Color(0xFFC62828))
}
