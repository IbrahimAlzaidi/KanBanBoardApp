package com.example.kanbanboardapp.ui.home

import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseAdapter
import com.example.kanbanboardapp.util.OnDeleteItemListener
import com.example.kanbanboardapp.util.OnTransItemListener

class TaskAdapter(
    items: List<Task>,
    listener: OnDeleteItemListener?,
    transListener: OnTransItemListener?
) :
    BaseAdapter<Task>(items, transListener, listener, R.layout.task_item)
