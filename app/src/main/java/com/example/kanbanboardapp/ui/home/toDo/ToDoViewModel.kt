package com.example.kanbanboardapp.ui.home.toDo

import android.util.Log
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModelDelete
import com.example.kanbanboardapp.util.Constant
import com.example.kanbanboardapp.util.Constant.IN_PROGRESS
import com.example.kanbanboardapp.util.Constant.TO_DO
import com.example.kanbanboardapp.util.OnDeleteItemListener
import com.example.kanbanboardapp.util.OnPositionItemListener

class ToDoViewModel : BaseViewModelDelete(), OnDeleteItemListener , OnPositionItemListener {

    override fun onDeleteItem(task: Task?) {
        if (task != null) {
            Log.e(Constant.TAG, "onClickItemToDoViewModel :${task.task_name}")
        }
        if (task != null) {
            deleteTask(task)
        }
    }
    init {
        getTask(TO_DO)
    }
    override fun onPositionItem(id: Long) {
        updateTask(IN_PROGRESS,id)
    }
}
