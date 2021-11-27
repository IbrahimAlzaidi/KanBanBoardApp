package com.example.kanbanboardapp.ui.home.done

import android.util.Log
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModelDelete
import com.example.kanbanboardapp.util.Constant.DONE
import com.example.kanbanboardapp.util.Constant.TAG
import com.example.kanbanboardapp.util.OnDeleteItemListener
import com.example.kanbanboardapp.util.OnPositionItemListener

class DoneViewModel : BaseViewModelDelete(), OnDeleteItemListener {

    override fun onDeleteItem(task: Task?) {
        if (task != null) {
            Log.e(TAG, "onClickItemToDoViewModel :${task.task_name}")
        }
        if (task != null) {
            deleteTask(task)
        }
    }
    init {
        getTask(DONE)
    }
}
