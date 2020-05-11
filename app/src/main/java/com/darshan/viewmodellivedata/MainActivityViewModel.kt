package com.darshan.viewmodellivedata

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainActivityViewModel : ViewModel() {

    val TAG = this.javaClass.simpleName
    //private var randomNumber: String = ""
    private var randomNumber: MutableLiveData<String>? = null


    fun getNumber(): MutableLiveData<String> {
        Log.i(TAG, "Get Number")
        if (randomNumber == null) {
            randomNumber = MutableLiveData()
            createNumber()
        }
        return randomNumber as MutableLiveData<String>
    }

    fun createNumber() {
        Log.i(TAG, "Create new number")
        val random = Random
        randomNumber?.value = "Number" + (random.nextInt(10 - 1) + 1)
    }

    override fun onCleared() {
        super.onCleared()
        //Only called when activity is completely destroyed.
        Log.i(TAG, "Cleared")
    }
}