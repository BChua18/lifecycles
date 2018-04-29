package com.example.chua.lifecycles.step5_solution

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.example.chua.lifecycles.step5.SeekBarViewModel

class Fragmentstep_5 : Fragment() {

    private var mSeekBar: SeekBar? = null

    private var mSeekBarViewModel: SeekBarViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_step5, container, false)
        mSeekBar = root.findViewById(R.id.seekBar)

        mSeekBarViewModel = ViewModelProviders.of(activity!!).get(SeekBarViewModel::class.java)

        subscribeSeekBar()

        return root
    }

    private fun subscribeSeekBar() {

        // Update the ViewModel when the SeekBar is changed.
        mSeekBar!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    Log.d("Step5", "Progress changed!")
                    mSeekBarViewModel!!.seekbarValue.value = progress
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        // Update the SeekBar when the ViewModel is changed.
        mSeekBarViewModel!!.seekbarValue.observe(activity!!, Observer { value ->
            if (value != null) {
                mSeekBar!!.progress = value
            }
        })
    }
}