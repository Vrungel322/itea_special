package com.example.vrungel.itea_spec

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface SecondActivityView : MvpView {
  fun showList(list: List<CurrencyItem>)
}