package com.kite.joco.servicepone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kite.joco.servicepone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var TAG = "MAIN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentMyTimeService = Intent(this,MyTimeService::class.java)
        binding.btnStart.setOnClickListener {
            Log.i(TAG,"Start")
            startService(intentMyTimeService)
        }

        binding.btnStop.setOnClickListener {
            Log.i(TAG,"Stop")
            stopService(intentMyTimeService)
        }
    }
}