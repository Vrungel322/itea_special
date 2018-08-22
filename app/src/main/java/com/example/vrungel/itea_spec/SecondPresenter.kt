package com.example.vrungel.itea_spec

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class SecondPresenter() : MvpPresenter<SecondActivityView>() {
  //   var dataManager: DataManager = App.dataManager
  lateinit var dataManager: DataManager

  constructor(dm: DataManager) : this() {
    dataManager = dm
  }

  override fun onFirstViewAttach() {
    super.onFirstViewAttach()
    fetchCurrency()
  }

  fun fetchCurrency() {
    dataManager.fetchCurency(successCallback = { list ->
      viewState?.showList(list)
    }, failCallbacck = { errorMsg ->
      Log.wtf("SecondPresenter", errorMsg)
    })
  }


}