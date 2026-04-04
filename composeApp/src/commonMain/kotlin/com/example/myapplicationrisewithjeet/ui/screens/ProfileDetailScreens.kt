package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldAccent
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient
import com.example.myapplicationrisewithjeet.ui.theme.White
import com.example.myapplicationrisewithjeet.ui.theme.White70
import com.example.myapplicationrisewithjeet.ui.theme.dmSansFamily
import com.example.myapplicationrisewithjeet.ui.theme.playfairDisplayFamily

// ─── Shared color tokens ────────────────────────────────
private val DarkHeaderBg   = Color(0xFF061123)
private val LightCardBg    = Color(0xFFF0F4FA)
private val FieldBg        = Color.White
private val FieldBorder    = Color(0xFFE2EAF4)
private val LabelColor     = Color(0xFF8A97B0)
private val ValueDark      = Color(0xFF0D1B2E)
private val ActionGold     = Color(0xFFC9A84C)
private val AvatarGold     = Color(0xFFF5A623)

// ─────────────────────────────────────────────────────────
// Edit Profile
// ─────────────────────────────────────────────────────────
@Composable
fun EditProfileScreen(onBack: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkHeaderBg)
            .verticalScroll(rememberScrollState())
    ) {
        ProfileHeader(
            title = "Edit Profile",
            subtitle = "Tap photo to update",
            onBack = onBack,
            showAvatar = true
        )
        LightCard {
            EditField("FULL NAME",      "Rahul Sharma")
            EditField("EMAIL ADDRESS",  "rahul@email.com")
            EditField("MOBILE NUMBER",  "+91 98765 43210")
            EditField("TARGET YEAR",    "UPSC 2026")
            EditField("BACKGROUND",     "Hybrid Learner")
            Spacer(Modifier.height(4.dp))
            GoldButton("💾 Save Changes")
        }
    }
}

// ─────────────────────────────────────────────────────────
// Account Settings
// ─────────────────────────────────────────────────────────
@Composable
fun AccountSettingsScreen(onBack: () -> Unit = {}) {
    var systemTheme       by remember { mutableStateOf(true) }
    var lightTheme        by remember { mutableStateOf(false) }
    var darkTheme         by remember { mutableStateOf(true) }
    var vibration         by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkHeaderBg)
            .verticalScroll(rememberScrollState())
    ) {
        ProfileHeader(
            title = "Account Settings",
            subtitle = "Manage your profile & preferences",
            onBack = onBack,
            showAvatar = true
        )
        LightCard {
            SettingsSection("PROFILE")
            SettingsTile("FULL NAME",      "Rahul Sharma",        "Edit")
            SettingsTile("EMAIL ADDRESS",  "rahul@email.com",     "Edit")
            SettingsTile("MOBILE NUMBER",  "+91 98765 43210",     "Edit")
            SettingsTile("TARGET YEAR",    "UPSC 2026",           "Change")

            SettingsSection("SECURITY")
            SettingsTile("PASSWORD",       "•••••••••",           "Change")

            SettingsSection("NOTIFICATIONS")
            SettingsTile("DAILY REMINDER", "6:00 AM",             "Set Time")
            SettingsTile("STREAK ALERT",   "Enabled",             "Change",
                valueColor = Color(0xFF4CAF50))

            SettingsSection("THEME")
            // Theme toggles in a single white card
            WhiteCard {
                ToggleTile("System default", systemTheme)  { systemTheme  = it }
                HorizontalDivider(color = FieldBorder, thickness = 1.dp)
                ToggleTile("Light",          lightTheme)   { lightTheme   = it }
                HorizontalDivider(color = FieldBorder, thickness = 1.dp)
                ToggleTile("Dark",           darkTheme)    { darkTheme    = it }
            }

            SettingsSection("HAPTICS")
            WhiteCard {
                ToggleTile("Vibration on Feedback", vibration) { vibration = it }
            }

            Spacer(Modifier.height(8.dp))
            GoldButton("💾 Save Changes")
            Spacer(Modifier.height(8.dp))
            DangerOutlinedButton("🚪 Sign Out")
        }
    }
}

