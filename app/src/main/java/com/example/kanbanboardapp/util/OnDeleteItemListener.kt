package com.example.kanbanboardapp.util

import com.example.kanbanboardapp.model.entity.Task

interface OnDeleteItemListener {
    fun onDeleteItem(task : Task?)
}
