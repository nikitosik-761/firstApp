package com.example.epl

import android.app.Application

class EplApplication: Application() { //parent to the entire class - !Manifest

    companion object{
        lateinit var application: EplApplication
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        SharedPreUtil.init(this)
    }


}