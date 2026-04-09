package com.example.myapplicationrisewithjeet

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.example.myapplicationrisewithjeet.navigation.Screen
import com.example.myapplicationrisewithjeet.navigation.bottomNavItems
import com.example.myapplicationrisewithjeet.ui.screens.*
import com.example.myapplicationrisewithjeet.ui.theme.*

@Composable
fun App() {
    RiseWithJeetTheme {
        var currentScreen   by remember { mutableStateOf<Screen>(Screen.Splash) }
        var studyPlanBuilt  by remember { mutableStateOf(false) }

        // Onboarding flow — no bottom nav
        when (currentScreen) {
            is Screen.Splash -> {
                SplashScreen(
                    onGetStarted = { currentScreen = Screen.Login },
                    onSignIn     = { currentScreen = Screen.Login }
                )
                return@RiseWithJeetTheme
            }
            is Screen.Login -> {
                LoginScreen(
                    onBack          = { currentScreen = Screen.Splash },
                    onSignIn        = { currentScreen = Screen.Onboarding },
                    onCreateAccount = { currentScreen = Screen.Onboarding }
                )
                return@RiseWithJeetTheme
            }
            is Screen.Onboarding -> {
                OnboardingScreen(onContinue = { currentScreen = Screen.Home })
                return@RiseWithJeetTheme
            }
            else -> Unit
        }

        // Main app — with bottom nav
        val showBottomBar = when (currentScreen) {
            is Screen.Home,
            is Screen.Prelims,
            is Screen.Mains,
            is Screen.Revision,
            is Screen.News,
            is Screen.Profile -> true
            else -> false
        }

        Scaffold(
            bottomBar = {
                if (showBottomBar) {
                    RiseBottomNav(
                        currentScreen = currentScreen,
                        onNavigate    = { currentScreen = it }
                    )
                }
            },
            containerColor = Color(0xFFF2F3F8)
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = innerPadding.calculateBottomPadding())
            ) {
                key(currentScreen) {
                    when (val screen = currentScreen) {
                        is Screen.Home     -> HomeScreen(
                            onProfileClick                = { currentScreen = Screen.Profile },
                            onQuizClick                   = { currentScreen = Screen.DailyMCQSetup },
                            onPyqsClick                   = { currentScreen = Screen.PYQHome },
                            onDailyMainsClick             = { currentScreen = Screen.DailyMainsChallenge },
                            onDailyNewsClick              = { currentScreen = Screen.DailyNews },
                            onStudyPlanClick              = { currentScreen = Screen.StudyPlanner },
                            onRevisionSuiteClick          = { currentScreen = Screen.RevisionSuite },
                            onJeetAIClick                 = { currentScreen = Screen.JeetAI },
                            onStartTrackingSyllabusClick  = { currentScreen = Screen.SyllabusTracker },
                            onPreviousYearQuestionsClick  = { currentScreen = Screen.PYQNew }
                        )
                        is Screen.SyllabusTracker -> SyllabusTrackerScreen(
                            onBack          = { currentScreen = Screen.Home },
                            onStartTracking = { currentScreen = Screen.SyllabusSubjectSelect }
                        )
                        is Screen.SyllabusSubjectSelect -> SyllabusSubjectSelectScreen(
                            onBack              = { currentScreen = Screen.SyllabusTracker },
                            onSubjectSelected   = { id -> currentScreen = Screen.SyllabusSubTopics(id) }
                        )
                        is Screen.SyllabusSubTopics -> SyllabusSubTopicsScreen(
                            subjectId          = screen.subjectId,
                            onBack             = { currentScreen = Screen.SyllabusSubjectSelect },
                            onSubTopicSelected = { id -> currentScreen = Screen.SyllabusTopicDetail(id) }
                        )
                        is Screen.SyllabusTopicDetail -> SyllabusTopicDetailScreen(
                            subTopicId = screen.subTopicId,
                            onBack     = { currentScreen = Screen.SyllabusSubjectSelect }
                        )
                        is Screen.JeetAI -> JeetAIScreen(
                            onBack = { currentScreen = Screen.Home }
                        )
                        is Screen.RevisionSuite -> RevisionSuiteScreen(
                            onBack           = { currentScreen = Screen.Home },
                            onOpenFlashcards = { currentScreen = Screen.FlashcardVault },
                            onOpenMindMaps   = { currentScreen = Screen.MindMaps },
                            onOpenSpacedRep  = { currentScreen = Screen.RevisionSuite }
                        )
                        is Screen.FlashcardVault -> FlashcardVaultScreen(
                            onBack         = { currentScreen = Screen.RevisionSuite },
                            onSubjectClick = { id -> currentScreen = Screen.FlashcardTopics(id) }
                        )
                        is Screen.FlashcardTopics -> FlashcardTopicsScreen(
                            subjectId    = screen.subjectId,
                            onBack       = { currentScreen = Screen.FlashcardVault },
                            onTopicClick = { id -> currentScreen = Screen.FlashcardStudy(id) }
                        )
                        is Screen.FlashcardStudy -> FlashcardStudyScreen(
                            topicId = screen.topicId,
                            onBack  = { currentScreen = Screen.FlashcardTopics("polity") }
                        )
                        is Screen.MindMaps -> MindMapsScreen(
                            onBack         = { currentScreen = Screen.RevisionSuite },
                            onSubjectClick = { id -> currentScreen = Screen.MindMapTopics(id) }
                        )
                        is Screen.MindMapTopics -> MindMapTopicsScreen(
                            subjectId    = screen.subjectId,
                            onBack       = { currentScreen = Screen.MindMaps },
                            onTopicClick = { id -> currentScreen = Screen.MindMapView(id) }
                        )
                        is Screen.MindMapView -> MindMapViewScreen(
                            topicId = screen.topicId,
                            onBack  = { currentScreen = Screen.MindMapTopics("polity") }
                        )
                        is Screen.StudyPlanner -> StudyPlannerScreen(
                            hasTasks            = studyPlanBuilt,
                            onBack              = { currentScreen = Screen.Home },
                            onBuildPlan         = { currentScreen = Screen.BuildStudyPlan },
                            onStartFocusSession = { currentScreen = Screen.FocusSession }
                        )
                        is Screen.BuildStudyPlan -> BuildStudyPlanScreen(
                            onBack      = { currentScreen = Screen.StudyPlanner },
                            onTaskAdded = { studyPlanBuilt = true; currentScreen = Screen.StudyPlanner }
                        )
                        is Screen.FocusSession -> FocusSessionScreen(
                            onBack     = { currentScreen = Screen.StudyPlanner },
                            onComplete = { currentScreen = Screen.PlanComplete }
                        )
                        is Screen.PlanComplete -> PlanCompleteScreen(
                            onDashboard = { studyPlanBuilt = false; currentScreen = Screen.Home }
                        )
                        is Screen.DailyNews -> DailyNewsScreen(
                            onBack        = { currentScreen = Screen.Home },
                            onJeetAIClick = { currentScreen = Screen.JeetAILoading }
                        )
                        is Screen.JeetAILoading -> JeetAILoadingScreen(
                            onViewSummary = { currentScreen = Screen.JeetAISummary },
                            onBack        = { currentScreen = Screen.DailyNews }
                        )
                        is Screen.JeetAISummary -> JeetAISummaryScreen(
                            onBack        = { currentScreen = Screen.JeetAILoading },
                            onNewsFeed    = { currentScreen = Screen.DailyNews },
                            onNextArticle = { currentScreen = Screen.DailyNews }
                        )
                        is Screen.DailyMainsChallenge -> DailyMainsChallengeScreen(
                            onBack          = { currentScreen = Screen.Home },
                            onStartMockTest = { currentScreen = Screen.MockTestAnswer }
                        )
                        is Screen.MockTestAnswer -> MockTestAnswerScreen(
                            onBack   = { currentScreen = Screen.DailyMainsChallenge },
                            onSubmit = { currentScreen = Screen.EvaluationResult }
                        )
                        is Screen.EvaluationResult -> EvaluationScreen(
                            onBack        = { currentScreen = Screen.MockTestAnswer },
                            onViewMarkup  = { currentScreen = Screen.ExaminerMarkup },
                            onWhatNext    = { currentScreen = Screen.WhatNext }
                        )
                        is Screen.ExaminerMarkup -> ExaminerMarkupScreen(
                            onBack        = { currentScreen = Screen.EvaluationResult },
                            onTryAnother  = { currentScreen = Screen.MockTestAnswer },
                            onWhatNext    = { currentScreen = Screen.WhatNext }
                        )
                        is Screen.WhatNext -> WhatNextScreen(
                            onBack        = { currentScreen = Screen.EvaluationResult },
                            onTryAnother  = { currentScreen = Screen.MockTestAnswer },
                            onDashboard   = { currentScreen = Screen.Home }
                        )
                        is Screen.Prelims  -> MainsContentScreen(initialTab = 0)
                        is Screen.Mains    -> MainsContentScreen(initialTab = 1)
                        is Screen.Revision -> MainsContentScreen(initialTab = 2)
                        is Screen.News     -> CurrentAffairsScreen()
                        is Screen.Profile  -> ProfileScreen(
                            onEditProfile = { currentScreen = Screen.EditProfile },
                            onAccountSettings = { currentScreen = Screen.AccountSettings },
                            onLeaderboard = { currentScreen = Screen.Leaderboard },
                            onBookmarks = { currentScreen = Screen.Bookmarks },
                            onPremiumPlans = { currentScreen = Screen.PremiumPlans },
                            onRateUs = { currentScreen = Screen.RateUs },
                            onHelpSupport = { currentScreen = Screen.HelpSupport },
                            onSignOut = { currentScreen = Screen.Splash }
                        )
                        is Screen.RateUs -> RateUsScreen(
                            onBack = { currentScreen = Screen.Profile }
                        )
                        is Screen.HelpSupport -> HelpSupportScreen(
                            onBack = { currentScreen = Screen.Profile }
                        )
                        is Screen.EditProfile -> EditProfileScreen(
                            onBack = { currentScreen = Screen.Profile }
                        )
                        is Screen.AccountSettings -> AccountSettingsScreen(
                            onBack = { currentScreen = Screen.Profile }
                        )
                        is Screen.Leaderboard -> LeaderboardScreen(
                            onBack = { currentScreen = Screen.Profile }
                        )
                        is Screen.Bookmarks -> BookmarksScreen(
                            onBack = { currentScreen = Screen.Profile }
                        )
                        is Screen.PremiumPlans -> PremiumPlansScreen(
                            onBack = { currentScreen = Screen.Profile }
                        )
                        is Screen.DailyMCQSetup -> DailyMCQSetupScreen(
                            onBack           = { currentScreen = Screen.Home },
                            onStartChallenge = { currentScreen = Screen.DailyMCQChallenge },
                            onStartMockTest  = { currentScreen = Screen.DailyMCQChallenge }
                        )
                        is Screen.DailyMCQChallenge -> DailyMCQChallengeScreen(
                            onBack   = { currentScreen = Screen.DailyMCQSetup },
                            onSubmit = { currentScreen = Screen.DailyMCQResult }
                        )
                        is Screen.DailyMCQResult -> DailyMCQResultScreen(
                            onBack         = { currentScreen = Screen.DailyMCQChallenge },
                            onViewAnalysis = { currentScreen = Screen.DailyMCQReview },
                            onNextSteps    = { currentScreen = Screen.DailyMCQReview }
                        )
                        is Screen.DailyMCQReview -> DailyMCQReviewScreen(
                            onBack      = { currentScreen = Screen.DailyMCQResult },
                            onNextSteps = { currentScreen = Screen.DailyMCQNextSteps }
                        )
                        is Screen.DailyMCQNextSteps -> DailyMCQNextStepsScreen(
                            onBack = { currentScreen = Screen.DailyMCQReview },
                            onHome = { currentScreen = Screen.Home }
                        )
                        is Screen.PYQHome -> PYQHomeScreen(
                            onBack = { currentScreen = Screen.Home },
                            onStart = { currentScreen = Screen.PYQSubjectSelect }
                        )
                        is Screen.PYQSubjectSelect -> PYQSubjectSelectScreen(
                            onBack = { currentScreen = Screen.PYQHome },
                            onOpenSubject = { currentScreen = Screen.PYQSubjectTopics }
                        )
                        is Screen.PYQSubjectTopics -> PYQSubjectTopicsScreen(
                            onBack = { currentScreen = Screen.PYQSubjectSelect },
                            onStartQuestions = { currentScreen = Screen.PYQQuestion }
                        )
                        is Screen.PYQQuestion -> PYQQuestionScreen(
                            onBack = { currentScreen = Screen.PYQSubjectTopics },
                            onSubmit = { currentScreen = Screen.PYQSessionResult }
                        )
                        is Screen.PYQSessionResult -> PYQSessionResultScreen(
                            onBack = { currentScreen = Screen.PYQQuestion },
                            onReview = { currentScreen = Screen.PYQReview },
                            onMainsEval = { currentScreen = Screen.PYQMainsEval }
                        )
                        is Screen.PYQReview -> PYQReviewScreen(
                            onBack = { currentScreen = Screen.PYQSessionResult },
                            onAIScore = { currentScreen = Screen.PYQAIScore }
                        )
                        is Screen.PYQAIScore -> PYQAIScoreScreen(
                            onBack = { currentScreen = Screen.PYQReview },
                            onDone = { currentScreen = Screen.PYQWhatNext }
                        )
                        is Screen.PYQMainsEval -> PYQMainsEvalScreen(
                            onBack = { currentScreen = Screen.PYQSessionResult },
                            onWhatNext = { currentScreen = Screen.PYQWhatNext }
                        )
                        is Screen.PYQWhatNext -> PYQWhatNextScreen(
                            onBack = { currentScreen = Screen.PYQSessionResult },
                            onHome = { currentScreen = Screen.Home }
                        )
                        is Screen.PYQNew -> PYQNewHomeScreen(
                            onBack            = { currentScreen = Screen.Home },
                            onSubjectSelected = { id -> currentScreen = Screen.PYQNewSubTopics(id) }
                        )
                        is Screen.PYQNewSubTopics -> PYQNewSubTopicsScreen(
                            subjectId         = screen.subjectId,
                            onBack            = { currentScreen = Screen.PYQNew },
                            onSubTopicSelected = { id -> currentScreen = Screen.PYQNewTopicDetail(id) }
                        )
                        is Screen.PYQNewTopicDetail -> PYQNewTopicDetailScreen(
                            subTopicId        = screen.subTopicId,
                            onBack            = { currentScreen = Screen.PYQNewSubTopics("history") },
                            onTopicSelected   = { id -> currentScreen = Screen.PYQNewSetup(id) }
                        )
                        is Screen.PYQNewSetup -> PYQNewSetupScreen(
                            topicId           = screen.topicId,
                            onBack            = { currentScreen = Screen.PYQNewTopicDetail("ancient") },
                            onContinue        = { currentScreen = Screen.PYQNewReady }
                        )
                        is Screen.PYQNewReady -> PYQNewReadyScreen(
                            onBack            = { currentScreen = Screen.PYQNewSetup("indus") },
                            onStartChallenge  = { currentScreen = Screen.PYQQuestion }
                        )
                        is Screen.SubjectDetail -> SubjectDetailScreen(
                            subjectId = screen.subjectId,
                            onBack    = { currentScreen = Screen.Home },
                            onQuiz    = { currentScreen = Screen.SubjectQuiz(screen.subjectId) }
                        )
                        is Screen.SubjectQuiz -> QuizScreen(subjectFilter = screen.subjectId)
                        else -> Unit
                    }
                }
            }
        }
    }
}

@Composable
private fun RiseBottomNav(
    currentScreen: Screen,
    onNavigate: (Screen) -> Unit
) {
    val activeTab = when (currentScreen) {
        is Screen.Home     -> 0
        is Screen.Prelims  -> 1
        is Screen.Mains    -> 2
        is Screen.Revision -> 3
        is Screen.News     -> 4
        else               -> 0
    }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shadowElevation = 0.dp,
        color = DarkCard
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .height(64.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bottomNavItems.forEachIndexed { index, item ->
                val isActive = index == activeTab
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable { onNavigate(item.screen) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        item.emoji,
                        fontSize = 20.sp,
                        color = if (isActive) GoldAccent else Color.White.copy(0.45f)
                    )
                    Spacer(Modifier.height(2.dp))
                    Text(
                        item.label,
                        fontSize = 10.sp,
                        fontWeight = if (isActive) FontWeight.SemiBold else FontWeight.Normal,
                        color = if (isActive) GoldAccent else Color.White.copy(0.45f)
                    )
                    Spacer(Modifier.height(2.dp))
                    Box(
                        modifier = Modifier
                            .size(4.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(if (isActive) GoldAccent else Color.Transparent)
                    )
                }
            }
        }
    }
}
