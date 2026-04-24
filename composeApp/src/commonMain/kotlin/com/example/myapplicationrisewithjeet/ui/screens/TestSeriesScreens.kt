package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient

private val TsBg = Color(0xFFF0F2F7)
private val TsDark = Color(0xFF0A1733)
private val TsCard = Color(0xFFFFFFFF)
private val TsMuted = Color(0xFF7A8295)
private val TsBorder = Color(0xFFE3E7EF)
private val TsGreen = Color(0xFF31A35B)
private val TsRed = Color(0xFFE45555)
private val TsChip = Color(0xFFEEF2F9)

@Composable
fun TestSeriesCatalogScreen(
    onBack: () -> Unit = {},
    onOpenSeries: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F4FA)),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .background(Brush.verticalGradient(listOf(Color(0xFF0A1733), Color(0xFF132852))))
                    .padding(horizontal = 12.dp, vertical = 14.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "←",
                        modifier = Modifier.clickable { onBack() },
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 16.sp
                    )
                    Spacer(Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(18.dp))
                            .background(Color.White.copy(alpha = 0.12f))
                            .border(1.dp, Color.White.copy(alpha = 0.15f), RoundedCornerShape(18.dp))
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Text("🗓 This Week ▾", color = Color.White.copy(alpha = 0.88f), fontSize = 9.sp, fontWeight = FontWeight.SemiBold)
                    }
                }

                Spacer(Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clip(RoundedCornerShape(99.dp))
                        .background(Color(0x1AF3B33A))
                        .border(1.dp, Color(0x66F3B33A), RoundedCornerShape(99.dp))
                        .padding(horizontal = 9.dp, vertical = 4.dp)
                ) {
                    Text("🧾 TEST SERIES", color = Color(0xFFF3B33A), fontSize = 8.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(8.dp))
                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(color = Color.White)) { append("Choose Your ") }
                        withStyle(SpanStyle(color = Color(0xFFF3B33A))) { append("Battle Plan.") }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 33.sp,
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 36.sp
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    "From NCERT foundations to full Prelims war-room simulations —\neach series is crafted to mirror real UPSC patterns.",
                    color = Color(0xFF8F9BB5),
                    fontSize = 9.sp,
                    lineHeight = 13.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White.copy(alpha = 0.08f))
                        .border(1.dp, Color.White.copy(alpha = 0.09f), RoundedCornerShape(10.dp))
                        .padding(vertical = 8.dp)
                ) {
                    CatalogHeroMetric("847", "ACTIVE", Color(0xFFE2A22D), Modifier.weight(1f))
                    Box(modifier = Modifier.width(1.dp).height(24.dp).align(Alignment.CenterVertically).background(Color.White.copy(alpha = 0.12f)))
                    CatalogHeroMetric("1.2L+", "STUDENTS", Color(0xFF4A78FF), Modifier.weight(1f))
                    Box(modifier = Modifier.width(1.dp).height(24.dp).align(Alignment.CenterVertically).background(Color.White.copy(alpha = 0.12f)))
                    CatalogHeroMetric("42,980+", "TESTS TAKEN", Color(0xFFFFFFFF), Modifier.weight(1f))
                    Box(modifier = Modifier.width(1.dp).height(24.dp).align(Alignment.CenterVertically).background(Color.White.copy(alpha = 0.12f)))
                    CatalogHeroMetric("86%", "SUCCESS RATE", Color(0xFFE2A22D), Modifier.weight(1f))
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                    .background(Color(0xFFF0F4FA))
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CatalogFilterChip("All Series", selected = true, modifier = Modifier.weight(1f))
                        CatalogFilterChip("Prelims", "🎯", modifier = Modifier.weight(1f))
                        CatalogFilterChip("Mains", "✍️", modifier = Modifier.weight(1f))
                        CatalogFilterChip("Foundation", "🏁", modifier = Modifier.weight(1f))
                    }
                    Spacer(Modifier.height(6.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CatalogFilterChip("Curr. Affairs", "📰", modifier = Modifier.weight(1.35f))
                        CatalogFilterChip("PYQ", "📜", modifier = Modifier.weight(0.85f))
                        CatalogFilterChip("CSAT", "🧮", modifier = Modifier.weight(1f))
                        CatalogFilterChip("Free", "🎁", textColor = Color(0xFFC98B1B), modifier = Modifier.weight(0.85f))
                    }

                    Spacer(Modifier.height(12.dp))
                    SectionTitle("Your Enrolled Series", "View all ▸")
                    SeriesMiniCard(
                        title = "Prelims Assault 2026",
                        subtitleLeft = "8/20 tests done",
                        subtitleHighlight = "Resume Mock 9",
                        icon = "🎯",
                        progress = 0.40f
                    )
                    Spacer(Modifier.height(8.dp))
                    SeriesMiniCard(
                        title = "Current Affairs Radar",
                        subtitleLeft = "4/16 tests done",
                        subtitleHighlight = "CA Test 5 due today",
                        icon = "📅",
                        progress = 0.25f
                    )
                    Spacer(Modifier.height(14.dp))

                    SectionTitle("Explore All Programs", "10 series")
                    OfferCard(
                        title = "PYQ Decoder Pro",
                        subtitle = "11.3K  ·  11 TESTS  ·  3 months  ·  4.7",
                        description = "Deep-dive into Polity, Constitution, Amendments,\nActs. 500+ per test with video solutions.",
                        price = "₹999",
                        oldPrice = "₹1,299",
                        ctaPrimary = "Enroll ▸",
                        ctaSecondary = "Details",
                        onPrimary = onOpenSeries,
                        onSecondary = onOpenSeries
                    )
                    Spacer(Modifier.height(10.dp))
                    OfferCard(
                        title = "Zero to Hero Series",
                        subtitle = "22.4K  ·  30 TESTS  ·  6 Weeks  ·  4.6",
                        description = "20-question concept tests, no negative marking.\nPerfect Day 1 start. Fully free — no signup fees.",
                        price = "Free",
                        oldPrice = null,
                        ctaPrimary = "Start Free ▸",
                        ctaSecondary = "",
                        onPrimary = onOpenSeries,
                        onSecondary = {}
                    )
                    Spacer(Modifier.height(10.dp))
                    OfferCard(
                        title = "CSAT Crack Code",
                        subtitle = "18.4K  ·  25 TESTS  ·  2 Weeks  ·  4.7",
                        description = "Comprehension, Maths, Reasoning & DI. CSAT full\nmock with speed-building drills.",
                        price = "₹799",
                        oldPrice = "₹1,299",
                        ctaPrimary = "Enroll ▸",
                        ctaSecondary = "Details",
                        onPrimary = onOpenSeries,
                        onSecondary = onOpenSeries
                    )
                    Spacer(Modifier.height(10.dp))
                    OfferCard(
                        title = "Current Affairs Radar",
                        subtitle = "18.2K  ·  16 TESTS  ·  Ongoing  ·  4.8",
                        description = "Weekly CA paper drills with evolving trends.",
                        price = "₹1,199",
                        oldPrice = "₹1,999",
                        ctaPrimary = "Enroll ▸",
                        ctaSecondary = "Details",
                        onPrimary = onOpenSeries,
                        onSecondary = onOpenSeries
                    )
                }
            }
        }
    }
}

