package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import java.lang.ClassCastException

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), SeekBar.OnSeekBarChangeListener {

    private var seekBarValue = 10

    lateinit var activityCallback: ToolbarListener

    interface ToolbarListener {
        fun onButtonClick(position: Float, text: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("hailt","Fragment 1 - onAttach")
        try {
            activityCallback = context as ToolbarListener
        } catch (e: ClassCastException){
            Log.e("FirstFragment","ClassCastException")
            throw ClassCastException(context.toString()
                    + " must implement ToolbarListener");
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("hailt","Fragment 1")
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val seekBar = view.findViewById<SeekBar>(R.id.sbFirstFragment)
        seekBar.setOnSeekBarChangeListener(this)

        val tvFirst = view.findViewById<EditText>(R.id.etFirstFragment)

        val btn = view.findViewById<Button>(R.id.btnFirstFragment)
        btn.setOnClickListener {
            activityCallback.onButtonClick(seekBarValue.toFloat(), tvFirst.text.toString())
        }
        return view
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        seekBarValue = progress
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        TODO("Not yet implemented")
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        TODO("Not yet implemented")
    }
}