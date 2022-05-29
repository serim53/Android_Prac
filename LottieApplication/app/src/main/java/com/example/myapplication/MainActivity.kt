package com.example.myapplication

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mbinding: ActivityMainBinding? = null
    private val binding get() = mbinding!!
    private var isClicked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickButton(view: View) {
        if(!isClicked) {
            val animator = ValueAnimator.ofFloat(0f, 0.5f).setDuration(500)
            animator.addUpdateListener {
                binding.lottieView.progress = it.animatedValue as Float
            }
            animator.start()
            isClicked = true
        } else {
            val animator = ValueAnimator.ofFloat(0.5f, 1f).setDuration(500)
            animator.addUpdateListener {
                binding.lottieView.progress = it.animatedValue as Float
            }
            animator.start()
            isClicked = false
        }
    }
}