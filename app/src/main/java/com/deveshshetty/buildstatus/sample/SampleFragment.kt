package com.deveshshetty.buildstatus.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deveshshetty.buildstatus.base.BaseFragment
import com.deveshshetty.buildstatus.R

class SampleFragment : BaseFragment() {

    companion object {
        fun newInstance() = SampleFragment()
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sample_layout, container, false)
    }
}