package com.example.kanbanboardapp.ui.home.inProgress

import android.util.Log
import com.example.kanbanboardapp.model.dataBase.Repository
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModelDelete
import com.example.kanbanboardapp.util.Constant
import com.example.kanbanboardapp.util.Constant.IN_PROGRESS
import com.example.kanbanboardapp.util.OnDeleteItemListener

class InProgressViewModel: BaseViewModelDelete(),OnDeleteItemListener {

    override fun onDeleteItem(task: Task?) {
        if (task != null) {
            Log.e(Constant.TAG, "onClickItemToDoViewModel :${task.task_name}")
        }
        if (task != null) {
            deleteTask(task,contentDataSource)
        }
    }
    init {
        getTask(IN_PROGRESS,contentDataSource)
    }
}
