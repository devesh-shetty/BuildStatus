package com.deveshshetty.buildstatus.main

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deveshshetty.buildstatus.R
import com.deveshshetty.buildstatus.base.BaseFragment
import com.deveshshetty.buildstatus.navigation.NavigationDelegate
import com.shopify.livedataktx.nonNull
import com.shopify.livedataktx.observe

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var rootView: View? = null
    private var navigationDelegate: NavigationDelegate? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.activity_main, container, false)
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewModelProviders.of(this).get(MainViewModel::class.java).run {
            bind(viewLifecycleOwner)
            (rootView as MainView).bindViewActionDelegate(this)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is NavigationDelegate) {
            navigationDelegate = context
        } else {
            throw IllegalStateException("Container Activity must implement NavigationDelegate")
        }
    }

    override fun onDetach() {
        super.onDetach()
        navigationDelegate = null
    }

    private fun MainViewModel.bind(lifecycleOwner: LifecycleOwner) {
        navigationDestinationLiveData.nonNull().observe(lifecycleOwner) {
            navigationDelegate?.navigateTo(destination = it)
        }
    }
}
