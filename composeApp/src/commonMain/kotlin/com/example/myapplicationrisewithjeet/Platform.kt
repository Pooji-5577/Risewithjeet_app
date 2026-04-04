package com.example.myapplicationrisewithjeet

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform