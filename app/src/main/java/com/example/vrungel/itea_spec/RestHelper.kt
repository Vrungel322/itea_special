package com.example.vrungel.itea_spec

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RestHelper {

  private var retrofit: Retrofit? = null
  private var service: PrivatBankService? = null

  init {
    retrofit = Retrofit.Builder()
        .baseUrl("https://api.privatbank.ua/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    service = retrofit?.create(PrivatBankService::class.java)
  }

  fun fetchCurency(): Observable<List<CurrencyItem>> {
    return service?.fetchCurrency(5)!!
  }

}