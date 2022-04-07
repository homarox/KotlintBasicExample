package com.example.kotlinexfragmentcommunity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), Community {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentFirst = FirstFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragmentFirst).commit()
    }

    override fun passData(inputString: String) {
        val bundle = Bundle()
        bundle.putString("key", inputString)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentSecond = SecondFragment()
        fragmentSecond.arguments = bundle
        transaction.replace(R.id.fragmentContainer, fragmentSecond).commit()
    }
}