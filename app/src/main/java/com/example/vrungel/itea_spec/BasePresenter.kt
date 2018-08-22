package com.example.vrungel.itea_spec

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView

abstract class BasePresenter<V : MvpView?> : MvpPresenter<V>() {

}