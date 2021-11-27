package com.example.kanbanboardapp.util

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.AutoCompleteTextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.TaskAdapter

@BindingAdapter(value = ["app:items"])
fun RecyclerView.setRecyclerView(items: List<Task>?) {
    if (items != null) {
        (this.adapter as TaskAdapter).setItems(items)
    } else {
        (this.adapter as TaskAdapter).setItems(emptyList())
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
