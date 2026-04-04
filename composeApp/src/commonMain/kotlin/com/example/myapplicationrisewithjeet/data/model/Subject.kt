package com.example.myapplicationrisewithjeet.data.model

data class Subject(
    val id: String,
    val name: String,
    val emoji: String,
    val description: String,
    val totalTopics: Int,
    val completedTopics: Int = 0,
    val color: SubjectColor = SubjectColor.SAFFRON
)

enum class SubjectColor { SAFFRON, NAVY, GREEN, GOLD, TEAL, PURPLE, RED }

val upscSubjects = listOf(
    Subject("history", "History", "🏛️", "Ancient, Medieval & Modern India", 120, 34, SubjectColor.SAFFRON),
    Subject("geography", "Geography", "🌍", "Physical, Human & Indian Geography", 95, 20, SubjectColor.NAVY),
    Subject("polity", "Indian Polity", "⚖️", "Constitution, Governance & Laws", 80, 45, SubjectColor.GREEN),
    Subject("economy", "Economy", "📈", "Indian & World Economy Concepts", 70, 15, SubjectColor.GOLD),
    Subject("science", "Science & Tech", "🔬", "Physics, Chemistry, Biology & Tech", 60, 8, SubjectColor.TEAL),
    Subject("environment", "Environment", "🌿", "Ecology, Biodiversity & Climate", 50, 12, SubjectColor.GREEN),
    Subject("current_affairs", "Current Affairs", "📰", "Daily News & Events", 365, 90, SubjectColor.SAFFRON),
    Subject("art_culture", "Art & Culture", "🎭", "Heritage, Music, Dance & Literature", 45, 5, SubjectColor.PURPLE),
    Subject("ethics", "Ethics", "🧭", "GS Paper IV – Ethics & Integrity", 40, 10, SubjectColor.NAVY),
    Subject("csat", "CSAT", "🧮", "Aptitude, Comprehension & Reasoning", 55, 22, SubjectColor.GOLD),
)
