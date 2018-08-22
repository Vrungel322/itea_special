package com.example.vrungel.itea_spec

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

  fun fetchCurency(
      successCallback: ((List<CurrencyItem>) -> Unit)? = null,
      failCallbacck: ((String) -> Unit)? = null) {
    restHelper.fetchCurency(successCallback = successCallback, failCallbacck = failCallbacck)
  }

}