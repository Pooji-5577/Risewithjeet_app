package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myapplicationrisewithjeet.composeapp.generated.resources.Res
import myapplicationrisewithjeet.composeapp.generated.resources.rev_flashcards
import myapplicationrisewithjeet.composeapp.generated.resources.rev_mindmaps
import myapplicationrisewithjeet.composeapp.generated.resources.rev_spaced_rep
import myapplicationrisewithjeet.composeapp.generated.resources.syllabus_science
import myapplicationrisewithjeet.composeapp.generated.resources.syllabus_tracker_header
import com.example.myapplicationrisewithjeet.ui.theme.*
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

private val HomeBg      = Color(0xFFF0F4FA)
private val TextDark    = Color(0xFF111827)
private val TextMid     = Color(0xFF374151)
private val TextLight   = Color(0xFF9CA3AF)
private val DividerClr  = Color(0xFFE5E7EB)
private val CheckedGreen= Color(0xFF22C55E)
private val TagMCQ      = Color(0xFF3B82F6)
private val TagCA       = Color(0xFF06B6D4)
private val TagRev      = Color(0xFF22C55E)
private val TagMains    = Color(0xFFF97316)
private val HeroTop     = Color(0xFF08132D)
private val HeroBottom  = Color(0xFF0A1736)
private val HeroChipBg  = Color(0xFF1E293B)
private val HeroChipBorder = Color(0xFF374151)
private val CardTint    = Color(0xFFEDF0F6)

private data class SyllabusProgressItem(
    val emoji: String,
    val name: String,
    val sub: String,
    val progress: Float
)

