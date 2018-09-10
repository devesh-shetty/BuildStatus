package com.deveshshetty.buildstatus.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.deveshshetty.buildstatus.navigation.Destination
import com.shopify.livedataktx.SingleLiveData

class MainViewModel : ViewModel(), MainScreenContract.ViewActionDelegate {

    private val _navigationDestinationLiveData = SingleLiveData<Destination>()
    val navigationDestinationLiveData: LiveData<Destination> = _navigationDestinationLiveData

    override fun onSampleButtonClick() {
        _navigationDestinationLiveData.postValue(Destination.SAMPLE_FRAGMENT)
    }
}