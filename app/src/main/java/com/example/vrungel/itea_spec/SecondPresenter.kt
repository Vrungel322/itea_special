package com.example.vrungel.itea_spec

import android.util.Log

class SecondPresenter(val dataManager: DataManager) : BasePresenter<SecondActivityView>() {

  fun fetchCurrency() {
    dataManager.fetchCurency(successCallback = { list ->
      view?.showList(list)
    }, failCallbacck = { errorMsg ->
      Log.wtf("SecondPresenter", errorMsg)
    })
  }


}