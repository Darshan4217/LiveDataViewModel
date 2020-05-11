package com.darshan.viewmodellivedata

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: MainActivityViewModel =
            ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        val myRandomNumber = model.getNumber()

        myRandomNumber.observe(this, Observer {
            txtNumber.text = it
            Log.i(TAG, "NumberSet")

        })

        button.setOnClickListener {
            model.createNumber()
        }
    }
}