@Composable
fun TestSeriesDetailScreen(
    onBack: () -> Unit = {},
    onEnrollNow: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F4FA)),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .background(Brush.verticalGradient(listOf(Color(0xFF0B1938), Color(0xFF152953))))
                    .padding(horizontal = 14.dp, vertical = 14.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("←", color = Color.White.copy(alpha = 0.85f), fontSize = 15.sp, modifier = Modifier.clickable { onBack() })
                    Spacer(Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color.White.copy(alpha = 0.12f))
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                        Text("📅 This Week ▾", color = Color.White.copy(alpha = 0.9f), fontSize = 9.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
                Spacer(Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(99.dp))
                        .background(Color(0x1AF3B33A))
                        .border(1.dp, Color(0x66F3B33A), RoundedCornerShape(99.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text("🧾 FULL MOCKS", color = Color(0xFFF3B33A), fontSize = 8.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(8.dp))
                Text("PrelimsBlitz2026", color = Color.White, fontSize = 23.sp, fontWeight = FontWeight.ExtraBold, lineHeight = 25.sp)
                Text("Train like it's exam day — every single test mirrors the real UPSC pattern.", color = Color.White.copy(0.62f), fontSize = 10.sp, lineHeight = 14.sp)
                Spacer(Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White.copy(alpha = 0.09f))
                        .border(1.dp, Color.White.copy(alpha = 0.10f), RoundedCornerShape(12.dp))
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CatalogHeroMetric("20", "MOCK TESTS", Color.White, Modifier.weight(1f))
                    Box(modifier = Modifier.width(1.dp).height(24.dp).background(Color.White.copy(alpha = 0.13f)))
                    CatalogHeroMetric("2Mo.", "DURATION", Color.White, Modifier.weight(1f))
                    Box(modifier = Modifier.width(1.dp).height(24.dp).background(Color.White.copy(alpha = 0.13f)))
                    CatalogHeroMetric("14,320", "ENROLLED", Color.White, Modifier.weight(1f))
                    Box(modifier = Modifier.width(1.dp).height(24.dp).background(Color.White.copy(alpha = 0.13f)))
                    CatalogHeroMetric("4.9", "RATING", Color(0xFFF3B33A), Modifier.weight(1f))
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                    .background(Color(0xFFF0F4FA))
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .border(1.dp, Color(0xFFE1E7F1), RoundedCornerShape(16.dp))
                            .padding(12.dp)
                    ) {
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            DetailMiniStat("20", "MOCK TESTS", Modifier.weight(1f))
                            DetailMiniStat("2Mo.", "DURATION", Modifier.weight(1f))
                        }
                        Spacer(Modifier.height(8.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            DetailMiniStat("14,320", "ENROLLED", Modifier.weight(1f))
                            DetailMiniStat("4.9", "RATING", Modifier.weight(1f), valueColor = Color(0xFFE2A22D))
                        }
                        Spacer(Modifier.height(10.dp))

                        Row(verticalAlignment = Alignment.Bottom) {
                            Text("₹799", color = TsDark, fontWeight = FontWeight.ExtraBold, fontSize = 28.sp)
                            Spacer(Modifier.width(6.dp))
                            Text("₹1,499", color = Color(0xFFA7B3C8), fontSize = 11.sp, textDecoration = TextDecoration.LineThrough)
                            Spacer(Modifier.width(6.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color(0xFFEAF8EC))
                                    .padding(horizontal = 7.dp, vertical = 3.dp)
                            ) {
                                Text("🔥 Save ₹700 · 47% OFF", color = Color(0xFF3BA565), fontSize = 8.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                        Spacer(Modifier.height(10.dp))
                        PrimaryButton("Enroll Now ▸", onEnrollNow)
                        Spacer(Modifier.height(10.dp))

                        Text("This enrollment includes:", color = Color(0xFF5C6781), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        DetailBullet("60 full-access tests")
                        DetailBullet("Detailed analytics after each test")
                        DetailBullet("National leaderboard rank certificate")
                        DetailBullet("Write + mobile access. Lifetime management")
                    }

                    Spacer(Modifier.height(10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .border(1.dp, Color(0xFFE1E7F1), RoundedCornerShape(16.dp))
                            .padding(12.dp)
                    ) {
                        Text("Why enroll in PrelimsBlitz 2026?", color = TsDark, fontSize = 12.sp, fontWeight = FontWeight.ExtraBold)
                        Spacer(Modifier.height(8.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            DetailFeatureCard("🎯", "Purpose-built tests", "20 full + sectionals", Modifier.weight(1f))
                            DetailFeatureCard("📊", "Deep analytics", "AI insights", Modifier.weight(1f))
                        }
                        Spacer(Modifier.height(8.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            DetailFeatureCard("🏆", "Rank & Benchmarking", "Performance vs top rankers", Modifier.weight(1f))
                            DetailFeatureCard("🧠", "Expert insights", "Detailed subject-wise score breakdown", Modifier.weight(1f))
                        }
                        Spacer(Modifier.height(8.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            DetailFeatureCard("🎥", "Video solutions", "Explanation for every paper", Modifier.weight(1f))
                            DetailFeatureCard("📄", "Pdf AI Report", "Complete post-test intelligence", Modifier.weight(1f))
                        }
                        Spacer(Modifier.height(8.dp))
                        Text("✨ What you will achieve", color = Color(0xFF5C6781), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(4.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            DetailFeatureCard("✅", "Build exam-day confidence thru repeated practice", "", Modifier.weight(1f), compact = true)
                            DetailFeatureCard("✅", "Know exact weak areas with subject analytics", "", Modifier.weight(1f), compact = true)
                        }
                        Spacer(Modifier.height(6.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            DetailFeatureCard("✅", "Best test-topper strategy with scorecard", "", Modifier.weight(1f), compact = true)
                            DetailFeatureCard("✅", "Earn rank certificates to share on LinkedIn", "", Modifier.weight(1f), compact = true)
                        }
                    }

                    Spacer(Modifier.height(10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .border(1.dp, Color(0xFFE1E7F1), RoundedCornerShape(16.dp))
                            .padding(12.dp)
                    ) {
                        Text("Student Reviews", color = TsDark, fontSize = 12.sp, fontWeight = FontWeight.ExtraBold)
                        Spacer(Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("4.9", color = TsDark, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
                            Spacer(Modifier.width(6.dp))
                            Column {
                                Text("⭐⭐⭐⭐⭐", fontSize = 10.sp)
                                Text("1,450 reviews", color = Color(0xFF95A3BA), fontSize = 8.sp)
                            }
                            Spacer(Modifier.weight(1f))
                            Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                                ReviewBar("5★", 0.72f)
                                ReviewBar("4★", 0.18f)
                                ReviewBar("3★", 0.06f)
                                ReviewBar("2★", 0.03f)
                                ReviewBar("1★", 0.01f)
                            }
                        }
                    }

                    Spacer(Modifier.height(10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .border(1.dp, Color(0xFFE1E7F1), RoundedCornerShape(16.dp))
                            .padding(12.dp)
                    ) {
                        Text("Frequently Asked Questions", color = TsDark, fontSize = 12.sp, fontWeight = FontWeight.ExtraBold)
                        Faq("What is PrelimsBlitz and how does it help?")
                        Faq("Are UPSC PYQ included?")
                        Faq("What sources do the questions cover?")
                        Faq("Is PrelimsBlitz available in Hindi?")
                    }
                }
            }
        }

        item {
            Box(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(GoldGradient)
                    .clickable { onEnrollNow() },
                contentAlignment = Alignment.Center
            ) {
                Text("Enroll Now — ₹799 Only ▸", fontWeight = FontWeight.Bold, color = Color(0xFF1E1E1E), fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun TestSeriesCheckoutScreen(
    onBack: () -> Unit = {},
    onPayNow: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF0B1938), Color(0xFF13264B))))
            .statusBarsPadding()
            .padding(12.dp)
    ) {
        TopBarTitle("Secure Checkout", onBack, subtitle = "Complete your enrollment")
        Spacer(Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(TsCard)
                .border(1.dp, Color(0xFFE8D6A8), RoundedCornerShape(16.dp))
                .padding(12.dp)
        ) {
            Text("PrelimsBlitz 2026", fontWeight = FontWeight.SemiBold, color = TsDark)
            Text("Full Mock Series · 20 tests · 2 months", fontSize = 11.sp, color = TsMuted)
            Spacer(Modifier.height(10.dp))
            PriceLine("Original Price", "₹1,499")
            PriceLine("Discount (Early Bird)", "-₹700", valueColor = TsGreen)
            PriceLine("GST", "₹143")
            Spacer(Modifier.height(8.dp))
            PriceLine("Total Payable", "₹942", valueColor = TsDark, bold = true)
            Spacer(Modifier.height(8.dp))
            Pill("You save ₹700 (47% OFF applied)", Color(0xFFEAF8EC), TsGreen)
        }

        Spacer(Modifier.height(10.dp))
        InputRow("COUPON CODE", "Enter code (optional)", "Apply")
        Spacer(Modifier.height(10.dp))

        Text("Payment Method", color = Color.White, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(8.dp))
        PayOption("UPI Payment", "GPay · PhonePe · BHIM · Paytm", selected = true)
        Spacer(Modifier.height(8.dp))
        InputRow("ENTER UPI ID", "rahul@okicici", "Verify")
        Spacer(Modifier.height(8.dp))
        PayOption("Credit / Debit Card", "Visa · Mastercard · Rupay")
        Spacer(Modifier.height(8.dp))
        PayOption("Net Banking", "All major banks supported")
        Spacer(Modifier.height(8.dp))
        PayOption("Wallet", "Paytm / Amazon")

        Spacer(Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(GoldGradient)
                .clickable { onPayNow() },
            contentAlignment = Alignment.Center
        ) {
            Text("Pay ₹943 & Enroll Now", fontWeight = FontWeight.Bold, color = Color(0xFF1E1E1E))
        }
    }
}

@Composable
fun TestSeriesDashboardScreen(
    onBack: () -> Unit = {},
    onStartTest: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(TsBg)
            .statusBarsPadding(),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Brush.verticalGradient(listOf(Color(0xFF0B1938), Color(0xFF142951))))
                    .padding(16.dp)
            ) {
                Text("04  •  MY TESTS DASHBOARD", color = Color.White.copy(0.58f), fontSize = 10.sp)
                Spacer(Modifier.height(8.dp))
                TopBarTitle("PrelimsBlitz2026", onBack, textColor = Color.White, subtitle = "Full Mock Prelims Series · 20 tests")
                Spacer(Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    HeroMetric("8/20", "COMPLETED", Modifier.weight(1f))
                    HeroMetric("83.5%", "AVG ACCURACY", Modifier.weight(1f))
                    HeroMetric("#1,274", "BEST RANK", Modifier.weight(1f))
                }
                Spacer(Modifier.height(10.dp))
                Text("OVERALL PROGRESS", fontSize = 10.sp, color = Color.White.copy(0.7f))
                LinearProgressIndicator(progress = { 0.4f }, modifier = Modifier.fillMaxWidth(), color = Color(0xFFF3B33A), trackColor = Color.White.copy(0.2f))
            }
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .background(TsBg)
                    .padding(12.dp)
            ) {
                HorizontalTags(listOf("All Tests", "Pending", "Completed", "Analytics"))
                Spacer(Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(TsCard)
                        .border(1.dp, Color(0xFFE5C26A), RoundedCornerShape(14.dp))
                        .padding(12.dp)
                ) {
                    Text("Mock Test 9 — Full Prelims", color = TsDark, fontWeight = FontWeight.SemiBold)
                    Text("100 Questions · 2 hours · GS Paper I", fontSize = 11.sp, color = TsMuted)
                    Spacer(Modifier.height(10.dp))
                    PrimaryButton("Start Test", onStartTest)
                }

                Spacer(Modifier.height(10.dp))
                Text("Completed Tests", fontWeight = FontWeight.SemiBold, color = TsDark)
                CompletedItem("Mock Test 7 — Environment Focus", "123/200", "7 days ago")
                CompletedItem("Mock Test 6 — Economy & Geo", "88/200", "14 days ago")
                CompletedItem("Mock Test 5 — Economy & Geo", "88/200", "14 days ago")

                Spacer(Modifier.height(10.dp))
                Text("Upcoming Tests", fontWeight = FontWeight.SemiBold, color = TsDark)
                LockedItem("Mock Test 10", "Unlocks after completing Test 9")
                LockedItem("Mock Test 11", "Unlocks after completing Test 10")
            }
        }
    }
}

@Composable
fun TestSeriesReadyScreen(
    onBack: () -> Unit = {},
    onStartChallenge: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(TsBg)
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.verticalGradient(listOf(Color(0xFF0B1938), Color(0xFF11254A))))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("05  •  TEST READY", color = Color.White.copy(0.6f), fontSize = 10.sp)
            Spacer(Modifier.height(8.dp))
            TopBarTitle("PrelimsBlitz2026", onBack, textColor = Color.White, subtitle = "Full Mock Prelims Series · 20 tests")
        }

        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(TsCard)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Mock Test 9 — Full Prelims GS Paper I", fontSize = 11.sp, color = Color(0xFFB68B2B), fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(8.dp))
            Text("Are You Ready?", color = TsDark, fontWeight = FontWeight.Bold, fontSize = 28.sp)
            Text("10 questions · Indus Valley Civilization · 12 minutes", color = TsMuted, fontSize = 11.sp, textAlign = TextAlign.Center)
            Spacer(Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                HeroMetric("10", "QUESTIONS", Modifier.weight(1f))
                HeroMetric("12", "MINUTES", Modifier.weight(1f))
                HeroMetric("847", "ATTEMPTED", Modifier.weight(1f))
            }
            Spacer(Modifier.height(14.dp))
            PrimaryButton("Start Challenge", onStartChallenge)
        }
    }
}

@Composable
fun TestSeriesQuestionScreen(
    onBack: () -> Unit = {},
    onSubmit: () -> Unit = {}
) {
    var selected by remember { mutableStateOf("D") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(TsBg)
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("←", modifier = Modifier.clickable { onBack() }, color = TsMuted)
            Spacer(Modifier.weight(1f))
            Text("Question 1 / 10", fontWeight = FontWeight.SemiBold, color = TsDark)
            Spacer(Modifier.weight(1f))
            Pill("9:11", TsChip, TsDark)
        }
        HorizontalTags(listOf("1", "2", "3", "4", "5", "6", "7", "8"))
        Spacer(Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(TsCard)
                .padding(12.dp)
        ) {
            Pill("Question 1", Color(0xFFEFF3FA), TsDark)
            Spacer(Modifier.height(8.dp))
            Text(
                "With reference to the Doctrine of Basic Structure in the Indian Constitution, which statement is/are correct?",
                color = TsDark,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(Modifier.height(10.dp))

            McqOption("A", "It was first propounded in Golaknath case (1967)", selected == "A") { selected = "A" }
            McqOption("B", "Parliament cannot amend the basic features", selected == "B") { selected = "B" }
            McqOption("C", "It was established in Kesavananda Bharati case (1973)", selected == "C") { selected = "C" }
            McqOption("D", "Both B and C are correct", selected == "D", correct = true) { selected = "D" }
        }

        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            GhostButton("Prev", Modifier.weight(1f)) {}
            DarkButton("Next", Modifier.weight(1f)) {}
        }
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            GhostButton("Prev", Modifier.weight(1f)) {}
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(46.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(GoldGradient)
                    .clickable { onSubmit() },
                contentAlignment = Alignment.Center
            ) {
                Text("Submit Test", color = Color(0xFF1E1E1E), fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun TestSeriesResultScreen(
    onBack: () -> Unit = {},
    onViewFullAnalysis: () -> Unit = {},
    onAiReport: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF0A1734), Color(0xFF11264A))))
            .statusBarsPadding(),
        contentPadding = PaddingValues(12.dp)
    ) {
        item {
            TopBarTitle("Keep Going", onBack, textColor = Color.White, subtitle = "Every attempt makes you better")
            Spacer(Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                HeroMetric("12", "CORRECT", Modifier.weight(1f))
                HeroMetric("5", "WRONG", Modifier.weight(1f))
                HeroMetric("8", "SKIPPED", Modifier.weight(1f))
                HeroMetric("71%", "ACCURACY", Modifier.weight(1f))
            }
            Spacer(Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                GhostButton("Reattempt", Modifier.weight(1f)) {}
                GhostButton("Full Analysis", Modifier.weight(1f), onClick = onViewFullAnalysis)
                GhostButton("PDF", Modifier.weight(1f)) {}
            }
            Spacer(Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.White)
                    .padding(12.dp)
            ) {
                Text("Answer Review", color = TsDark, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(8.dp))
                ReviewRow("Which of the following statements about the Preamble is/are correct?", "Your answer: A", "Correct answer: C (1,2,3)")
                Spacer(Modifier.height(8.dp))
                ReviewRow("Consider the following pairs — Article: Subject", "Skipped", "Time spent: 75s")
                Spacer(Modifier.height(8.dp))
                ReviewRow("The Basic Structure doctrine was propounded in which landmark case?", "Skipped", "Time spent: 60s")
            }
            Spacer(Modifier.height(12.dp))
            DarkButton("View Full Analysis Report", Modifier.fillMaxWidth(), onViewFullAnalysis)
            Spacer(Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(GoldGradient)
                    .clickable { onAiReport() },
                contentAlignment = Alignment.Center
            ) {
                Text("Get Jeet AI Intelligence Report", color = Color(0xFF1E1E1E), fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun TestSeriesReportScreen(
    onBack: () -> Unit = {},
    onAiReport: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(TsBg)
            .statusBarsPadding(),
        contentPadding = PaddingValues(12.dp)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Brush.verticalGradient(listOf(Color(0xFF0B1938), Color(0xFF142951))))
                    .clip(RoundedCornerShape(16.dp))
                    .padding(12.dp)
            ) {
                TopBarTitle("Mock Test 9 · Full Prelims", onBack, textColor = Color.White, subtitle = "GS Paper I detailed report")
                Spacer(Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    HeroMetric("79", "RANK", Modifier.weight(1f))
                    HeroMetric("46", "CORRECT", Modifier.weight(1f))
                    HeroMetric("17", "WRONG", Modifier.weight(1f))
                    HeroMetric("26", "SKIPPED", Modifier.weight(1f))
                }
            }
            Spacer(Modifier.height(10.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OfferStat("87.5", "Score")
                OfferStat("83.5%", "Accuracy")
            }
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OfferStat("#1,274", "Best Rank")
                OfferStat("1m 29s", "Avg Time")
            }

            Spacer(Modifier.height(10.dp))
            ReportSection("Score Breakdown") {
                ReportBar("Correct", 0.63f, Color(0xFF3FA96F), "+92")
                ReportBar("Wrong", 0.22f, Color(0xFFE45C5C), "-20")
                ReportBar("Skipped", 0.15f, Color(0xFF93A1BA), "0")
            }
            ReportSection("Accuracy by Topic") {
                ReportBar("Modern History", 0.86f, Color(0xFF3FA96F), "86%")
                ReportBar("Polity", 0.78f, Color(0xFFE0A13A), "78%")
                ReportBar("Economy", 0.70f, Color(0xFFE0A13A), "70%")
                ReportBar("Science", 0.60f, Color(0xFFE45C5C), "60%")
            }
            Spacer(Modifier.height(10.dp))
            DarkButton("Get Jeet AI Intelligence Report", Modifier.fillMaxWidth(), onAiReport)
        }
    }
}

