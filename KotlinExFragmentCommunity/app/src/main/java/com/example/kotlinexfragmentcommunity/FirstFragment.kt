package com.example.kotlinexfragmentcommunity

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
class FirstFragment : Fragment(){

    private lateinit var community: Community

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("hailt","Fragment 1")
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        community = activity as Community

        val tvFirst = view.findViewById<EditText>(R.id.etFirstFragment)

        val btn = view.findViewById<Button>(R.id.btnFirstFragment)
        btn.setOnClickListener {
            community.passData(tvFirst.text.toString())
        }
        return view
    }
}