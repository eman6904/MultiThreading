package com.example.thread

import android.graphics.Color.parseColor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thread.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = ""
        supportActionBar?.hide()
        //Multi Threading-->It is the ability to perform a number of different tasks
        // at the same time in parallel without any error
        var onOff = false
        binding.button.setOnClickListener()
        {
            val listColor=ArrayList<String>()
            listColor.add("#FF018786")
            listColor.add("#FFFFFFFF")
            listColor.add("#FFEA1558")
            listColor.add("#FF2AC130")
            listColor.add("#FFF13729")
            listColor.add("#FF9C27B0")
            listColor.add("#FFEA1558")
            listColor.add("#FFFFEB3B")
            listColor.add("#FF3F51B5")
           onOff=!onOff
            var colorNumber=0
            if (onOff) {
                binding.button.text = "Stop"
                Thread(Runnable {
                    while (onOff) {
                        runOnUiThread()
                        {
                         binding.te1.setBackgroundColor(parseColor(listColor[colorNumber]))
                         if(colorNumber==7)
                             colorNumber=0
                         else
                             colorNumber++
                        }
                        Thread.sleep(1000)
                    }
                }).start()
                Thread(Runnable {
                    while (onOff) {
                        runOnUiThread()
                        {
                          binding.te2.setBackgroundColor(parseColor(listColor[colorNumber]))
                          if(colorNumber==7)
                              colorNumber=0
                          else
                              colorNumber++
                        }
                        Thread.sleep(1000)
                    }
                }).start()
                Thread(Runnable {
                    while (onOff) {
                        runOnUiThread()
                        {
                         binding.te3.setBackgroundColor(parseColor(listColor[colorNumber]))
                         if(colorNumber==7)
                             colorNumber=0
                         else
                             colorNumber++
                        }
                        Thread.sleep(1000)
                    }
                }).start()
                Thread(Runnable {
                    while (onOff) {
                        runOnUiThread()
                        {
                         binding.te4.setBackgroundColor(parseColor(listColor[colorNumber]))
                         if(colorNumber==7)
                             colorNumber=0
                         else
                             colorNumber++
                        }
                        Thread.sleep(1000)
                    }
                }).start()
            } else {
                binding.button.text = "Start"
                binding.te1.setBackgroundColor(parseColor("#FFFFFFFF"))
                binding.te2.setBackgroundColor(parseColor("#FFFFFFFF"))
                binding.te3.setBackgroundColor(parseColor("#FFFFFFFF"))
                binding.te4.setBackgroundColor(parseColor("#FFFFFFFF"))
            }
        }
    }
}