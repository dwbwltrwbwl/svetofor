package com.example.svetofor

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var redLight: View
    private lateinit var yellowLight: View
    private lateinit var greenLight: View

    private var currentState = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState != null) {
            currentState = savedInstanceState.getInt("CURRENT_STATE", 0)
        }

        redLight = findViewById(R.id.redLight)
        yellowLight = findViewById(R.id.yellowLight)
        greenLight = findViewById(R.id.greenLight)

        val changeButton = findViewById<View>(R.id.changeButton)
        changeButton.setOnClickListener { changeLight() }

        updateLights()
    }

    private fun changeLight() {
        currentState = (currentState + 1) % 4
        updateLights()
    }

    private fun updateLights() {

        redLight.setBackgroundResource(R.drawable.circle_gray)
        yellowLight.setBackgroundResource(R.drawable.circle_gray)
        greenLight.setBackgroundResource(R.drawable.circle_gray)

        when (currentState) {
            0 -> redLight.setBackgroundResource(R.drawable.circle_red)
            1 -> yellowLight.setBackgroundResource(R.drawable.circle_yellow)
            2 -> greenLight.setBackgroundResource(R.drawable.circle_green)
            3 -> yellowLight.setBackgroundResource(R.drawable.circle_yellow)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("CURRENT_STATE", currentState)
    }
}