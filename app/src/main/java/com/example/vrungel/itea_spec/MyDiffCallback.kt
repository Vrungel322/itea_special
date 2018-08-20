package com.example.vrungel.itea_spec

import android.support.v7.util.DiffUtil


class MyDiffCallback(internal var newPersons: List<Film>,
    internal var oldPersons: List<Film>) : DiffUtil.Callback() {

  override fun getOldListSize(): Int {
    return oldPersons.size
  }

  override fun getNewListSize(): Int {
    return newPersons.size
  }

  override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    return oldPersons[oldItemPosition].name === newPersons[newItemPosition].name
  }

  override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    return oldPersons[oldItemPosition].equals(newPersons[newItemPosition])
  }

  override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
    return super.getChangePayload(oldItemPosition, newItemPosition)
  }
}