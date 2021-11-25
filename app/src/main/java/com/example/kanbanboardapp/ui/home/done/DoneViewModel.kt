package com.example.kanbanboardapp.ui.home.done

import android.util.Log
import com.example.kanbanboardapp.model.dataBase.Repository
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModelDelete
import com.example.kanbanboardapp.util.Constant.DONE
import com.example.kanbanboardapp.util.Constant.TAG
import com.example.kanbanboardapp.util.OnClickListener

class DoneViewModel(private val contentDataSource: Repository) : BaseViewModelDelete(), OnClickListener {

    override fun onClickItem(task: Task) {
        Log.e(TAG, "onClickItemToDoViewModel :${task.task_name}")
        deleteTask(task,contentDataSource)
    }
    init {
        getTask(DONE,contentDataSource)
    }
}
