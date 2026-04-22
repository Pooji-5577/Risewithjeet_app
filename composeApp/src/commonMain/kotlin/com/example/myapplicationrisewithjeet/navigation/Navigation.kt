package com.example.myapplicationrisewithjeet.navigation

sealed class Screen {
    // Onboarding flow
    data object Splash      : Screen()
    data object Login       : Screen()
    data object Onboarding  : Screen()
    // Main app
    data object Home        : Screen()
    data object Prelims     : Screen()
    data object Mains       : Screen()
    data object Revision    : Screen()
    data object News        : Screen()
    data object Profile     : Screen()
    data object EditProfile : Screen()
    data object AccountSettings : Screen()
    data object Leaderboard : Screen()
    data object Bookmarks   : Screen()
    data object PremiumPlans: Screen()
    data object RateUs       : Screen()
    data object HelpSupport  : Screen()
    data class SubjectDetail(val subjectId: String) : Screen()
    data class SubjectQuiz(val subjectId: String)   : Screen()
    data object DailyNews           : Screen()
    data object RevisionSuite       : Screen()
    data object FlashcardVault      : Screen()
    data class  FlashcardTopics(val subjectId: String) : Screen()
    data class  FlashcardStudy(val topicId: String)    : Screen()
    data object MindMaps            : Screen()
    data class  MindMapTopics(val subjectId: String)   : Screen()
    data class  MindMapView(val topicId: String)       : Screen()
    data object StudyPlanner        : Screen()
    data object MockTestPlatform    : Screen()
    data class  MockTestSummary(val isMains: Boolean) : Screen()
    data class  MockTestGenerating(val isMains: Boolean) : Screen()
    data object PerformanceAnalysis : Screen()
    data object PerformanceStudyStreakTracker : Screen()
    data object PerformanceWeakAreasTracker : Screen()
    data object PerformanceDailyTrioTracker : Screen()
    data object PerformanceCompleteTestHistory : Screen()
    data object PerformanceAchievementBadges : Screen()
    data object PerformanceWeeklyLeaderboard : Screen()
    data object PerformanceJeetAIReport : Screen()
    data object TestAnalytics       : Screen()
    data object BuildStudyPlan      : Screen()
    data object FocusSession        : Screen()
    data object PlanComplete        : Screen()
    data object DailyMainsChallenge : Screen()
    data object MainsMockQuestions  : Screen()
    data object MockTestAnswer      : Screen()
    data object EvaluationResult    : Screen()
    data object ExaminerMarkup      : Screen()
    data object WhatNext            : Screen()
    data object JeetAI              : Screen()
    data object VideoLectures       : Screen()
    data object IndianPolityVideos  : Screen()
    data object IndianPolityWatch   : Screen()
    data object IndianPolityPdf     : Screen()
    data object JeetAILoading          : Screen()
    data object JeetAISummary          : Screen()
    data object SyllabusTracker        : Screen()
    data object SyllabusSubjectSelect  : Screen()
    data class  SyllabusSubTopics(val subjectId: String) : Screen()
    data class  SyllabusTopicDetail(val subTopicId: String) : Screen()
    // Daily MCQ flow
    data object DailyMCQSetup       : Screen()
    data object DailyMCQChallenge   : Screen()
    data object DailyMCQQuestion    : Screen()
    data object DailyMCQResult      : Screen()
    data object DailyMCQReview      : Screen()
    data object DailyMCQNextSteps   : Screen()
    // PYQ flow (original)
    data object PYQHome             : Screen()
    data object PYQSubjectSelect    : Screen()
    data object PYQSubjectTopics    : Screen()
    data object PYQQuestion         : Screen()
    data object PYQSessionResult    : Screen()
    data object PYQReview           : Screen()
    data object PYQAIScore          : Screen()
    data object PYQMainsEval        : Screen()
    data object PYQWhatNext         : Screen()
    // PYQ new flow
    data object PYQNew                                  : Screen()
    data class  PYQNewSubTopics(val subjectId: String)  : Screen()
    data class  PYQNewTopicDetail(val subTopicId: String) : Screen()
    data class  PYQNewSetup(val topicId: String)        : Screen()
    data object PYQNewReady                             : Screen()
}

data class NavItem(
    val screen: Screen,
    val label: String,
    val emoji: String
)

val bottomNavItems = listOf(
    NavItem(Screen.Home,     "Home",     "🏠"),
    NavItem(Screen.Prelims,  "Prelims",  "🎯"),
    NavItem(Screen.Mains,    "Mains",    "✏️"),
    NavItem(Screen.Revision, "Revision", "🧠"),
    NavItem(Screen.News,     "News",     "📰"),
)
