package com.example.chua.lifecycles.step3

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.SystemClock
import java.util.*

class LiveDataTimerViewModel : ViewModel() {

    private val mElapsedTime = MutableLiveData<Long>()

    private val mInitialTime: Long = SystemClock.elapsedRealtime()

    // Will be used when step is completed
    val elapsedTime: LiveData<Long>
        get() = mElapsedTime

    init {
        val timer = Timer()

        // Update the elapsed time every second.
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                (SystemClock.elapsedRealtime() - mInitialTime) / 1000

                // setValue() cannot be called from a background thread so post to main thread.
                //TODO post the new value with LiveData.postValue()
            }
        }, ONE_SECOND.toLong(), ONE_SECOND.toLong())

    }

    companion object {

        private val ONE_SECOND = 1000
    }
}