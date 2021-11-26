package com.example.kanbanboardapp.util

import com.example.kanbanboardapp.model.entity.Task

interface OnTransItemListener {
    fun onTransItem(task : Task?)
}
