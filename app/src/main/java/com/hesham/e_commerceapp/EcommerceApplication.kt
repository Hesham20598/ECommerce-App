package com.hesham.e_commerceapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EcommerceApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

}