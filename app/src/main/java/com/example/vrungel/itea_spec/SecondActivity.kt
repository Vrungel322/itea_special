package com.example.vrungel.itea_spec

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.btn
import kotlinx.android.synthetic.main.activity_second.rv_items

class SecondActivity : AppCompatActivity() {
  lateinit var str: String
  val adapter: Adapter = Adapter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_second)
    str = intent.extras.getString("name_key")

    rv_items.adapter = adapter
    rv_items.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

    btn.setOnClickListener {
      adapter.setList(DataManager.films())
    }

    adapter.itemClick = { film ->
      Toast.makeText(this, film.name, Toast.LENGTH_SHORT).show()
    }

  }
}
