package com.example.tunag3

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

//3)初期化＆構築
class CustomApplication  : Application(){
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        //Configuretion 構築
        val config = RealmConfiguration.Builder()
            .allowWritesOnUiThread(true)
            .allowQueriesOnUiThread(true)
            .build()
        Realm.setDefaultConfiguration(config)

    }
}