@Composable
fun TestSeriesIntelligenceScreen(
    onBack: () -> Unit = {},
    onHistory: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(TsBg)
            .statusBarsPadding(),
        contentPadding = PaddingValues(12.dp)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Brush.verticalGradient(listOf(Color(0xFF0C1A39), Color(0xFF15305A))))
                    .clip(RoundedCornerShape(16.dp))
                    .padding(12.dp)
            ) {
                TopBarTitle("Jeet AI Post-Test Intelligence", onBack, textColor = Color.White, subtitle = "Comparative insights + personalized report")
            }
            Spacer(Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                InsightCard("Fix these first", "Economy +28% potential gain with 30-minute revision.")
                InsightCard("What went well", "Strong performance in Polity constitutional modules.")
            }
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                InsightCard("Dyslexia concept", "Try 6/7 current-affairs stems in 15 mins.")
                InsightCard("Speed management", "Spend less than 90 sec on trap-heavy stems.")
            }
            Spacer(Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(TsCard)
                    .border(1.dp, TsBorder, RoundedCornerShape(14.dp))
                    .padding(12.dp)
            ) {
                Text("Complete Test History", color = TsDark, fontWeight = FontWeight.SemiBold)
                HistoryRow("Prelims Mock Test 8", "94/200")
                HistoryRow("Current Affairs Test 4", "43/60")
                HistoryRow("Prelims Mock Test 7", "88/200")
                HistoryRow("Current Affairs Test 3", "43/60")
            }
            Spacer(Modifier.height(10.dp))
            DarkButton("History Pack #6", Modifier.fillMaxWidth(), onHistory)
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                NextStepCard("Study weak topics")
                NextStepCard("Next full mock test")
                NextStepCard("Retake skipped")
            }
        }
    }
}