@Composable
fun HomeScreen(
    onSubjectClick: (String) -> Unit = {},
    onOverviewClick: () -> Unit = {},
    onStudyPlannerMenuClick: () -> Unit = {},
    onQuizClick: () -> Unit = {},
    onPyqsClick: () -> Unit = {},
    onJeetAIClick: () -> Unit = {},
    onSyllabusTrackerMenuClick: () -> Unit = {},
    onVideoLecturesClick: () -> Unit = {},
    onStudyMaterialClick: () -> Unit = {},
    onCurrentAffairsClick: () -> Unit = {},
    onTestSeriesClick: () -> Unit = {},
    onPersonalMentorshipClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onDailyMainsClick: () -> Unit = {},
    onDailyNewsClick: () -> Unit = {},
    onMockTestsClick: () -> Unit = {},
    onStudyPlanClick: () -> Unit = {},
    onRevisionSuiteClick: () -> Unit = {},
    onStartTrackingSyllabusClick: () -> Unit = {},
    onPreviousYearQuestionsClick: () -> Unit = {},
    onPerformanceAnalyticsClick: () -> Unit = {},
    onTestAnalyticsClick: () -> Unit = {},
    onFlashcardsClick: () -> Unit = {},
    onMindmapsClick: () -> Unit = {},
    onSpacedRepetitionClick: () -> Unit = {},
    onStudyGroupsClick: () -> Unit = {},
    onLeaderboardClick: () -> Unit = {},
    onDiscussionsClick: () -> Unit = {},
    onQaForumClick: () -> Unit = {},
    onPremiumPlansClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
    onLogoutClick: () -> Unit = {},
    initialTab: Int = 0
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            HomeHamburgerDrawer(
                onOverviewClick = {
                    scope.launch { drawerState.close() }
                    onOverviewClick()
                },
                onStudyPlannerClick = {
                    scope.launch { drawerState.close() }
                    onStudyPlannerMenuClick()
                },
                onJeetAIMenuClick = {
                    scope.launch { drawerState.close() }
                    onJeetAIClick()
                },
                onSyllabusTrackerClick = {
                    scope.launch { drawerState.close() }
                    onSyllabusTrackerMenuClick()
                },
                onVideoLecturesClick = {
                    scope.launch { drawerState.close() }
                    onVideoLecturesClick()
                },
                onStudyMaterialClick = {
                    scope.launch { drawerState.close() }
                    onStudyMaterialClick()
                },
                onCurrentAffairsClick = {
                    scope.launch { drawerState.close() }
                    onCurrentAffairsClick()
                },
                onTestSeriesClick = {
                    scope.launch { drawerState.close() }
                    onTestSeriesClick()
                },
                onPersonalMentorshipClick = {
                    scope.launch { drawerState.close() }
                    onPersonalMentorshipClick()
                },
                onDailyMcqClick = {
                    scope.launch { drawerState.close() }
                    onQuizClick()
                },
                onPyqsMenuClick = {
                    scope.launch { drawerState.close() }
                    onPyqsClick()
                },
                onDailyAnswerWritingClick = {
                    scope.launch { drawerState.close() }
                    onDailyMainsClick()
                },
                onMockTestsClick = {
                    scope.launch { drawerState.close() }
                    onMockTestsClick()
                },
                onPreviousYearQuestionsClick = { scope.launch { drawerState.close() }; onPreviousYearQuestionsClick() },
                onPerformanceAnalyticsClick = {
                    scope.launch { drawerState.close() }
                    onPerformanceAnalyticsClick()
                },
                onTestAnalyticsClick = {
                    scope.launch { drawerState.close() }
                    onTestAnalyticsClick()
                },
                onFlashcardsClick = {
                    scope.launch { drawerState.close() }
                    onFlashcardsClick()
                },
                onMindmapsClick = {
                    scope.launch { drawerState.close() }
                    onMindmapsClick()
                },
                onSpacedRepetitionClick = {
                    scope.launch { drawerState.close() }
                    onSpacedRepetitionClick()
                },
                onStudyGroupsClick = {
                    scope.launch { drawerState.close() }
                    onStudyGroupsClick()
                },
                onLeaderboardClick = {
                    scope.launch { drawerState.close() }
                    onLeaderboardClick()
                },
                onDiscussionsClick = {
                    scope.launch { drawerState.close() }
                    onDiscussionsClick()
                },
                onQaForumClick = {
                    scope.launch { drawerState.close() }
                    onQaForumClick()
                },
                onPremiumPlansClick = {
                    scope.launch { drawerState.close() }
                    onPremiumPlansClick()
                },
                onSettingsClick = {
                    scope.launch { drawerState.close() }
                    onSettingsClick()
                },
                onLogoutClick = {
                    scope.launch { drawerState.close() }
                    onLogoutClick()
                },
                onStudyModeClick = {
                    scope.launch { drawerState.close() }
                    onStudyPlanClick()
                },
                onGoPremiumClick = {
                    scope.launch { drawerState.close() }
                    onPremiumPlansClick()
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(HomeBg)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 90.dp)
            ) {
                item {
                    HeroSection(
                        onProfileClick = onProfileClick,
                        onMenuClick = { scope.launch { drawerState.open() } }
                    )
                }
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                            .background(HomeBg)
                    ) {
                        Spacer(Modifier.height(10.dp))
                        DailyTrioSection(
                            onDailyMCQClick = onQuizClick,
                            onDailyMainsClick = onDailyMainsClick,
                            onDailyNewsClick = onDailyNewsClick
                        )
                        Spacer(Modifier.height(12.dp))
                        StudyPlanSection(onStudyPlanClick = onStudyPlanClick)
                        Spacer(Modifier.height(12.dp))
                        SyllabusTrackerSection(onStartTracking = onStartTrackingSyllabusClick)
                        Spacer(Modifier.height(12.dp))
                        RevisionSuiteSection(onExploreClick = onRevisionSuiteClick)
                        Spacer(Modifier.height(12.dp))
                        QuoteSection()
                    }
                }
            }
            FloatingProfileBubble(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .offset(x = (-18).dp, y = 150.dp)
            )
        }
    }
}

// ─────────────────────────────────────────────
// Hero Section
// ─────────────────────────────────────────────

@Composable
private fun HeroSection(onProfileClick: () -> Unit, onMenuClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(HeroTop, HeroBottom)
                )
            )
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 14.dp)
    ) {
        HomeTopBar(onProfileClick = onProfileClick, onMenuClick = onMenuClick)
        Spacer(Modifier.height(16.dp))
        GreetingSection()
        Spacer(Modifier.height(12.dp))
    }
}

