package com.example.myapplicationrisewithjeet.ui.screens

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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.*

@Composable
fun ProfileScreen(
    onEditProfile: () -> Unit = {},
    onAccountSettings: () -> Unit = {},
    onLeaderboard: () -> Unit = {},
    onBookmarks: () -> Unit = {},
    onPremiumPlans: () -> Unit = {},
    onRateUs: () -> Unit = {},
    onHelpSupport: () -> Unit = {},
    onSignOut: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF060F1F))
            .verticalScroll(rememberScrollState())
    ) {
        // ── Dark header ───────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF060F1F))
                .statusBarsPadding()
                .padding(top = 36.dp, bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar with shadow
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .shadow(
                        elevation = 12.dp,
                        shape = RoundedCornerShape(18.dp),
                        ambientColor = Color(0xFFF5C642).copy(alpha = 0.3f),
                        spotColor = Color(0xFFF5C642).copy(alpha = 0.3f)
                    )
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(0xFFF5A623)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "R",
                    color = Color(0xFF1A1A1A),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Spacer(Modifier.height(16.dp))

            Text(
                "Rahul Sharma",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = (-0.5).sp
            )
            Spacer(Modifier.height(4.dp))
            Text(
                "UPSC 2026 · Sociology",
                color = Color.White.copy(alpha = 0.6f),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(Modifier.height(14.dp))

            // Streak pill — solid gold
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFF5A623))
                    .padding(horizontal = 18.dp, vertical = 9.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("🔥", fontSize = 14.sp)
                    Spacer(Modifier.width(6.dp))
                    Text(
                        "47-Day Streak",
                        color = Color(0xFF1A1A1A),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = (-0.2).sp
                    )
                }
            }
        }

        // ── Light card container ──────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
                .background(Color(0xFFF0F4FA))
                .padding(horizontal = 12.dp)
                .padding(top = 4.dp, bottom = 32.dp)
        ) {
            // My Analytics — dark row
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF0D1B2E))
                    .clickable {}
                    .padding(horizontal = 14.dp, vertical = 14.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("📊", fontSize = 18.sp)
                    Spacer(Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            "My Analytics",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = (-0.2).sp
                        )
                        Spacer(Modifier.height(2.dp))
                        Text(
                            "Performance & insights",
                            color = Color.White.copy(alpha = 0.6f),
                            fontSize = 11.sp
                        )
                    }
                    Text("›", color = Color.White.copy(alpha = 0.4f), fontSize = 16.sp)
                }
            }

            Spacer(Modifier.height(8.dp))

            // White card with menu items
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
            ) {
                val menuItems = listOf(
                    MenuItemData("✏️", "Edit Profile",       "Update name, photo, target",  onEditProfile),
                    MenuItemData("⚙️", "Account Settings",   "Email, phone, password",       onAccountSettings),
                    MenuItemData("🏆", "Leaderboard",        "You're ranked #47 this week",  onLeaderboard),
                    MenuItemData("🔖", "Bookmarks",          "47 saved items",               onBookmarks),
                    MenuItemData("🥇", "Go Premium",         "7-day free trial available",   onPremiumPlans),
                    MenuItemData("⭐", "Rate Us",            "Love the app? Tell us!",        onRateUs),
                    MenuItemData("🤝", "Help & Support",     "FAQs, contact, report",        onHelpSupport),
                )

                menuItems.forEachIndexed { index, item ->
                    ProfileMenuItem(item = item)
                    if (index < menuItems.lastIndex) {
                        HorizontalDivider(
                            modifier = Modifier.padding(start = 56.dp),
                            color = Color(0xFF99A1AF).copy(alpha = 0.15f),
                            thickness = 1.dp
                        )
                    }
                }

                // Sign Out
                HorizontalDivider(
                    modifier = Modifier.padding(start = 56.dp),
                    color = Color(0xFF99A1AF).copy(alpha = 0.15f),
                    thickness = 1.dp
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSignOut() }
                        .padding(horizontal = 16.dp, vertical = 18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("📕", fontSize = 18.sp)
                    Spacer(Modifier.width(12.dp))
                    Text(
                        "Sign Out",
                        color = Color(0xFFE74C3C),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = (-0.2).sp
                    )
                }
            }
        }
    }
}

// ─────────────────────────────────────────────
// Components
// ─────────────────────────────────────────────

private data class MenuItemData(
    val emoji: String,
    val title: String,
    val subtitle: String,
    val onClick: () -> Unit
)

@Composable
private fun ProfileMenuItem(item: MenuItemData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { item.onClick() }
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(item.emoji, fontSize = 18.sp)
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                item.title,
                color = Color(0xFF0D1B2E),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.2).sp
            )
            Spacer(Modifier.height(1.dp))
            Text(
                item.subtitle,
                color = Color(0xFF6B82A0),
                fontSize = 11.sp
            )
        }
    }
}
