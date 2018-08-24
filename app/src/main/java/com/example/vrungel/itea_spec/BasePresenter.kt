package com.example.vrungel.itea_spec

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<V : MvpView?> : MvpPresenter<V>() {
  val compositeDisposable: CompositeDisposable = CompositeDisposable()

  fun addToUnsubscribe(d: Disposable) {
    compositeDisposable.add(d)
  }

  fun addToUnsubscribe(func: () -> Disposable) {
    compositeDisposable.add(func.invoke())
  }

  override fun onDestroy() {
    compositeDisposable.clear()
    super.onDestroy()
  }

}