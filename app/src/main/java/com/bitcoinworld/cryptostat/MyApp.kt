package com.bitcoinworld.cryptostat

import android.app.Application
import com.traffappscorelib.wsc.App
import com.traffappscorelib.wsc.IntroItem
import timber.log.Timber
import dagger.hilt.android.HiltAndroidApp




import android.R
import com.google.firebase.FirebaseApp


@HiltAndroidApp
class MyApp : App() {
    override fun getAppUiClassName(): Class<*> {
        return StartActivity::class.java
    }

    override fun getIntroBgColor(): Int {
        return R.color.black
    }

    override fun getIntroItems(): List<IntroItem> {
        val list: List<IntroItem> = ArrayList()
        return list;
    }


    override fun showIntro(): Boolean {
        return false
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(getApplicationContext());

        initTimber()
    }


    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}