// ─────────────────────────────────────────────────────────
// Leaderboard
// ─────────────────────────────────────────────────────────
@Composable
fun LeaderboardScreen(onBack: () -> Unit = {}) {
    val entries = listOf(
        LeaderEntry("#4", "S", "Sneha",  "2,401", "32-day streak"),
        LeaderEntry("#5", "K", "Karan",  "2,319", "28-day streak"),
        LeaderEntry("#6", "M", "Meera",  "2,208", "21-day streak"),
        LeaderEntry("#7", "S", "Sneha",  "2,401", "32-day streak"),
        LeaderEntry("#8", "K", "Karan",  "2,319", "28-day streak"),
        LeaderEntry("#9", "M", "Meera",  "2,208", "21-day streak"),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkHeaderBg)
            .verticalScroll(rememberScrollState())
    ) {
        // Header (no avatar)
        ProfileHeader(
            title = "Leaderboard",
            subtitle = "This week's top performers",
            onBack = onBack,
            showAvatar = false,
            headerEmoji = "🏆"
        )

        // Podium (Ankit 2nd, Priya 1st, Ravi 3rd)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkHeaderBg)
                .padding(horizontal = 24.dp)
                .padding(bottom = 0.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            PodiumItem("A", "Ankit", "2,847", medal = "🥈",
                bgColor = Color(0xFFB8D4F0), size = 44.dp, barHeight = 52.dp)
            Spacer(Modifier.width(12.dp))
            PodiumItem("P", "Priya", "3,124", medal = "🥇",
                bgColor = null, size = 52.dp, barHeight = 57.dp, gold = true)
            Spacer(Modifier.width(12.dp))
            PodiumItem("R", "Ravi",  "2,612", medal = "🥉",
                bgColor = Color(0xFFC9A84C).copy(alpha = 0.22f), size = 40.dp, barHeight = 40.dp)
        }

        // List card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(LightCardBg)
                .padding(horizontal = 14.dp)
                .padding(top = 14.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val dmSans = dmSansFamily()

            // "You" highlighted row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .border(2.dp, Color(0xFFC9A84C), RoundedCornerShape(14.dp))
                    .background(Color(0xFFC9A84C).copy(alpha = 0.04f))
                    .shadow(0.dp, RoundedCornerShape(14.dp))
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("#47", color = Color(0xFFC9A84C), fontSize = 15.sp, fontWeight = FontWeight.Bold,
                    fontFamily = dmSans, modifier = Modifier.width(36.dp))
                Spacer(Modifier.width(10.dp))
                Box(
                    modifier = Modifier.size(34.dp).clip(RoundedCornerShape(10.dp))
                        .background(Brush.linearGradient(listOf(Color(0xFFC9A84C), Color(0xFFE8C56A), Color(0xFFC9A84C)))),
                    contentAlignment = Alignment.Center
                ) { Text("R", color = Color(0xFF061123), fontSize = 13.sp, fontWeight = FontWeight.Bold,
                    fontFamily = dmSans) }
                Spacer(Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text("You (Rahul)", color = ValueDark, fontSize = 14.sp, fontWeight = FontWeight.Normal,
                        fontFamily = dmSans, lineHeight = 14.sp)
                    Text("🔥 47-day streak", color = LabelColor, fontSize = 10.sp,
                        fontFamily = dmSans)
                }
                Text("1,847", color = ValueDark, fontSize = 14.sp, fontWeight = FontWeight.Normal,
                    fontFamily = dmSans, lineHeight = 14.sp)
            }

            entries.forEach { entry ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .border(1.dp, Color(0xFF0D1B3E).copy(alpha = 0.07f), RoundedCornerShape(14.dp))
                        .background(Color.White)
                        .padding(horizontal = 15.dp, vertical = 13.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(entry.rank, color = ValueDark, fontSize = 14.sp, fontWeight = FontWeight.Normal,
                        fontFamily = dmSans, lineHeight = 14.sp, modifier = Modifier.width(30.dp))
                    Spacer(Modifier.width(10.dp))
                    Box(
                        modifier = Modifier.size(34.dp).clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFD6E4F7)),
                        contentAlignment = Alignment.Center
                    ) { Text(entry.initial, color = ValueDark, fontSize = 13.sp, fontWeight = FontWeight.Bold,
                        fontFamily = dmSans) }
                    Spacer(Modifier.width(10.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(entry.name, color = ValueDark, fontSize = 14.sp, fontWeight = FontWeight.Normal,
                            fontFamily = dmSans, lineHeight = 14.sp)
                        Text("🔥 ${entry.streak}", color = LabelColor, fontSize = 10.sp,
                            fontFamily = dmSans)
                    }
                    Text(entry.score, color = ValueDark, fontSize = 14.sp, fontWeight = FontWeight.Normal,
                        fontFamily = dmSans, lineHeight = 14.sp)
                }
            }
        }
    }
}

