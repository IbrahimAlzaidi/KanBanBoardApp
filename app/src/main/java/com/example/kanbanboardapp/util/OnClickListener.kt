package com.example.kanbanboardapp.util

import com.example.kanbanboardapp.model.entity.Task

interface OnClickListener {
    fun onClickItem(task : Task)
}
