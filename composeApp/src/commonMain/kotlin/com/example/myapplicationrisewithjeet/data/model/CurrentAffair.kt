package com.example.myapplicationrisewithjeet.data.model

data class CurrentAffair(
    val id: Int,
    val title: String,
    val summary: String,
    val category: String,
    val date: String,
    val isBookmarked: Boolean = false,
    val tags: List<String> = emptyList()
)

val sampleCurrentAffairs = listOf(
    CurrentAffair(
        1,
        "India's Space Mission Gaganyaan Update",
        "ISRO successfully completes another critical test for India's first human spaceflight mission. The crew module successfully demonstrated abort capabilities crucial for astronaut safety.",
        "Science & Tech",
        "27 Mar 2026",
        tags = listOf("ISRO", "Space", "Science")
    ),
    CurrentAffair(
        2,
        "PM-KISAN Scheme: 18th Installment Released",
        "The government released the 18th installment of PM-KISAN scheme, benefiting over 9.26 crore farmers with ₹2,000 each directly transferred to their bank accounts.",
        "Economy",
        "26 Mar 2026",
        tags = listOf("Agriculture", "Scheme", "Economy")
    ),
    CurrentAffair(
        3,
        "India Achieves Record Renewable Energy Capacity",
        "India's total installed renewable energy capacity crosses 200 GW milestone. Solar energy leads the growth with over 85 GW installed capacity.",
        "Environment",
        "25 Mar 2026",
        tags = listOf("Energy", "Climate", "Environment")
    ),
    CurrentAffair(
        4,
        "Supreme Court Verdict on Electoral Bonds",
        "The Supreme Court of India delivered a landmark judgment on electoral bonds scheme, focusing on transparency and right to information in political funding.",
        "Polity",
        "24 Mar 2026",
        tags = listOf("Supreme Court", "Elections", "Polity")
    ),
    CurrentAffair(
        5,
        "India-ASEAN Trade Agreement Review",
        "India and ASEAN nations begin formal review of the free trade agreement to address trade deficit concerns and improve market access for Indian goods.",
        "International",
        "23 Mar 2026",
        tags = listOf("Trade", "International", "Economy")
    ),
    CurrentAffair(
        6,
        "New Education Policy Implementation Progress",
        "Ministry of Education releases report on NEP 2020 implementation highlighting 50% increase in higher education enrollment and multidisciplinary curriculum adoption.",
        "Education",
        "22 Mar 2026",
        tags = listOf("NEP", "Education", "Policy")
    ),
    CurrentAffair(
        7,
        "Tiger Census 2026: India's Big Cat Numbers Rise",
        "India's tiger population reaches 3,682 as per the latest census, reaffirming India's position as home to 75% of world's wild tigers.",
        "Environment",
        "21 Mar 2026",
        tags = listOf("Wildlife", "Tiger", "Environment")
    ),
    CurrentAffair(
        8,
        "Digital India Initiative: 5G Rollout Complete",
        "India achieves complete 5G network rollout across all state capitals and major cities. Over 200 districts now have 5G connectivity.",
        "Science & Tech",
        "20 Mar 2026",
        tags = listOf("5G", "Digital India", "Technology")
    ),
)
