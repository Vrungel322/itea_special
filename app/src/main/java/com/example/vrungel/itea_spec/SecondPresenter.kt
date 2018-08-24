package com.example.vrungel.itea_spec

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InjectViewState
class SecondPresenter() : BasePresenter<SecondActivityView>() {
  //   var dataManager: DataManager = App.dataManager
  lateinit var dataManager: DataManager

  constructor(dm: DataManager) : this() {
    dataManager = dm
  }

  override fun onFirstViewAttach() {
    super.onFirstViewAttach()
    fetchCurrency()
    fetchRX()
  }

  fun fetchCurrency() {
    addToUnsubscribe {
      dataManager.fetchCurency()
          .flatMap { Observable.fromIterable(it) }
          .filter {
            it.buy?.toDouble()!! >= 30 == true
          }
          .toList()
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            viewState.showList(it)
          }, { it.printStackTrace() })
    }

  }

  fun fetchRX() {
    Observable.just("String Rx")
        .flatMap {
          Log.wtf("fetchRX", it)
          val f = DataManager.film()
          f.name = it
          Observable.just(f)
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { Log.wtf("fetchRX", it.toString()) }, //OnNext
            { t -> t.printStackTrace() }, //OnError
            { Log.wtf("fetchRX", "OnCompleat") } //OnCompleate
        )
  }


}