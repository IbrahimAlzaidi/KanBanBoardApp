package com.example.kanbanboardapp.ui.home.toDo

import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModelDelete
import com.example.kanbanboardapp.util.Constant.IN_PROGRESS
import com.example.kanbanboardapp.util.Constant.TO_DO
import com.example.kanbanboardapp.util.OnDeleteItemListener
import com.example.kanbanboardapp.util.OnPositionItemListener

class ToDoViewModel : BaseViewModelDelete(), OnDeleteItemListener , OnPositionItemListener {

    override fun onDeleteItem(task: Task?) {
            deleteTask(task)
    }
    init {
        getTask(TO_DO)
    }
    override fun onPositionItem(id: Long) {
        updateTask(IN_PROGRESS,id)
    }
}
