package com.example.androidbasics

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders


class MainActivity : AppCompatActivity() {

    private lateinit var changeColorButton: Button
    private lateinit var mainView : View
    private lateinit var colorChangerViewModel : ColorChangerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorChangerViewModel = ViewModelProviders.of(this).get(ColorChangerViewModel::class.java)
        changeColorButton = findViewById(R.id.btnChangeColor)
        mainView = findViewById(R.id.rootView)

//        mainView.setBackgroundColor(colorChangerViewModel.getColorResource())
//
//        changeButton.setOnClickListener {
//            val color = generateRandomColor()
//            mainView.setBackgroundColor(color)
//            colorChangerViewModel.setColorResource(color)
//        }

        colorChangerViewModel.colorResource.observe(this, object: Observer<Int>{
            override fun onChanged(color: Int?) {
                mainView.setBackgroundColor(color!!)
            }
        })

        changeColorButton.setOnClickListener{
            colorChangerViewModel.colorResource.value = generateRandomColor()
        }
    }

    private fun generateRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}
