package com.example.kanbanboardapp.util

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kanbanboardapp.ui.base.BaseAdapter


@BindingAdapter(value = ["app:items"])
fun <T> RecyclerView.setRecyclerView(items: List<T>?) {
    if (items != null) {
        (this.adapter as BaseAdapter<T>?)?.setItems(this, items)
    } else {
        (this.adapter as BaseAdapter<T>?)?.setItems(this, emptyList())
    }
}

@BindingAdapter(value = ["app:visibilityView"])
fun View.showIfTrue(value: Boolean?) {
    if (value == true) {
        this.visibility = VISIBLE
    } else {
        this.visibility = GONE
    }
}
