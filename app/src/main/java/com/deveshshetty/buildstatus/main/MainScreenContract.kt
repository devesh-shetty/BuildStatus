package com.deveshshetty.buildstatus.main

interface MainScreenContract {

    interface ViewActionDelegate {
        fun onSampleButtonClick()
    }

    interface View {
        fun bindViewActionDelegate(viewActionDelegate: ViewActionDelegate)
    }
}