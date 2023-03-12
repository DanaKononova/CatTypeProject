package com.example.catproject

import android.app.Application
import com.example.catproject.di.AppComponent
import com.example.catproject.di.DaggerAppComponent

class HiltApplication: Application(){
    val appComponent: AppComponent by lazy { DaggerAppComponent.factory().create(applicationContext) }
}