@Composable
private fun TopBarTitle(
    title: String,
    onBack: () -> Unit,
    textColor: Color = Color.White,
    subtitle: String? = null
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            "←",
            modifier = Modifier
                .clickable { onBack() }
                .padding(end = 10.dp),
            color = textColor.copy(alpha = 0.85f),
            fontSize = 16.sp
        )
        Column {
            Text(title, color = textColor, fontWeight = FontWeight.Bold, fontSize = 27.sp, lineHeight = 30.sp)
            if (subtitle != null) {
                Text(subtitle, color = textColor.copy(alpha = 0.6f), fontSize = 11.sp)
            }
        }
    }
}

@Composable
private fun HeroMetric(value: String, label: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White.copy(alpha = 0.08f))
            .padding(vertical = 8.dp, horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(value, color = Color(0xFFF3B33A), fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text(label, color = Color.White.copy(0.72f), fontSize = 9.sp)
    }
}

@Composable
private fun CatalogHeroMetric(value: String, label: String, valueColor: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(value, color = valueColor, fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
        Text(label, color = Color.White.copy(alpha = 0.58f), fontSize = 8.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun CatalogFilterChip(
    text: String,
    icon: String? = null,
    selected: Boolean = false,
    textColor: Color = Color(0xFF6A7691),
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(if (selected) Color(0xFF111F3E) else Color.White)
            .border(1.dp, if (selected) Color(0xFF111F3E) else Color(0xFFD8E0ED), RoundedCornerShape(16.dp))
            .padding(horizontal = 9.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        if (icon != null) {
            Text(icon, fontSize = 10.sp)
            Spacer(Modifier.width(3.dp))
        }
        Text(
            text,
            color = if (selected) Color.White else textColor,
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun HorizontalTags(tags: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        tags.forEachIndexed { index, tag ->
            Pill(
                text = tag,
                bg = if (index == 0) Color(0xFF111E3C) else Color.White,
                fg = if (index == 0) Color.White else Color(0xFF66708A)
            )
        }
    }
}

@Composable
private fun Pill(text: String, bg: Color, fg: Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(bg)
            .padding(horizontal = 12.dp, vertical = 7.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = fg, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun SectionTitle(title: String, action: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(title.uppercase(), color = Color(0xFF7A8398), fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
        Text(action, color = Color(0xFFD19A2A), fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
    }
    Spacer(Modifier.height(8.dp))
}

@Composable
private fun SeriesMiniCard(
    title: String,
    subtitleLeft: String,
    subtitleHighlight: String,
    icon: String,
    progress: Float
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF1B2847))
            .border(1.dp, Color(0xFF2D3A59), RoundedCornerShape(20.dp))
            .padding(horizontal = 14.dp, vertical = 12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White.copy(alpha = 0.08f)),
                contentAlignment = Alignment.Center
            ) {
                Text(icon, fontSize = 20.sp)
            }
            Spacer(Modifier.width(10.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 12.5.sp)
                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(color = Color(0xFFB8C2D8))) { append(subtitleLeft) }
                        append(" · ")
                        withStyle(SpanStyle(color = Color(0xFFF3B33A))) { append(subtitleHighlight) }
                    },
                    fontSize = 10.sp,
                    lineHeight = 14.sp
                )
            }
            Text("›", color = Color(0xFF97A4C0), fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(7.dp)
                .clip(RoundedCornerShape(99.dp))
                .background(Color(0xFF4A5878))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progress.coerceIn(0f, 1f))
                    .fillMaxSize()
                    .clip(RoundedCornerShape(99.dp))
                    .background(Color(0xFFF3B33A))
            )
        }
    }
}

