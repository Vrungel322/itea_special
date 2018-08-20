package com.example.vrungel.itea_spec

class DataManager {
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

}