@Composable
private fun HomeTopBar(onProfileClick: () -> Unit, onMenuClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "☰",
            fontSize = 19.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable { onMenuClick() }
        )
        Spacer(Modifier.width(10.dp))
        Text(
            buildAnnotatedString {
                withStyle(SpanStyle(color = Color.White, fontWeight = FontWeight.ExtraBold)) { append("Rise") }
                withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.ExtraBold)) { append("WithJeet") }
            },
            fontSize = 18.sp
        )
        Spacer(Modifier.weight(1f))
        HeaderIconChip(icon = "🔥", badge = "47", badgeColor = Color(0xFFEF4444))
        Spacer(Modifier.width(8.dp))
        HeaderIconChip(icon = "🔔", badge = "3", badgeColor = Color(0xFF3B82F6))
        Spacer(Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(GoldAccent)
                .clickable { onProfileClick() },
            contentAlignment = Alignment.Center
        ) {
            Text("R", color = HeroTop, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
        }
    }
}

@Composable
private fun HomeHamburgerDrawer(
    onOverviewClick: () -> Unit,
    onStudyPlannerClick: () -> Unit,
    onJeetAIMenuClick: () -> Unit,
    onSyllabusTrackerClick: () -> Unit,
    onVideoLecturesClick: () -> Unit,
    onStudyMaterialClick: () -> Unit,
    onCurrentAffairsClick: () -> Unit,
    onTestSeriesClick: () -> Unit,
    onPersonalMentorshipClick: () -> Unit,
    onDailyMcqClick: () -> Unit,
    onPyqsMenuClick: () -> Unit,
    onDailyAnswerWritingClick: () -> Unit,
    onMockTestsClick: () -> Unit,
    onPreviousYearQuestionsClick: () -> Unit,
    onPerformanceAnalyticsClick: () -> Unit,
    onTestAnalyticsClick: () -> Unit,
    onLeaderboardClick: () -> Unit,
    onFlashcardsClick: () -> Unit,
    onMindmapsClick: () -> Unit,
    onSpacedRepetitionClick: () -> Unit,
    onStudyGroupsClick: () -> Unit,
    onDiscussionsClick: () -> Unit,
    onQaForumClick: () -> Unit,
    onPremiumPlansClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onLogoutClick: () -> Unit,
    onStudyModeClick: () -> Unit,
    onGoPremiumClick: () -> Unit
) {
    ModalDrawerSheet(
        modifier = Modifier.fillMaxWidth(0.82f),
        drawerContainerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            DrawerGroupTitle("DASHBOARD")
            DrawerItem("📋", "Overview", onOverviewClick)
            DrawerItem("📅", "Study Planner", onStudyPlannerClick)
            DrawerItem("🤖", "Jeet AI", onJeetAIMenuClick)
            DrawerItem("🧭", "Syllabus Tracker", onSyllabusTrackerClick)

            Spacer(Modifier.height(8.dp))
            DrawerGroupTitle("LEARNING")
            DrawerItem("🎬", "Video Lectures", onVideoLecturesClick)
            DrawerItem("📚", "Study Material", onStudyMaterialClick)
            DrawerItem("📰", "Current Affairs", onCurrentAffairsClick)
            DrawerItem("🧪", "Test Series", onTestSeriesClick)
            DrawerItem("🧑‍🏫", "Personal Mentorship", onPersonalMentorshipClick)

            Spacer(Modifier.height(8.dp))
            DrawerGroupTitle("PRACTICE")
            DrawerItem("🎯", "Daily MCQ", onDailyMcqClick)
            DrawerItem("✍️", "Daily Answer Writing", onDailyAnswerWritingClick)
            DrawerItem("📝", "Mock Tests", onMockTestsClick)
            DrawerItem("📜", "Previous Year Questions", onPreviousYearQuestionsClick)
            DrawerItem("📘", "PYQs", onPyqsMenuClick)

            Spacer(Modifier.height(8.dp))
            DrawerGroupTitle("ANALYTICS")
            DrawerItem("📊", "Performance Analytics", onPerformanceAnalyticsClick)
            DrawerItem("🔎", "Test Analytics", onTestAnalyticsClick)

            Spacer(Modifier.height(8.dp))
            DrawerGroupTitle("REVISION TOOLS")
            DrawerItem("🃏", "Flashcards", onFlashcardsClick)
            DrawerItem("🧩", "Mindmaps", onMindmapsClick)
            DrawerItem("🔁", "Spaced Repetition", onSpacedRepetitionClick)

            Spacer(Modifier.height(8.dp))
            DrawerGroupTitle("COMMUNITY")
            DrawerItem("👥", "Study Groups", onStudyGroupsClick)
            DrawerItem("🏅", "Leaderboard", onLeaderboardClick)
            DrawerItem("💬", "Discussions", onDiscussionsClick)
            DrawerItem("❓", "Q&A Forum", onQaForumClick)

            Spacer(Modifier.height(8.dp))
            DrawerGroupTitle("ACCOUNT")
            DrawerItem("👑", "Premium Plans", onPremiumPlansClick)
            DrawerItem("⚙️", "Settings", onSettingsClick)
            DrawerItem("🚪", "Logout", onLogoutClick)

            Spacer(Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFFF5F6F8))
                    .border(1.dp, Color(0xFFE4E7EE), RoundedCornerShape(14.dp))
                    .clickable { onStudyModeClick() }
                    .padding(horizontal = 14.dp, vertical = 12.dp)
            ) {
                Column {
                    Text("💡  Study Mode", color = Color(0xFF2C3553), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text("Distraction-free focus", color = TextLight, fontSize = 12.sp)
                }
            }

            Spacer(Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFFFFF8EA))
                    .border(1.dp, Color(0xFFF3E1B8), RoundedCornerShape(14.dp))
                    .clickable { onGoPremiumClick() }
                    .padding(horizontal = 14.dp, vertical = 12.dp)
            ) {
                Column {
                    Text("👑  Go Premium", color = GoldAccent, fontSize = 15.sp, fontWeight = FontWeight.ExtraBold)
                    Text("7-day free trial", color = TextLight, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
private fun DrawerGroupTitle(title: String) {
    Text(
        text = title,
        color = Color(0xFFB1B8C9),
        fontSize = 11.sp,
        fontWeight = FontWeight.ExtraBold,
        letterSpacing = 0.8.sp,
        modifier = Modifier.padding(top = 8.dp, bottom = 2.dp)
    )
}

@Composable
private fun DrawerItem(icon: String, label: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(horizontal = 10.dp, vertical = 11.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(icon, fontSize = 20.sp)
        Spacer(Modifier.width(12.dp))
        Text(label, color = Color(0xFF2D3858), fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
    }
}

// ─────────────────────────────────────────────
// Greeting
// ─────────────────────────────────────────────

@Composable
private fun GreetingSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
    ) {
        Text("Good morning, Rahul 👋", color = White70, fontSize = 15.sp)
        Spacer(Modifier.height(4.dp))
        Text(
            "Ready to rise\ntoday?",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 30.sp,
            letterSpacing = (-0.5).sp
        )
        Spacer(Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(18.dp))
                .background(Color(0xFF15213B))
                .border(1.dp, GoldAccent.copy(0.4f), RoundedCornerShape(18.dp))
                .padding(horizontal = 12.dp, vertical = 6.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("🔥", fontSize = 13.sp)
                Spacer(Modifier.width(4.dp))
                Text("47-Day Streak", color = GoldAccent, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Text("  ·  Keep it up!", color = White40, fontSize = 11.sp)
            }
        }
    }
}

@Composable
private fun HeaderIconChip(icon: String, badge: String, badgeColor: Color = Color(0xFF111827)) {
    Box {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(HeroChipBg)
                .border(1.dp, HeroChipBorder, RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(icon, fontSize = 14.sp)
        }
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = 5.dp, y = (-5).dp)
                .size(16.dp)
                .clip(CircleShape)
                .background(badgeColor),
            contentAlignment = Alignment.Center
        ) {
            Text(badge, color = Color.White, fontSize = 9.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun SectionHeader(title: String, action: String, onAction: () -> Unit = {}) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, color = TextDark, fontSize = 15.sp, fontWeight = FontWeight.Bold)
        Text(action, color = GoldAccent, fontSize = 12.sp, fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable { onAction() })
    }
}

// ─────────────────────────────────────────────
// Today's Daily Trio
// ─────────────────────────────────────────────

@Composable
private fun DailyTrioSection(onDailyMCQClick: () -> Unit = {}, onDailyMainsClick: () -> Unit = {}, onDailyNewsClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("⚡  Today’s Daily Trio", color = TextDark, fontSize = 17.sp, fontWeight = FontWeight.ExtraBold)
            Text(
                "View All →",
                color = GoldAccent,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable { }
            )
        }
        Spacer(Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(Color.White)
                .border(1.dp, Color(0xFFE2E7F0), RoundedCornerShape(18.dp))
                .padding(10.dp)
        ) {
            Column {
                Text("Your 3 Daily Essentials", color = TextMid, fontSize = 15.sp, fontWeight = FontWeight.ExtraBold)
                Spacer(Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TrioCard(
                        modifier = Modifier.weight(1f),
                        emoji = "🎯",
                        title = "Daily MCQ",
                        sub = "Polity · 20 Qs",
                        actionLabel = "✓ Done",
                        actionBg = CheckedGreen.copy(0.12f),
                        actionColor = CheckedGreen,
                        borderColor = Color(0xFFCFE9D6),
                        topStripColor = Color(0xFF59A95F),
                        onClick = onDailyMCQClick
                    )
                    TrioCard(
                        modifier = Modifier.weight(1f),
                        emoji = "📰",
                        title = "Daily News",
                        sub = "Hindu · 8 arts",
                        actionLabel = "📖 Read",
                        actionBg = Color(0xFFFFF3E0),
                        actionColor = TagMains,
                        borderColor = Color(0xFFECD7AA),
                        topStripColor = Color(0xFFE0A62B),
                        onClick = onDailyNewsClick
                    )
                    TrioCard(
                        modifier = Modifier.weight(1f),
                        emoji = "✍️",
                        title = "Mains",
                        sub = "GS2 · 150w",
                        actionLabel = "🟦 Short",
                        actionBg = Color(0xFFE7F0FF),
                        actionColor = TagMCQ,
                        borderColor = Color(0xFFCBD5E6),
                        topStripColor = Color(0xFFA9B8CF),
                        onClick = onDailyMainsClick
                    )
                }
            }
        }
    }
}

