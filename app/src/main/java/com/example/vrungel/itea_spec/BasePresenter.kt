package com.example.vrungel.itea_spec

abstract class BasePresenter<V> {
  var view: V? = null

  fun attachView(v: V) {
    this.view = v
  }

  fun destroyView() {
    this.view = null
  }
}