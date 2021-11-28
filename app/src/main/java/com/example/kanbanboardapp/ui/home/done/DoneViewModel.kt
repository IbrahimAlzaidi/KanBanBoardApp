package com.example.kanbanboardapp.ui.home.done

import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModelDelete
import com.example.kanbanboardapp.util.Constant.DONE
import com.example.kanbanboardapp.util.Constant.TO_DO
import com.example.kanbanboardapp.util.OnDeleteItemListener
import com.example.kanbanboardapp.util.OnPositionItemListener

class DoneViewModel : BaseViewModelDelete(), OnDeleteItemListener, OnPositionItemListener {

    override fun onDeleteItem(task: Task?) {
            deleteTask(task)
    }
    init {
        getTask(DONE)
    }

    override fun onPositionItem(id: Long) {
        updateTask(TO_DO,id)
    }
}
