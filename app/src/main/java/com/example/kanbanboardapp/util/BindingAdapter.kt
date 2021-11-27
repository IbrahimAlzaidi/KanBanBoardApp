package com.example.kanbanboardapp.util

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.ui.base.BaseAdapter
import com.example.kanbanboardapp.ui.base.BaseFragment
import com.example.kanbanboardapp.util.Constant.DONE
import com.example.kanbanboardapp.util.Constant.IN_PROGRESS
import com.example.kanbanboardapp.util.Constant.TO_DO


@BindingAdapter(value = ["app:items"])
fun <T> RecyclerView.setRecyclerView(items: List<T>?) {
    if (items != null) {
        (this.adapter as BaseAdapter<T>?)?.setItems(items)
    } else {
        (this.adapter as BaseAdapter<T>?)?.setItems(emptyList())
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

@BindingAdapter(value = ["app:customAdapterSpinner"])
fun View.setAdapter(string: String?){
    val item = listOf(TO_DO, IN_PROGRESS, DONE)
    val adapter = ArrayAdapter(this.context, R.layout.list_item, item)
    (this as? AutoCompleteTextView)?.setAdapter(adapter)
}
