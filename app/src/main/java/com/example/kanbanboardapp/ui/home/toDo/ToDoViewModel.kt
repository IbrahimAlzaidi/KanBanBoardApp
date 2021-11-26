package com.example.kanbanboardapp.ui.home.toDo

import android.util.Log
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModelDelete
import com.example.kanbanboardapp.util.Constant
import com.example.kanbanboardapp.util.Constant.TO_DO
import com.example.kanbanboardapp.util.OnDeleteItemListener

class ToDoViewModel : BaseViewModelDelete(), OnDeleteItemListener {

    override fun onDeleteItem(task: Task?) {
        if (task != null) {
            Log.e(Constant.TAG, "onClickItemToDoViewModel :${task.task_name}")
        }
        if (task != null) {
            deleteTask(task,contentDataSource)
        }
    }
    init {
        getTask(TO_DO,contentDataSource)
    }
}
