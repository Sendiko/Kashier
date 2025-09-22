package org.chevalierlab.kashier

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform