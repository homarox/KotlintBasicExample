package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("hailt","Fragment 2")
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        textView = view.findViewById<TextView>(R.id.tvSecondFragment)

        return view
    }

    fun changeTextProperties (fontSize: Float, text: String){
        textView.text = text
        textView.textSize = fontSize
    }
}