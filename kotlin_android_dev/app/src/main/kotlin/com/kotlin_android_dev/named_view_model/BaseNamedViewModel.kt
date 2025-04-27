package com.kotlin_android_dev.named_view_model

import androidx.lifecycle.ViewModel
import io.github.antonpichka.lamm.TempCacheProvider
import io.github.antonpichka.lamm.base_data_for_named.BaseDataForNamed
import io.github.antonpichka.lamm.base_named_stream_w_state.BaseNamedStreamWState

abstract class BaseNamedViewModel<T : Enum<T>, Y : BaseDataForNamed<T>> protected constructor(
    protected val tempCacheProvider: TempCacheProvider,
    private val namedStreamWState: BaseNamedStreamWState<T,Y>) : ViewModel()
{
    var isInitFirstRequest: Boolean = false
    private var isInitListen: Boolean = false

    override fun onCleared() {
        super.onCleared()
        namedStreamWState.dispose()
    }

    fun getDataForNamed(): Y {
        return namedStreamWState.getDataForNamed()
    }

    fun listenStreamDataForNamedFromCallback(callback: (event: Y) -> Unit) {
        if(isInitListen) {
            return
        }
        isInitListen = true
        namedStreamWState.listenStreamDataForNamedFromCallback(callback)
    }

    fun notifyStreamDataForNamed() {
        namedStreamWState.notifyStreamDataForNamed()
    }
}