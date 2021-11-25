package com.example.kanbanboardapp.ui.home.inProgress

import android.util.Log
import com.example.kanbanboardapp.model.dataBase.Repository
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModelDelete
import com.example.kanbanboardapp.util.Constant
import com.example.kanbanboardapp.util.Constant.IN_PROGRESS
import com.example.kanbanboardapp.util.OnClickListener

class InProgressViewModel(private val contentDataSource: Repository): BaseViewModelDelete(),OnClickListener {

    override fun onClickItem(task: Task) {
        Log.e(Constant.TAG, "onClickItemToDoViewModel :${task.task_name}")
        deleteTask(task,contentDataSource)
    }
    init {
        getTask(IN_PROGRESS,contentDataSource)
    }
}
