package com.kite.joco.servicepone

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Toast
import java.util.*
import kotlin.concurrent.thread

class MyTimeService : Service() {

    var enabled = false

    inner class MyTimeThread : Thread() {
        override fun run() {
            val handlerMain = Handler(Looper.getMainLooper())

            while (enabled) {
                handlerMain.post {
                    Toast.makeText(
                        this@MyTimeService, Date(System.currentTimeMillis()).toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }

                sleep(5000)
            }
        }
    }
    /*    var enabled = false

    inner class MyTimeThread: Thread() {
        override fun run() {
            val handlerMain = Handler(Looper.getMainLooper())
            while(enabled)
                handlerMain.post {

                    Toast.makeText(
                        this@MyTimeService,
                        Date(System.currentTimeMillis()).toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            sleep(50000)
        }
    }*/



    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!enabled) {
            enabled = true
            //MyTimeThread().start()
            thread(start = enabled) {
                /*    Toast.makeText(
                    this@MyTimeService,
                    Date(System.currentTimeMillis()).toString(),
                    Toast.LENGTH_SHORT
                ).show()
                println("${Thread.currentThread()} has run.")
            }*/
                val handlerMain = Handler(Looper.getMainLooper())

                while (enabled) {
                    handlerMain.post {
                        Toast.makeText(
                            this@MyTimeService, Date(System.currentTimeMillis()).toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    Thread.sleep(5000)
                }
            }
        }

        return START_STICKY_COMPATIBILITY
    }

    override fun onDestroy() {
        super.onDestroy()
        enabled = false
    }
}

/*import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Toast
import java.util.*

class MyTimeService : Service() {


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        enabled = true
        MyTimeThread().start()
        return START_STICKY_COMPATIBILITY
    }

    override fun onDestroy() {
        super.onDestroy()
        enabled = false
        //MyTimeThread().stop()
    }
}*/