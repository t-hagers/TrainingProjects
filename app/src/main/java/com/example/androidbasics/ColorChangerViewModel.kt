package com.example.androidbasics

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorChangerViewModel : ViewModel() {
//    private var colorResource: Int = 0xfff
//
//    fun setColorResource(colorResource: Int) {
//        this.colorResource = colorResource
//    }
//
//    fun getColorResource() = colorResource
    val colorResource = MutableLiveData<Int>()

    init {
        colorResource.value = 0xfff
    }
}