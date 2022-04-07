package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity(), FirstFragment.ToolbarListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /** Make sure add
         * class = "com.example.myapplication.FirstFragment"
         */
    }

    override fun onButtonClick(position: Float, text: String) {
        /** Have to implement ToolbarListener to context
         */
        val secondFragment: SecondFragment =
            supportFragmentManager.findFragmentById(R.id.id_fragment_two) as SecondFragment
        secondFragment.changeTextProperties(position, text)
    }
}