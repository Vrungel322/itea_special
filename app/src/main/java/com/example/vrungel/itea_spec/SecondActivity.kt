package com.example.vrungel.itea_spec

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.arellomobile.mvp.MvpActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import de.greenrobot.event.EventBus
import kotlinx.android.synthetic.main.activity_second.btn
import kotlinx.android.synthetic.main.activity_second.rv_items


class SecondActivity : MvpActivity(), SecondActivityView {
  lateinit var str: String

  val adapter: Adapter = Adapter()
  @InjectPresenter
  lateinit var presenter: SecondPresenter

  @ProvidePresenter
  fun provideSecondPresenter(): SecondPresenter {
    return SecondPresenter(App.dataManager)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_second)
    str = intent.extras.getString("name_key")
    initUI()


  }

  override fun onStart() {
    super.onStart()
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
