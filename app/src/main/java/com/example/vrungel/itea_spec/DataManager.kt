package com.example.vrungel.itea_spec

import io.reactivex.Observable

class DataManager {
  private val restHelper: RestHelper = RestHelper()

  companion object {
    fun film(): Film = Film("Film name", 5, "USA")

    fun films(): List<Film> {
      val list = listOf<Film>(Film("Film name0", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name1", 5, "USA"),
          Film("Film name2", 5, "USA"))
      return list
    }
  }

  fun fetchCurency(): Observable<List<CurrencyItem>> {
   return restHelper.fetchCurency()
  }

}