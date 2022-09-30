package com.example.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thread.databinding.ActivityTwoButtonTwoThreeadBinding

class TwoButtonTwoThread : AppCompatActivity() {
    private lateinit var binding: ActivityTwoButtonTwoThreeadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwoButtonTwoThreeadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = ""
        supportActionBar?.hide()
        var btn1 = false
        var btn2 = false
        binding.b1.setOnClickListener {
            btn1 = !btn1
            if (btn1) {
                binding.b1.text="stop"
                Thread(Runnable {
                    var counter=-1
                      while(btn1){
                          counter++
                          runOnUiThread()
                          {
                              binding.t1.text = counter.toString()
                          }
                          Thread.sleep(100)
                      }
                }).start()
            } else {
                binding.b1.text="increase"
                binding.t1.text = "0"
            }
        }
        binding.b2.setOnClickListener {
            btn2 = !btn2
            if (btn2) {
                binding.b2.text="stop"
                Thread(Runnable {
                    var counter=1001
                    while(btn2){
                        counter--
                        runOnUiThread()
                        {
                            binding.t2.text = counter.toString()
                        }
                        Thread.sleep(100)
                    }
                }).start()
            } else {
                binding.b2.text="decrease"
                binding.t2.text = "1000"
            }
        }

    }
}