private data class LeaderEntry(
    val rank: String, val initial: String, val name: String,
    val score: String, val streak: String
)

// ─────────────────────────────────────────────────────────
// Bookmarks
// ─────────────────────────────────────────────────────────
@Composable
fun BookmarksScreen(onBack: () -> Unit = {}) {
    val items = listOf(
        BookmarkItem("📄", Color(0xFFE3F2FD), "SC ruling on Electoral Bonds — Analysis",
            "The Hindu · Mar 20 · ", "Polity", Color(0xFF1976D2)),
        BookmarkItem("💡", Color(0xFFFFF9E6), "Basic Structure — UPSC 2019 Q.14",
            "Prelims · Polity · ", "PYQ", Color(0xFF42A5F5)),
        BookmarkItem("📝", Color(0xFFF3E5F5), "Monetary Policy Tools — My Notes",
            "Economy · GS-III", null, null),
        BookmarkItem("🌍", Color(0xFFE8F5E9), "India's NDC Targets 2070 — IE",
            "Mar 18 · ", "Env", Color(0xFF4CAF50)),
        BookmarkItem("📊", Color(0xFFFFF3E0), "GST Council — UPSC 2023 Q.47",
            "Prelims · Economy · ", "PYQ", Color(0xFF42A5F5)),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkHeaderBg)
            .verticalScroll(rememberScrollState())
    ) {
        ProfileHeader(
            title = "Bookmarks",
            subtitle = "Your saved articles, questions & notes",
            onBack = onBack,
            showAvatar = false,
            headerEmoji = "🔖"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(LightCardBg)
                .padding(horizontal = 21.dp)
                .padding(top = 24.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val dmSans = dmSansFamily()
            items.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color.White)
                        .padding(horizontal = 14.dp, vertical = 14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.size(40.dp).clip(RoundedCornerShape(10.dp))
                            .background(item.iconBg),
                        contentAlignment = Alignment.Center
                    ) { Text(item.icon, fontSize = 18.sp) }
                    Spacer(Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(item.title, color = ValueDark, fontSize = 14.sp,
                            fontWeight = FontWeight.Normal, fontFamily = dmSans,
                            lineHeight = 14.sp)
                        Spacer(Modifier.height(2.dp))
                        Row {
                            Text(item.metaPrefix, color = Color(0xFF999999), fontSize = 10.sp,
                                fontFamily = dmSans)
                            if (item.tag != null) {
                                Text(item.tag, color = item.tagColor ?: Color(0xFF999999),
                                    fontSize = 10.sp, fontWeight = FontWeight.Bold,
                                    fontFamily = dmSans, letterSpacing = 0.7.sp)
                            }
                        }
                    }
                    Spacer(Modifier.width(8.dp))
                    Text("📌", fontSize = 18.sp, color = Color(0xFFF5A623))
                }
            }
        }
    }
}

private data class BookmarkItem(
    val icon: String, val iconBg: Color, val title: String,
    val metaPrefix: String, val tag: String?, val tagColor: Color?
)