@Composable
private fun OfferCard(
    title: String,
    subtitle: String,
    description: String,
    price: String,
    oldPrice: String?,
    ctaPrimary: String,
    ctaSecondary: String,
    onPrimary: () -> Unit,
    onSecondary: () -> Unit
) {
    val cardBackground = if (title.contains("Zero")) Color(0xFFEDF9F3) else TsCard
    val cardBorder = if (title.contains("Zero")) Color(0xFFB2EDD0) else TsBorder

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(cardBackground)
            .border(1.dp, cardBorder, RoundedCornerShape(14.dp))
            .padding(horizontal = 14.dp, vertical = 14.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(9.dp))
                    .background(
                        when {
                            title.contains("PYQ") -> Color(0xFFF2F1EE)
                            title.contains("Zero") -> Color(0xFFEAF9EE)
                            title.contains("CSAT") -> Color(0xFFEFF2FB)
                            else -> Color(0xFFF9EFEF)
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    when {
                        title.contains("PYQ") -> "📘"
                        title.contains("Zero") -> "🛡️"
                        title.contains("CSAT") -> "🧠"
                        else -> "📰"
                    },
                    fontSize = 13.sp
                )
            }
            Spacer(Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = TsDark, fontWeight = FontWeight.Bold, fontSize = 14.5.sp)
                Text(subtitle, color = TsMuted, fontSize = 10.sp, lineHeight = 14.sp)
            }
            Text(
                when {
                    title.contains("Zero") -> "FREE"
                    title.contains("Current") -> "🔴 LIVE"
                    else -> "OPEN"
                },
                color = when {
                    title.contains("Zero") -> Color(0xFF36A56D)
                    title.contains("Current") -> Color(0xFFDA5A5A)
                    else -> Color(0xFF36A56D)
                },
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(description, color = Color(0xFF556079), fontSize = 11.sp, lineHeight = 16.sp)
        Spacer(Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                Text(price, color = TsDark, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
                if (oldPrice != null) {
                    Spacer(Modifier.width(6.dp))
                    Text(oldPrice, color = TsMuted, fontSize = 10.sp, textDecoration = TextDecoration.LineThrough)
                    Spacer(Modifier.width(4.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFFFECEC))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            if (title.contains("Current")) "-40%" else "-23%",
                            color = Color(0xFFDA5A5A),
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            if (ctaSecondary.isNotBlank()) {
                GhostButton(ctaSecondary, Modifier.width(76.dp).height(36.dp), onSecondary)
                Spacer(Modifier.width(8.dp))
            }
            Box(
                modifier = Modifier
                    .width(if (ctaSecondary.isBlank()) 112.dp else 86.dp)
                    .height(36.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (title.contains("Zero")) Color(0xFF4BB06E) else TsDark)
                    .clickable { onPrimary() },
                contentAlignment = Alignment.Center
            ) {
                Text(ctaPrimary, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 10.5.sp)
            }
        }
    }
}

@Composable
private fun PriceStrip(price: String, oldPrice: String, tag: String) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(price, fontWeight = FontWeight.Bold, fontSize = 28.sp, color = TsDark)
        Spacer(Modifier.width(8.dp))
        Text(oldPrice, fontSize = 13.sp, color = TsMuted)
        Spacer(Modifier.weight(1f))
        Pill(tag, Color(0xFFEAF8EC), TsGreen)
    }
}

