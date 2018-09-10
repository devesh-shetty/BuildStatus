package com.deveshshetty.buildstatus.navigation

import android.app.Activity

internal interface NavigationManager {
    fun transitionToMainFragment()
    fun transitionToSampleFragment()
    fun navigateBack(baseActivity: Activity)
}