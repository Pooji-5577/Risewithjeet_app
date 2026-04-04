package com.example.myapplicationrisewithjeet.data.model

data class Question(
    val id: Int,
    val subjectId: String,
    val question: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String,
    val difficulty: Difficulty = Difficulty.MEDIUM
)

enum class Difficulty { EASY, MEDIUM, HARD }

val sampleQuestions = listOf(
    Question(
        1, "polity",
        "Which article of the Indian Constitution abolishes untouchability?",
        listOf("Article 14", "Article 17", "Article 21", "Article 23"),
        1,
        "Article 17 of the Indian Constitution abolishes untouchability and its practice in any form is forbidden."
    ),
    Question(
        2, "history",
        "The Battle of Plassey (1757) was fought between the British East India Company and the Nawab of:",
        listOf("Mysore", "Bengal", "Hyderabad", "Awadh"),
        1,
        "The Battle of Plassey was fought between the British East India Company and Siraj ud-Daulah, the Nawab of Bengal, resulting in British victory."
    ),
    Question(
        3, "geography",
        "Which river is known as the 'Sorrow of Bihar'?",
        listOf("Ganga", "Kosi", "Son", "Gandak"),
        1,
        "The Kosi river is known as the 'Sorrow of Bihar' due to frequent floods it causes in the region."
    ),
    Question(
        4, "economy",
        "The Goods and Services Tax (GST) in India was implemented on:",
        listOf("1 April 2016", "1 July 2017", "1 January 2018", "15 August 2017"),
        1,
        "GST was implemented in India on 1 July 2017 replacing multiple indirect taxes with a unified tax structure."
    ),
    Question(
        5, "environment",
        "The 'Green GDP' concept accounts for:",
        listOf("Agricultural GDP only", "Depletion of natural resources", "Industrial output", "Export earnings"),
        1,
        "Green GDP adjusts traditional GDP by accounting for environmental costs including the depletion of natural resources and environmental degradation."
    ),
    Question(
        6, "polity",
        "The Preamble to the Indian Constitution was amended by which Constitutional Amendment?",
        listOf("42nd Amendment, 1976", "44th Amendment, 1978", "52nd Amendment, 1985", "73rd Amendment, 1992"),
        0,
        "The 42nd Constitutional Amendment Act of 1976 amended the Preamble to add the words 'Socialist', 'Secular' and 'Integrity'."
    ),
    Question(
        7, "science",
        "Which organ of the human body is affected by Hepatitis?",
        listOf("Kidney", "Liver", "Heart", "Lung"),
        1,
        "Hepatitis is inflammation of the liver, caused by viral infections (Hepatitis A, B, C, D, E viruses)."
    ),
    Question(
        8, "history",
        "Who gave the slogan 'Do or Die' during the Quit India Movement?",
        listOf("Jawaharlal Nehru", "Mahatma Gandhi", "Subhas Chandra Bose", "Bal Gangadhar Tilak"),
        1,
        "Mahatma Gandhi gave the slogan 'Do or Die' (Karo ya Maro) during the Quit India Movement on 8 August 1942."
    ),
    Question(
        9, "geography",
        "The Tropic of Cancer does NOT pass through which Indian state?",
        listOf("Rajasthan", "Gujarat", "Maharashtra", "Mizoram"),
        2,
        "The Tropic of Cancer passes through Gujarat, Rajasthan, Madhya Pradesh, Chhattisgarh, Jharkhand, West Bengal, Tripura and Mizoram. It does NOT pass through Maharashtra."
    ),
    Question(
        10, "art_culture",
        "Bharatanatyam is a classical dance form originating from which state?",
        listOf("Kerala", "Andhra Pradesh", "Tamil Nadu", "Karnataka"),
        2,
        "Bharatanatyam is one of the oldest classical dance forms of India, originating from Tamil Nadu, formerly called Sadir."
    ),
    Question(
        11, "economy",
        "NITI Aayog replaced which body in 2015?",
        listOf("Finance Commission", "Planning Commission", "Economic Advisory Council", "National Development Council"),
        1,
        "NITI Aayog (National Institution for Transforming India) replaced the Planning Commission on 1 January 2015."
    ),
    Question(
        12, "polity",
        "How many Fundamental Duties are listed in the Indian Constitution?",
        listOf("9", "10", "11", "12"),
        2,
        "There are 11 Fundamental Duties in the Indian Constitution (Article 51A). Originally 10 were added by 42nd Amendment; 11th was added by 86th Amendment in 2002."
    ),
)
