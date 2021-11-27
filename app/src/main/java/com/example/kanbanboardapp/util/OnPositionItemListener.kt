package com.example.kanbanboardapp.util

import com.example.kanbanboardapp.model.entity.Task

interface OnPositionItemListener {
    fun onPositionItem(position : Int?, item: Task)
}