@Composable
private fun TrioCard(
    modifier: Modifier,
    emoji: String,
    title: String,
    sub: String,
    actionLabel: String,
    actionBg: Color,
    actionColor: Color,
    borderColor: Color,
    topStripColor: Color,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .height(118.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, borderColor, RoundedCornerShape(12.dp))
            .background(Color(0xFFFFFFFF))
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .background(topStripColor)
        )
        Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 7.dp)) {
            Text(emoji, fontSize = 17.sp)
            Spacer(Modifier.height(4.dp))
            Text(title, color = TextDark, fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, maxLines = 1)
            Spacer(Modifier.height(1.dp))
            Text(sub, color = Color(0xFF667085), fontSize = 8.sp, maxLines = 1)
            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(actionBg)
                    .padding(horizontal = 7.dp, vertical = 3.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(actionLabel, color = actionColor, fontSize = 8.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

// ─────────────────────────────────────────────
// Today's Study Plan
// ─────────────────────────────────────────────

@Composable
private fun StudyPlanSection(onStudyPlanClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(10.dp)
    ) {
        SectionHeader("🗓️ Today's Study Plan", "Set Up →")
        Spacer(Modifier.height(10.dp))

        // Filled plan
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
                .border(1.dp, Color(0xFFE8EDF5), RoundedCornerShape(12.dp))
                .padding(12.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Today's Plan", color = TextDark, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    Text("3/5 done", color = TextLight, fontSize = 12.sp)
                }
                Spacer(Modifier.height(10.dp))
                val tasks = listOf(
                    Triple(true,  "Daily MCQ Practice (20-Q)", "MCQ"  ),
                    Triple(true,  "Current Affairs Reading",    "CA"   ),
                    Triple(true,  "Flashcard Review (50)",      "Rev"  ),
                    Triple(false, "Mains Answer Writing",       "Mains"),
                    Triple(false, "Mock Test — GS2 Paper",      "Test" ),
                )
                tasks.forEachIndexed { i, (done, label, tag) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(18.dp)
                                .clip(RoundedCornerShape(5.dp))
                                .background(if (done) CheckedGreen else Color.White)
                                .border(1.5.dp, if (done) CheckedGreen else DividerClr, RoundedCornerShape(5.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            if (done) Text("✓", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                        Spacer(Modifier.width(10.dp))
                        Text(
                            label,
                            color = if (done) TextLight else TextDark,
                            fontSize = 13.sp,
                            textDecoration = if (done) TextDecoration.LineThrough else TextDecoration.None,
                            modifier = Modifier.weight(1f)
                        )
                        if (tag.isNotEmpty()) {
                            val (tagBg, tagFg) = when (tag) {
                                "MCQ"   -> Color(0xFFEFF6FF) to TagMCQ
                                "CA"    -> Color(0xFFECFEFF) to TagCA
                                "Rev"   -> Color(0xFFF0FDF4) to TagRev
                                "Mains" -> Color(0xFFFFF7ED) to TagMains
                                "Test"  -> Color(0xFFFFF8E1) to Color(0xFFB77C00)
                                else    -> HomeBg to TextLight
                            }
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(tagBg)
                                    .padding(horizontal = 8.dp, vertical = 3.dp)
                            ) {
                                Text(tag, color = tagFg, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                    if (i < tasks.size - 1)
                        HorizontalDivider(color = DividerClr, thickness = 0.5.dp)
                }
            }
        }

        Spacer(Modifier.height(12.dp))
        SectionHeader("🗓️ Today's Study Plan", "Planner →")
        Spacer(Modifier.height(10.dp))

        // Empty planner widget
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .dashedBorder(
                    strokeWidth = 1.4.dp,
                    color = Color(0xFFB7C0CC),
                    cornerRadius = 20.dp
                )
                .background(Color.White)
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("📅", fontSize = 36.sp)
                Spacer(Modifier.height(8.dp))
                Text("No tasks added yet!", color = TextDark, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                Spacer(Modifier.height(4.dp))
                Text(
                    "Build your daily study schedule. Add tasks and we'll help you stick to them with smart reminders.",
                    color = Color(0xFF7183A6), fontSize = 12.sp,
                    textAlign = TextAlign.Center, lineHeight = 24.sp
                )
                Spacer(Modifier.height(14.dp))
                Box(
                    modifier = Modifier
                        .width(190.dp)
                        .height(46.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(GoldGradient)
                        .clickable { onStudyPlanClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Text("✨ Build My Study Plan→", color = Color(0xFF1A1A1A), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        }
    }
}

// ─────────────────────────────────────────────
// Syllabus Tracker
// ─────────────────────────────────────────────

@Composable
private fun SyllabusTrackerSection(onStartTracking: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(Res.drawable.syllabus_tracker_header),
                    contentDescription = "Syllabus Tracker",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(Modifier.width(6.dp))
                Text("Syllabus Tracker", color = TextDark, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
            Text("Track →", color = GoldAccent, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.clickable { onStartTracking() })
        }
        Spacer(Modifier.height(12.dp))

        // CTA for empty state
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .dashedBorder(
                    strokeWidth = 1.2.dp,
                    color = Color(0xFFCAD2DE),
                    cornerRadius = 20.dp
                )
                .background(Color.White)
                .padding(18.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
                ) {
                    listOf("⚖️ Polity","🏛 History","🌍 Geo","📈 Economy","🌿 Env").forEach { item ->
                        val (emoji, label) = item.split(" ", limit = 2).let { it[0] to it[1] }
                        Column(
                            modifier = Modifier
                                .width(62.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(Color(0xFFFFFFFF))
                                .border(1.dp, Color(0xFFE6EAF0), RoundedCornerShape(14.dp))
                                .padding(vertical = 7.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(emoji, fontSize = 18.sp)
                            Text(label, color = TextDark, fontSize = 9.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
                Spacer(Modifier.height(16.dp))
                Text("Begin Your Syllabus Journey", color = TextDark, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
                Text("Track all latest and core topics", color = Color(0xFF7183A6), fontSize = 13.sp)
                Spacer(Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .width(240.dp)
                        .height(48.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(GoldGradient)
                        .clickable { onStartTracking() },
                    contentAlignment = Alignment.Center
                ) {
                    Text("📚 Start Tracking Syllabus →", color = Color(0xFF1A1A1A), fontWeight = FontWeight.Bold, fontSize = 15.sp)
                }
            }
        }

        Spacer(Modifier.height(14.dp))

        // Progress rows
        val subjects = listOf(
            SyllabusProgressItem("⚖️", "Indian Polity & Governance", "16 of 38 topics", 0.43f),
            SyllabusProgressItem("🏛️", "Modern History", "8 of 32 topics", 0.25f),
            SyllabusProgressItem("🌍", "Indian & World Geography", "0 of 24 topics", 0.0f),
            SyllabusProgressItem("📈", "Indian Economy", "0 of 34 topics", 0.0f),
            SyllabusProgressItem("🌿", "Environment & Ecology", "0 of 18 topics", 0.0f),
            SyllabusProgressItem("🔬", "Science & Technology", "0 of 42 topics", 0.0f),
        )
        subjects.forEachIndexed { i, item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFFFFFFF))
                    .border(1.dp, Color(0xFFD3DAE6), RoundedCornerShape(12.dp))
                    .padding(horizontal = 10.dp, vertical = 8.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (item.name == "Science & Technology") {
                            Image(
                                painter = painterResource(Res.drawable.syllabus_science),
                                contentDescription = item.name,
                                modifier = Modifier.size(18.dp)
                            )
                        } else {
                            Text(item.emoji, fontSize = 18.sp)
                        }
                        Spacer(Modifier.width(10.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(item.name, color = TextDark, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                            Text(item.sub, color = TextLight, fontSize = 12.sp)
                        }
                        Spacer(Modifier.width(8.dp))
                        val progressLabel = "${(item.progress * 100).toInt()}%"
                        Text(
                            progressLabel,
                            color = if (item.progress > 0f) Color(0xFFF5A623) else Color(0xFFD4D4D4),
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(Modifier.height(6.dp))
                    LinearProgressIndicator(
                        progress = { item.progress },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(999.dp)),
                        color = Color(0xFFF5A623),
                        trackColor = Color(0xFFF5F5F5)
                    )
                }
            }
            Spacer(Modifier.height(8.dp))
            if (i < subjects.size - 1) Spacer(Modifier.height(2.dp))
        }
    }
}

// ─────────────────────────────────────────────
// Revision Suite
// ─────────────────────────────────────────────

@Composable
private fun RevisionSuiteSection(onExploreClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(10.dp)
    ) {
        SectionHeader("🧠 Revision Suite", "Explore →", onAction = onExploreClick)
        Spacer(Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFF8FAFC))
                .padding(14.dp)
        ) {
            Column {
                Text("Smart Revision Tools", color = TextDark, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                Spacer(Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    RevStatCard(Modifier.weight(1f), Res.drawable.rev_flashcards, "2,847", GoldAccent, "Flashcards", "Active Recall", Color(0xFF59A95F))
                    RevStatCard(Modifier.weight(1f), Res.drawable.rev_mindmaps, "24", Color(0xFFCC3E7B), "Mindmaps", "Visual Thinking", Color(0xFFE0A62B))
                    RevStatCard(Modifier.weight(1f), Res.drawable.rev_spaced_rep, "91%", Color(0xFF5F8FDB), "Spaced Rep", "Smart Scheduling", Color(0xFFA9B8CF))
                }
            }
        }

        Spacer(Modifier.height(14.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(Brush.linearGradient(listOf(Color(0xFF1A2540), Color(0xFF16233D))))
                .padding(horizontal = 14.dp, vertical = 12.dp)
        ) {
            Row(verticalAlignment = Alignment.Top) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color(0xFF33415F)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🎧", fontSize = 24.sp)
                }
                Spacer(Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        Column {
                            Text("FOCUS SESSION", color = White40, fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.1.sp)
                            Text(
                                "Study Mode",
                                color = Color.White,
                                fontSize = 33.sp,
                                lineHeight = 33.sp
                            )
                        }
                        Box(
                            modifier = Modifier
                                .padding(top = 14.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(GoldGradient)
                                .padding(horizontal = 16.dp, vertical = 10.dp)
                                .clickable {}
                        ) {
                            Text("Enter →", color = Color(0xFF1A1A1A), fontSize = 14.sp, fontWeight = FontWeight.ExtraBold)
                        }
                    }
                    Text("Distraction Free · Time Tracked ·", color = White70, fontSize = 13.sp)
                    Text("Streak protected", color = White70, fontSize = 13.sp)
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        listOf("📚 Deep Study", "📚 Deep Study", "📚 Deep Study").forEach { tag ->
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(999.dp))
                                    .background(White15)
                                    .padding(horizontal = 10.dp, vertical = 4.dp)
                            ) {
                                Text(tag, color = White70, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun RevStatCard(
    modifier: Modifier,
    iconRes: DrawableResource,
    value: String,
    valueColor: Color,
    label: String,
    sub: String,
    topStripColor: Color
) {
    Column(
        modifier = modifier
            .heightIn(min = 180.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .border(1.dp, Color(0xFFD2DBE8), RoundedCornerShape(16.dp))
            .padding(bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(topStripColor)
        )
        Spacer(Modifier.height(10.dp))
        Image(
            painter = painterResource(iconRes),
            contentDescription = label,
            modifier = Modifier.size(44.dp)
        )
        Spacer(Modifier.height(8.dp))
        Text(value, color = valueColor, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(Modifier.height(2.dp))
        Text(label, color = TextDark, fontSize = 10.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center, maxLines = 1)
        Text(sub, color = Color(0xFF7183A6), fontSize = 10.sp, textAlign = TextAlign.Center, maxLines = 1)
    }
}

private fun Modifier.dashedBorder(
    strokeWidth: Dp,
    color: Color,
    cornerRadius: Dp = 12.dp,
    on: Dp = 8.dp,
    off: Dp = 6.dp
): Modifier = drawBehind {
    val stroke = Stroke(
        width = strokeWidth.toPx(),
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(on.toPx(), off.toPx()))
    )
    drawRoundRect(
        color = color,
        cornerRadius = CornerRadius(cornerRadius.toPx(), cornerRadius.toPx()),
        style = stroke
    )
}

@Composable
private fun FloatingProfileBubble(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(64.dp)
            .shadow(10.dp, CircleShape)
            .clip(CircleShape)
            .background(Color(0xFF2A2444))
            .border(4.dp, Color(0xFF181628), CircleShape)
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color(0xFF4B3AC8)),
            contentAlignment = Alignment.Center
        ) {
            Text("P", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
    }
}

// ─────────────────────────────────────────────
// Quote
// ─────────────────────────────────────────────

@Composable
private fun QuoteSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFFFFCEB))
            .border(1.dp, Color(0xFFF1E7BC), RoundedCornerShape(16.dp))
            .padding(20.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("“", color = Color(0xFFE7D8A2), fontSize = 38.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.Start))
            Text(
                "\"The secret of getting ahead is getting started. Every sunrise is a new invitation to rise again.\"",
                color = Color(0xFF1E293B),
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                lineHeight = 32.sp
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "— For every UPSC Warrior · Rise with Jeet ✨",
                color = Color(0xFF8A7864),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        }
    }
}
