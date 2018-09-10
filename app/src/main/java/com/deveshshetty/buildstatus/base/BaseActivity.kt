package com.deveshshetty.buildstatus.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.deveshshetty.buildstatus.R
import com.deveshshetty.buildstatus.navigation.Destination
import com.deveshshetty.buildstatus.navigation.NavigationDelegate
import com.deveshshetty.buildstatus.navigation.NavigationManager
import com.deveshshetty.buildstatus.navigation.NavigationManagerImpl

open class BaseActivity : AppCompatActivity(), NavigationDelegate {

    private val navigationManager: NavigationManager by lazy {
        NavigationManagerImpl(supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_layout)
        navigationManager.transitionToMainFragment()
    }

    override fun onBackPressed() {
        navigationManager.navigateBack(this)
    }

    override fun navigateTo(destination: Destination) {
        when (destination) {
            Destination.SAMPLE_FRAGMENT -> navigationManager.transitionToSampleFragment()
            else -> UnsupportedOperationException("Cannot navigate to $destination")
        }
    }
}