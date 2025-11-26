package com.pawkrzysciak.portfolio

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform