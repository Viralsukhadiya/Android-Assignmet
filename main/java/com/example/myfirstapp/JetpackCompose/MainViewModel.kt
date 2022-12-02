package com.example.jetpackcomposeandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(var initialValue:Int) :ViewModel() {
    private var counter = initialValue

    val liveDataObject : LiveData<Int>
        get() = counterLiveData

    private var counterLiveData = MutableLiveData<Int>(counter)

    fun incrementValue() {
        counter++
        counterLiveData.value = counter

    }

    fun decrementValue() {
        counter--
        counterLiveData.value = counter
    }
}