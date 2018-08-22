package com.example.vrungel.itea_spec

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import de.greenrobot.event.EventBus
import kotlinx.android.synthetic.main.activity_second.btn
import kotlinx.android.synthetic.main.activity_second.rv_items
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SecondActivity : AppCompatActivity() {
  lateinit var str: String
  val adapter: Adapter = Adapter()


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_second)
    str = intent.extras.getString("name_key")
    initUI()

    val service = retrofit.create(PrivatBankService::class.java)

    service.fetchCurrency(5).enqueue(object : Callback<List<CurrencyItem>> {
      override fun onFailure(call: Call<List<CurrencyItem>>?, t: Throwable?) {

      }

      override fun onResponse(call: Call<List<CurrencyItem>>?,
          response: Response<List<CurrencyItem>>?) {
        Log.wtf("TAG", response?.body()?.toString())
      }
    })

  }

  fun initUI() {
    rv_items.adapter = adapter

    rv_items.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    btn.setOnClickListener {
      adapter.setList(DataManager.films())
      EventBus.getDefault().post(DataManager.film())
    }

    adapter.itemClick = { film ->
      Toast.makeText(this, film.name, Toast.LENGTH_SHORT).show()
    }
  }
}
