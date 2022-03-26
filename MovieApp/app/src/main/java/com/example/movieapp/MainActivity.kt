package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.movieapp.databinding.ActivityMainBinding
import java.nio.file.attribute.PosixFileAttributeView

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.viewpager.adapter = ViewPagerAdapter(this)

        mainBinding.viewpager.registerOnPageChangeCallback(
            object: ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    mainBinding.bottomNavigation.menu.getItem(position).isChecked = true
                }
            }
        )

        mainBinding.bottomNavigation.run {
            setOnItemSelectedListener { item ->
                when(item.itemId) {
                    R.id.item_user -> {
                        mainBinding.viewpager.currentItem = 0
                        true
                    }
                    R.id.item_favorite -> {
                        mainBinding.viewpager.currentItem = 1
                        true
                    }
                    else -> false
                }
            }
        }
    }
}