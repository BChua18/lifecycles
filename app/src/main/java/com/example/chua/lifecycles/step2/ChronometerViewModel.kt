package com.example.chua.lifecycles.step2

import android.arch.lifecycle.ViewModel

class ChronometerViewModel : ViewModel() {

    var startTime: Long? = null
        private set

    fun setStartTime(startTime: Long) {
        this.startTime = startTime
    }
}