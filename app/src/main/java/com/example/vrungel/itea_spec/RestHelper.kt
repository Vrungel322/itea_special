package com.example.vrungel.itea_spec

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestHelper {

  var retrofit = Retrofit.Builder()
      .baseUrl("https://api.privatbank.ua/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()

}