// ─────────────────────────────────────────────────────────
// Premium Plans
// ─────────────────────────────────────────────────────────
@Composable
fun PremiumPlansScreen(onBack: () -> Unit = {}) {
    var selectedTab by remember { mutableStateOf(0) } // 0=Monthly, 1=Yearly

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkHeaderBg)
            .verticalScroll(rememberScrollState())
    ) {
        ProfileHeader(
            title = "Premium Plans",
            subtitle = "Unlock full power of RiseWithJeet AI",
            onBack = onBack,
            showAvatar = false,
            headerEmoji = "🏅"
        )

        // Free trial banner
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFED9F21))
                .padding(horizontal = 18.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("🎁", fontSize = 24.sp)
            Spacer(Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text("7-Day Free Trial", color = Color(0xFF1A1A1A), fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraBold, letterSpacing = (-0.3).sp)
                Text("Full access, no credit card required", color = Color.Black.copy(alpha = 0.6f),
                    fontSize = 9.sp, fontWeight = FontWeight.SemiBold)
            }
            Box(
                modifier = Modifier.clip(RoundedCornerShape(9.dp))
                    .background(Color(0xFF0D1B3E))
                    .padding(horizontal = 12.dp, vertical = 7.dp)
            ) {
                Text("Claim Free", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(Modifier.height(18.dp))

        // Main card area
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(LightCardBg)
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp, bottom = 40.dp)
        ) {
            // Monthly / Yearly toggle
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFED9F21))
            ) {
                Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                    // Monthly
                    Box(
                        modifier = Modifier.weight(1f).fillMaxHeight()
                            .clickable { selectedTab = 0 },
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Monthly", color = Color(0xFF1A1A1A),
                            fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }
                    // Yearly (dark pill)
                    Box(
                        modifier = Modifier
                            .weight(1f).fillMaxHeight()
                            .padding(5.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFF0D1B3E))
                            .clickable { selectedTab = 1 },
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center) {
                            Text("Yearly", color = Color.White, fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold)
                            Spacer(Modifier.width(8.dp))
                            Box(
                                modifier = Modifier.clip(RoundedCornerShape(6.dp))
                                    .background(Color(0xFFF5C842))
                                    .padding(horizontal = 6.dp, vertical = 3.dp)
                            ) {
                                Text("Save 60%", color = Color(0xFF1A1A1A), fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold)
                            }
                        }
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            // Basic plan card
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color.White)
                    .padding(horizontal = 20.dp, vertical = 20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("📘", fontSize = 16.sp)
                    Spacer(Modifier.width(8.dp))
                    Text("Basic", color = ValueDark, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold,
                        letterSpacing = (-0.3).sp)
                }
                Spacer(Modifier.height(12.dp))
                Row(verticalAlignment = Alignment.Bottom) {
                    Text("₹0", color = ValueDark, fontSize = 32.sp, fontWeight = FontWeight.ExtraBold,
                        letterSpacing = (-1).sp)
                    Text("/ month", color = LabelColor, fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(bottom = 4.dp, start = 2.dp))
                }
                Spacer(Modifier.height(6.dp))
                Text("Get started with core features", color = LabelColor, fontSize = 12.sp)
                Spacer(Modifier.height(16.dp))
                FeatureRow("✓", "10 MCQs per day", enabled = true)
                FeatureRow("✓", "Daily Current Affairs", enabled = true)
                FeatureRow("✓", "Basic flashcards", enabled = true)
                FeatureRow("✗", "AI Mains Evaluation", enabled = false)
                FeatureRow("✗", "Jeet AI Tutor", enabled = false)
                Spacer(Modifier.height(16.dp))
                GoldButton("Change Plans")
            }

            Spacer(Modifier.height(20.dp))

            // Pro plan card
            Box(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp))
                        .border(2.4.dp, Color(0xFFF5C842), RoundedCornerShape(18.dp))
                        .background(Color.White)
                        .padding(horizontal = 20.dp)
                        .padding(top = 28.dp, bottom = 20.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("⚡", fontSize = 16.sp)
                        Spacer(Modifier.width(8.dp))
                        Text("Pro", color = ValueDark, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold,
                            letterSpacing = (-0.3).sp)
                    }
                    Spacer(Modifier.height(12.dp))
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text("₹499", color = ValueDark, fontSize = 32.sp, fontWeight = FontWeight.ExtraBold,
                            letterSpacing = (-1).sp)
                        Text("/ month", color = LabelColor, fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(bottom = 4.dp, start = 2.dp))
                    }
                    Text("or ₹3,499/year (save ₹2,489)", color = LabelColor, fontSize = 11.sp)
                    Spacer(Modifier.height(16.dp))
                    FeatureRow("✓", "Unlimited MCQ Practice", enabled = true, bold = true)
                    FeatureRow("✓", "Jeet AI Tutor (24/7)", enabled = true, bold = true)
                    FeatureRow("✓", "AI Mains Evaluation (unlimited)", enabled = true, bold = true)
                }
                // "MOST POPULAR" badge
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(x = 16.dp, y = (-14).dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Brush.linearGradient(
                            listOf(Color(0xFFFF6B35), Color(0xFFFF8C42))))
                        .padding(horizontal = 14.dp, vertical = 6.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("⭐", fontSize = 10.sp)
                        Spacer(Modifier.width(4.dp))
                        Text("MOST POPULAR", color = Color.White, fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold, letterSpacing = (-0.2).sp)
                    }
                }
            }
        }
    }
}

