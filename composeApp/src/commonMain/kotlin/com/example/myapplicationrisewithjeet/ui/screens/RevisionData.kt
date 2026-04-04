package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.ui.graphics.Color

data class RevisionSubject(
    val id: String,
    val emoji: String,
    val name: String,
    val cardCount: Int,
    val dueToday: Int
)

data class RevisionTopic(
    val id: String,
    val emoji: String,
    val name: String,
    val nodeCount: Int,
    val badge: String = "",   // "Updated", "New", or ""
    val badgeColor: Color = Color.Transparent
)

val revisionSubjects = listOf(
    RevisionSubject("history",      "🏛",  "History",        248, 22),
    RevisionSubject("polity",       "⚖️",  "Polity",         184, 18),
    RevisionSubject("economy",      "💰",  "Economy",        136,  7),
    RevisionSubject("environment",  "🌿",  "Environment",     92,  0),
    RevisionSubject("geography",    "🌍",  "Geography",      248, 22),
    RevisionSubject("scitech",      "🧬",  "Science &\nTech", 92,  0),
    RevisionSubject("current",      "📰",  "Current\nAffairs",136,  7),
)

val polityTopics = listOf(
    RevisionTopic("federalism",     "🏛",  "Federalism",           18, "Updated", Color(0xFFF0A500)),
    RevisionTopic("fundrights",     "⚖️",  "Fundamental\nRights",  24, "New",     Color(0xFF22C55E)),
    RevisionTopic("consbodies",     "🏢",  "Constitutional\nBodies",21),
    RevisionTopic("parliament",     "📜",  "Parliament",           16),
    RevisionTopic("emergency",      "⚡",  "Emergency\nProvisions", 12),
)

// Mindmap node data for Federalism
data class MindMapNode(val label: String, val sublabel: String, val offsetX: Float, val offsetY: Float)

val federalismNodes = listOf(
    MindMapNode("Basic Structure", "Kesavananda 1973",  0f,    -130f),
    MindMapNode("Executive",       "President, PM",      120f,  -70f),
    MindMapNode("Judiciary",       "SC, HC, Others",     120f,   40f),
    MindMapNode("Parliament",      "Art. 79 · Bicam.",  -30f,   130f),
    MindMapNode("Fundamental\nRights","Art. 12-35",      50f,   130f),
    MindMapNode("DPSP",            "Art. 36-51",        -140f,   20f),
)