@Composable
private fun InfoLine(text: String) {
    Text("• $text", color = Color(0xFF4B566D), fontSize = 11.sp, modifier = Modifier.padding(top = 4.dp))
}

@Composable
private fun RowScope.WhyCard(title: String, subtitle: String) {
    Column(
        modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF6F8FC))
            .padding(10.dp)
    ) {
        Text(title, color = TsDark, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
        Text(subtitle, color = TsMuted, fontSize = 10.sp)
    }
}

@Composable
private fun Faq(question: String) {
    Row(
        modifier = Modifier
            .padding(top = 6.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF6F8FC))
            .padding(horizontal = 10.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(question, color = TsDark, fontSize = 11.sp)
        Text("+", color = TsMuted)
    }
}

@Composable
private fun RowScope.DetailMiniStat(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    valueColor: Color = TsDark
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF7F9FD))
            .border(1.dp, Color(0xFFE2E8F2), RoundedCornerShape(10.dp))
            .padding(horizontal = 8.dp, vertical = 10.dp)
    ) {
        Text(value, color = valueColor, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
        Text(label, color = Color(0xFFA0AEC4), fontSize = 8.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun DetailBullet(text: String) {
    Text("• $text", color = Color(0xFF7A859B), fontSize = 8.8.sp, modifier = Modifier.padding(top = 4.dp))
}

@Composable
private fun RowScope.DetailFeatureCard(
    icon: String,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    compact: Boolean = false
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(if (compact) Color(0xFFF8FAFD) else Color(0xFFF7F9FD))
            .border(1.dp, Color(0xFFE2E8F2), RoundedCornerShape(10.dp))
            .padding(horizontal = 8.dp, vertical = if (compact) 7.dp else 9.dp)
    ) {
        Text("$icon $title", color = TsDark, fontSize = if (compact) 8.sp else 8.8.sp, fontWeight = FontWeight.Bold, lineHeight = 11.sp)
        if (subtitle.isNotBlank()) {
            Spacer(Modifier.height(2.dp))
            Text(subtitle, color = Color(0xFF8A97AF), fontSize = 7.5.sp, lineHeight = 10.sp)
        }
    }
}

@Composable
private fun ReviewBar(label: String, progress: Float) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(label, color = Color(0xFF8E9AB0), fontSize = 7.sp, modifier = Modifier.width(16.dp))
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.width(70.dp).height(4.dp),
            color = Color(0xFFE2A22D),
            trackColor = Color(0xFFE8EEF7)
        )
    }
}

