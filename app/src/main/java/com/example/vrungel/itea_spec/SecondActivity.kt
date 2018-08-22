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


class SecondActivity : AppCompatActivity(), SecondActivityView {
  lateinit var str: String

  val adapter: Adapter = Adapter()
  val presenter: SecondPresenter by lazy {
    SecondPresenter(App.dataManager)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_second)
    presenter.attachView(this)
    str = intent.extras.getString("name_key")
    initUI()

    presenter.fetchCurrency()

  }


  override fun showList(list: List<CurrencyItem>) {
    Log.wtf("showList", list.toString())
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
