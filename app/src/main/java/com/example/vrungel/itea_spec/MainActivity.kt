package com.example.vrungel.itea_spec

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.iv_prev
import kotlinx.android.synthetic.main.activity_main.tv_country
import kotlinx.android.synthetic.main.activity_main.tv_description
import kotlinx.android.synthetic.main.activity_main.tv_name
import kotlinx.android.synthetic.main.activity_main.tv_rate

class MainActivity : AppCompatActivity() {
  var str: String = "hi"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    str = "hi2"

    tv_name.text = DataManager.film().name
    tv_rate.text = DataManager.film().rate.toString()
    tv_country.text = DataManager.film().country
    tv_description.text = "fldkbhkjbkjsbnkcabnlksdc"

    iv_prev.setOnClickListener { v ->
      Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
      val intent: Intent = Intent(this, SecondActivity::class.java)
      intent.putExtra("name_key", DataManager.film().name)
      startActivity(intent)
    }
  }

  override fun onStart() {
    super.onStart()
  }

  override fun onResume() {
    super.onResume()
  }

  override fun onPause() {
    super.onPause()
  }

  override fun onStop() {
    super.onStop()
  }

  override fun onDestroy() {
    super.onDestroy()
  }
}