@Composable
private fun PrimaryButton(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(46.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(GoldGradient)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = Color(0xFF1E1E1E), fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun InputRow(label: String, placeholder: String, action: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(label, color = TsMuted, fontSize = 9.sp)
            Text(placeholder, color = TsDark, fontSize = 12.sp)
        }
        DarkButton(action, Modifier.width(74.dp).height(34.dp)) {}
    }
}

@Composable
private fun PayOption(title: String, subtitle: String, selected: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = TsDark, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
            Text(subtitle, color = TsMuted, fontSize = 10.sp)
        }
        Box(
            modifier = Modifier
                .size(18.dp)
                .clip(CircleShape)
                .background(if (selected) Color(0xFFF2B73B) else Color(0xFFE1E6F0))
        )
    }
}

@Composable
private fun PriceLine(label: String, value: String, valueColor: Color = TsMuted, bold: Boolean = false) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, color = TsMuted, fontSize = 12.sp)
        Text(value, color = valueColor, fontSize = if (bold) 25.sp else 12.sp, fontWeight = if (bold) FontWeight.Bold else FontWeight.SemiBold)
    }
}

@Composable
private fun CompletedItem(title: String, score: String, time: String) {
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("✅", fontSize = 12.sp)
        Spacer(Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = TsDark, fontWeight = FontWeight.Medium, fontSize = 12.sp)
            Text(time, color = TsMuted, fontSize = 10.sp)
        }
        Text(score, color = TsGreen, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun LockedItem(title: String, subtitle: String) {
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFECEFF5))
            .padding(12.dp)
    ) {
        Text("🔒 $title", color = Color(0xFF8991A3), fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
        Text(subtitle, color = Color(0xFFA5ACBC), fontSize = 10.sp)
    }
}

