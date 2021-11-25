package com.example.kanbanboardapp.ui.home

import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseAdapter
import com.example.kanbanboardapp.util.OnClickListener

class TaskAdapter(items: List<Task>, listener: OnClickListener?) :
    BaseAdapter<Task>(items, listener, R.layout.task_item)
