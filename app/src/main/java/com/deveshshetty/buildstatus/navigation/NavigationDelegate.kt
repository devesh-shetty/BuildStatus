package com.deveshshetty.buildstatus.navigation

interface NavigationDelegate {
    fun navigateTo(destination: Destination)
}

enum class Destination {
    SAMPLE_FRAGMENT
}