@Composable
private fun McqOption(
    id: String,
    text: String,
    selected: Boolean,
    correct: Boolean = false,
    onClick: () -> Unit
) {
    val bg = when {
        correct -> Color(0xFFE9F7EB)
        selected -> Color(0xFFF5F6FA)
        else -> Color.White
    }
    val border = when {
        correct -> Color(0xFF82C58B)
        selected -> Color(0xFFCFD7E7)
        else -> Color(0xFFDDE3EF)
    }
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(bg)
            .border(1.dp, border, RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(if (correct) Color(0xFF4BAA62) else Color(0xFFF1F3F9)),
            contentAlignment = Alignment.Center
        ) {
            Text(id, color = if (correct) Color.White else TsMuted, fontWeight = FontWeight.Bold, fontSize = 11.sp)
        }
        Spacer(Modifier.width(8.dp))
        Text(text, color = TsDark, fontSize = 11.sp)
    }
}

@Composable
private fun GhostButton(text: String, modifier: Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF1F4FA))
            .border(1.dp, Color(0xFFDCE2EE), RoundedCornerShape(12.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = TsDark, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
    }
}

@Composable
private fun DarkButton(text: String, modifier: Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(TsDark)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
    }
}

@Composable
private fun RowScope.OfferStat(value: String, label: String) {
    Column(
        modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .border(1.dp, TsBorder, RoundedCornerShape(12.dp))
            .padding(10.dp)
    ) {
        Text(value, color = TsDark, fontSize = 19.sp, fontWeight = FontWeight.Bold)
        Text(label, color = TsMuted, fontSize = 10.sp)
    }
}

@Composable
private fun ReportSection(title: String, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .border(1.dp, TsBorder, RoundedCornerShape(12.dp))
            .padding(10.dp)
    ) {
        Text(title, color = TsDark, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
        Spacer(Modifier.height(8.dp))
        content()
    }
    Spacer(Modifier.height(8.dp))
}

@Composable
private fun ReportBar(title: String, progress: Float, color: Color, value: String) {
    Text(title, color = TsMuted, fontSize = 10.sp)
    Row(verticalAlignment = Alignment.CenterVertically) {
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.weight(1f),
            color = color,
            trackColor = TsChip
        )
        Spacer(Modifier.width(8.dp))
        Text(value, color = color, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
    }
    Spacer(Modifier.height(6.dp))
}

@Composable
private fun RowScope.InsightCard(title: String, text: String) {
    Column(
        modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .border(1.dp, TsBorder, RoundedCornerShape(12.dp))
            .padding(10.dp)
    ) {
        Text(title, color = TsDark, fontWeight = FontWeight.SemiBold, fontSize = 11.sp)
        Spacer(Modifier.height(4.dp))
        Text(text, color = TsMuted, fontSize = 10.sp, lineHeight = 14.sp)
    }
}

@Composable
private fun HistoryRow(test: String, score: String) {
    Row(
        modifier = Modifier
            .padding(top = 6.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(test, color = TsDark, fontSize = 11.sp)
        Text(score, color = TsDark, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun RowScope.NextStepCard(text: String) {
    Column(
        modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .border(1.dp, TsBorder, RoundedCornerShape(10.dp))
            .padding(8.dp)
    ) {
        Text(text, color = TsDark, fontSize = 10.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
private fun ReviewRow(question: String, line1: String, line2: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFFDF7F7))
            .border(1.dp, Color(0xFFF1D9D9), RoundedCornerShape(12.dp))
            .padding(10.dp)
    ) {
        Text(question, color = TsDark, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(4.dp))
        Text(line1, color = TsRed, fontSize = 10.sp)
        Text(line2, color = TsGreen, fontSize = 10.sp)
    }
}
