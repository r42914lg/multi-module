package com.r42914lg.mentor

import android.app.Application
import com.r42914lg.mentor.di.AppComponent
import com.r42914lg.mentor.di.DaggerAppComponent

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppComponent.init(DaggerAppComponent.factory().create(this))
    }

}