// ─────────────────────────────────────────────────────────
// Shared Components
// ─────────────────────────────────────────────────────────

@Composable
private fun ProfileHeader(
    title: String,
    subtitle: String,
    onBack: () -> Unit,
    showAvatar: Boolean,
    headerEmoji: String = ""
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkHeaderBg)
            .statusBarsPadding()
            .padding(top = 16.dp, bottom = 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Back arrow
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("←", color = Color(0xFF6A7282), fontSize = 16.sp,
                modifier = Modifier.clickable { onBack() })
        }

        Spacer(Modifier.height(8.dp))

        if (showAvatar) {
            // Avatar with camera badge
            Box(contentAlignment = Alignment.BottomEnd) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .background(AvatarGold),
                    contentAlignment = Alignment.Center
                ) {
                    Text("R", color = Color(0xFF0D1B3E), fontSize = 26.sp, fontWeight = FontWeight.Bold)
                }
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .offset(x = 4.dp, y = 9.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFC9A84C))
                        .border(2.dp, Color(0xFF1E3163), RoundedCornerShape(10.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("📷", fontSize = 8.sp)
                }
            }
        } else {
            Text(headerEmoji, fontSize = 36.sp)
        }

        Spacer(Modifier.height(12.dp))
        Text(title, color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Normal,
            fontFamily = playfairDisplayFamily(), lineHeight = 22.sp)
        Spacer(Modifier.height(4.dp))
        Text(subtitle, color = Color.White.copy(alpha = 0.5f), fontSize = 12.sp,
            fontFamily = dmSansFamily(), fontWeight = FontWeight.Normal, lineHeight = 12.sp)
        Spacer(Modifier.height(22.dp))
    }
}

@Composable
private fun LightCard(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
            .background(LightCardBg)
            .padding(horizontal = 16.dp)
            .padding(top = 22.dp, bottom = 40.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp),
        content = content
    )
}

@Composable
private fun WhiteCard(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .border(1.dp, FieldBorder, RoundedCornerShape(14.dp))
            .background(FieldBg)
            .padding(horizontal = 16.dp),
        content = content
    )
    Spacer(Modifier.height(8.dp))
}

@Composable
private fun EditField(label: String, value: String) {
    val dmSans = dmSansFamily()
    Text(label, color = LabelColor, fontSize = 10.sp, fontWeight = FontWeight.Bold,
        fontFamily = dmSans, letterSpacing = 0.7.sp, lineHeight = 10.sp)
    Spacer(Modifier.height(6.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(13.dp))
            .background(FieldBg)
            .border(1.dp, FieldBorder, RoundedCornerShape(13.dp))
            .padding(horizontal = 16.dp, vertical = 14.dp)
    ) {
        Text(value, color = ValueDark, fontSize = 14.sp,
            fontFamily = dmSans, fontWeight = FontWeight.Normal, lineHeight = 14.sp)
    }
    Spacer(Modifier.height(13.dp))
}

@Composable
private fun SettingsSection(label: String) {
    Spacer(Modifier.height(8.dp))
    Text(label, color = LabelColor, fontSize = 10.sp, fontWeight = FontWeight.Bold,
        fontFamily = dmSansFamily(), letterSpacing = 0.7.sp, lineHeight = 10.sp)
    Spacer(Modifier.height(8.dp))
}

