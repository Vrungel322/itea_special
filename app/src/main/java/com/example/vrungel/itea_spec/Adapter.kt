package com.example.vrungel.itea_spec

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vrungel.itea_spec.Adapter.CustomViewHolder
import kotlinx.android.synthetic.main.custom_item.view.tvItemCountry
import kotlinx.android.synthetic.main.custom_item.view.tvItemName
import kotlinx.android.synthetic.main.custom_item.view.tvItemRate



class Adapter : RecyclerView.Adapter<CustomViewHolder>() {
  val list = mutableListOf<Film>()
  var itemClick: ((Film) -> Unit)? = null

  fun setList(items: List<Film>) {
    val diffResult = DiffUtil.calculateDiff(MyDiffCallback(items, list))
    list.clear()
    list.addAll(items)
    diffResult.dispatchUpdatesTo(this)
  }

  override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
    holder.itemView.apply {
      tvItemCountry.text = list[position].country
      tvItemName.text = list[position].name
      tvItemRate.text = list[position].rate.toString()
      setOnClickListener { itemClick?.invoke(list[position]) }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
    return CustomViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.custom_item, parent, false))
  }

  override fun getItemCount(): Int {
    return list.size
  }


  class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view)

}