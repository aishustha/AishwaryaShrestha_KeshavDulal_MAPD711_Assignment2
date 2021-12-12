package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class ThankYouSoundService : Service() {
    internal lateinit var player: MediaPlayer

    override fun onBind(arg0: Intent): IBinder?
    {
        return null
    }

    override fun onCreate()
    {
        super.onCreate()
        //val afd = applicationContext.assets.openFd("backgroundsound1.wav") as AssetFileDescriptor
        //playAudio()
        player = MediaPlayer.create(this,R.raw.thankyou)
        player!!.isLooping = false
        player!!.setVolume(0.5f, 0.5f)
        player!!.start()

    }

    @SuppressLint("WrongConstant")
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        player.start()
        return 1
    }

    override fun onStart(intent: Intent, startId: Int) {
        // TO DO
    }

    fun onUnBind(arg0: Intent): IBinder? {
        // TO DO Auto-generated method
        return null
    }

    fun onStop() {

    }

    fun onPause() {

    }

    override fun onDestroy() {
        player.stop()
        player.release()
    }

    override fun onLowMemory() {

    }

    companion object {
        private val TAG: String? = null
    }
}