package com.example.vrungel.itea_spec

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestHelper {

  private var retrofit: Retrofit? = null
  private var service: PrivatBankService? = null

  init {
    retrofit = Retrofit.Builder()
        .baseUrl("https://api.privatbank.ua/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    service = retrofit?.create(PrivatBankService::class.java)
  }

  fun fetchCurency(
      successCallback: ((List<CurrencyItem>) -> Unit)? = null,
      failCallbacck: ((String) -> Unit)? = null) {
    service?.fetchCurrency(5)?.enqueue(object : Callback<List<CurrencyItem>> {
      override fun onFailure(call: Call<List<CurrencyItem>>?, t: Throwable?) {
        t?.localizedMessage?.let { failCallbacck?.invoke(it) }
      }

      override fun onResponse(call: Call<List<CurrencyItem>>?,
          response: Response<List<CurrencyItem>>?) {
        Log.wtf("TAG", response?.body()?.toString())
        response?.body()?.let { successCallback?.invoke(it) }
      }
    })
  }

}