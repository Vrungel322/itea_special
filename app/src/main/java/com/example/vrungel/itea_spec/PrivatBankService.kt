package com.example.vrungel.itea_spec

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface PrivatBankService {
  @GET("/p24api/pubinfo?json&exchange")
  fun fetchCurrency(@Query("coursid") coursid: Int): Call<List<CurrencyItem>>
}

data class CurrencyItem(

    @SerializedName("ccy") var ccy: String? = null,
    @SerializedName("base_ccy") var baseCcy: String? = null,
    @SerializedName("buy") var buy: String? = null,
    @SerializedName("sale") var sale: String? = null

)

