package com.deveshshetty.buildstatus.main

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.view.*

class MainView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), MainScreenContract.View {

    private lateinit var viewActionDelegate: MainScreenContract.ViewActionDelegate

    override fun bindViewActionDelegate(viewActionDelegate: MainScreenContract.ViewActionDelegate) {
        this.viewActionDelegate = viewActionDelegate
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        btnSample.setOnClickListener {
            viewActionDelegate.onSampleButtonClick()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        btnSample.setOnClickListener(null)
    }
}