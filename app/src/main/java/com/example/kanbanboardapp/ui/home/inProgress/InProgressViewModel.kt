package com.example.kanbanboardapp.ui.home.inProgress

import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModelDelete
import com.example.kanbanboardapp.util.Constant.DONE
import com.example.kanbanboardapp.util.Constant.IN_PROGRESS
import com.example.kanbanboardapp.util.OnDeleteItemListener
import com.example.kanbanboardapp.util.OnPositionItemListener

class InProgressViewModel: BaseViewModelDelete(),OnDeleteItemListener , OnPositionItemListener{

    override fun onDeleteItem(task: Task?) {
            deleteTask(task)
    }
    init {
        getTask(IN_PROGRESS)
    }
    override fun onPositionItem(id: Long) {
        updateTask(DONE,id)
    }
}