@Composable
private fun SettingsTile(
    label: String,
    value: String,
    action: String,
    valueColor: Color = ValueDark
) {
    val dmSans = dmSansFamily()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .border(1.dp, FieldBorder, RoundedCornerShape(14.dp))
            .background(FieldBg)
            .padding(horizontal = 16.dp, vertical = 14.dp)
    ) {
        Text(label, color = LabelColor, fontSize = 10.sp, fontWeight = FontWeight.Bold,
            fontFamily = dmSans, letterSpacing = 0.7.sp, lineHeight = 10.sp)
        Spacer(Modifier.height(4.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(value, color = valueColor, fontSize = 14.sp, fontWeight = FontWeight.Normal,
                fontFamily = dmSans, lineHeight = 14.sp, modifier = Modifier.weight(1f))
            Text(action, color = ActionGold, fontSize = 11.sp, fontWeight = FontWeight.SemiBold,
                fontFamily = dmSans)
        }
    }
    Spacer(Modifier.height(8.dp))
}

@Composable
private fun ToggleTile(title: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, color = ValueDark, fontSize = 14.sp, fontWeight = FontWeight.Normal,
            fontFamily = dmSansFamily(), lineHeight = 14.sp, modifier = Modifier.weight(1f))
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = White,
                checkedTrackColor = Color(0xFF1E2D4F),
                uncheckedThumbColor = White,
                uncheckedTrackColor = Color(0xFF1E2D4F)
            )
        )
    }
}

@Composable
private fun GoldButton(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(47.dp)
            .clip(RoundedCornerShape(14.dp))
            .shadow(0.dp, RoundedCornerShape(14.dp), ambientColor = GoldAccent.copy(alpha = 0.3f))
            .background(GoldGradient)
            .clickable {},
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = Color(0xFF0D1B3E), fontWeight = FontWeight.Bold, fontSize = 14.sp,
            letterSpacing = 0.3.sp)
    }
}

@Composable
private fun DangerOutlinedButton(text: String) {
    Spacer(Modifier.height(8.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .clip(RoundedCornerShape(13.dp))
            .border(2.dp, Color(0xFFE74C3C), RoundedCornerShape(13.dp))
            .background(Color(0xFFE74C3C).copy(alpha = 0.04f))
            .clickable {},
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = Color(0xFFE74C3C), fontWeight = FontWeight.Bold, fontSize = 13.sp)
    }
}

@Composable
private fun PodiumItem(
    letter: String, name: String, score: String, medal: String,
    bgColor: Color?, size: Dp, barHeight: Dp, gold: Boolean = false
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(size)
                .clip(RoundedCornerShape(if (gold) 14.dp else 12.dp))
                .background(
                    if (gold) Brush.linearGradient(listOf(Color(0xFFC9A84C), Color(0xFFE8C56A), Color(0xFFC9A84C)))
                    else Brush.linearGradient(listOf(bgColor!!, bgColor))
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(letter, color = Color(0xFF061123), fontSize = if (gold) 20.sp else 17.sp,
                fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(4.dp))
        Text(name, color = White70, fontSize = 10.sp)
        Text(score, color = Color(0xFFC9A84C), fontSize = if (gold) 12.sp else 11.sp,
            fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .width(size)
                .height(barHeight)
                .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                .background(Color.White.copy(alpha = if (gold) 0.1f else 0.07f)),
            contentAlignment = Alignment.Center
        ) {
            Text(medal, fontSize = if (gold) 22.sp else 18.sp)
        }
    }
}

@Composable
private fun FeatureRow(mark: String, text: String, enabled: Boolean, bold: Boolean = false) {
    val dmSans = dmSansFamily()
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 8.dp)) {
        Text(mark, color = if (enabled) Color(0xFF4CAF50) else Color(0xFFE0E0E0), fontSize = 14.sp,
            fontFamily = dmSans)
        Spacer(Modifier.width(8.dp))
        Text(text,
            color = if (enabled) ValueDark else LabelColor,
            fontSize = 14.sp,
            fontFamily = dmSans,
            fontWeight = FontWeight.Normal,
            lineHeight = 14.sp)
    }
}
