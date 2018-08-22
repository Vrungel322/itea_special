package com.example.vrungel.itea_spec

import android.app.Application

class App : Application() {

  companion object {
    lateinit var dataManager: DataManager
  }

  override fun onCreate() {
    super.onCreate()

    dataManager = DataManager()

  }
}