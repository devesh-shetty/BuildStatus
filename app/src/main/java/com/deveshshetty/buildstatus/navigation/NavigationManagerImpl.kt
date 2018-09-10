package com.deveshshetty.buildstatus.navigation

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.deveshshetty.buildstatus.main.MainFragment
import com.deveshshetty.buildstatus.R
import com.deveshshetty.buildstatus.sample.SampleFragment

internal class NavigationManagerImpl(private val fragmentManager: FragmentManager) : NavigationManager {

    //region  NavigationManager interface implementation
    override fun transitionToSampleFragment() {
        val fragment = SampleFragment.newInstance()
        transition(fragment)
    }

    override fun transitionToMainFragment() {
        val fragment = MainFragment.newInstance()
        openAsRoot(fragment)
    }

    override fun navigateBack(baseActivity: Activity) {
        if (fragmentManager.isLastScreen()) {
            baseActivity.finish()
        } else {
            fragmentManager.popBackStackImmediate()
        }
    }
    //endregion

    private fun transition(fragment: Fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.contentView, fragment)
                .addToBackStack(fragment.toString())
                .commit()
    }

    private fun openAsRoot(fragment: Fragment) {
        popAllFragments()
        transition(fragment)
    }

    private fun popAllFragments() {
        val stackSize = fragmentManager.backStackEntryCount
        for (i in 0 until stackSize) {
            val backStackId = fragmentManager.getBackStackEntryAt(i).id
            fragmentManager.popBackStack(backStackId, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    private fun FragmentManager.isLastScreen(): Boolean {
        return this.backStackEntryCount == 1
    }
}