package com.example.kanbanboardapp.ui.edit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kanbanboardapp.model.dataBase.Repository
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModel
import com.example.kanbanboardapp.util.Constant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class EditViewModel (private val contentDataSource: Repository, task: Task? = null): BaseViewModel() {

    val taskTitle = MutableLiveData<String>(task?.task_title)
    val taskDescription = MutableLiveData<String>(task?.task_description)
    val taskType = MutableLiveData<String>(task?.task_type)
    val taskName = MutableLiveData<String>(task?.task_name)

    private fun isValid(): Boolean {
        return (taskName.value.toString().trim().isEmpty() ||
                taskDescription.value.toString().trim().isEmpty())
    }

    fun checkTask() {
        if (!isValid()) {
            insertTask()
        }
    }

    private fun insertTask() {
        taskName.value?.let {
            compositeDisposable.add(
                contentDataSource.updateToDoTask(
                    ToDoTask(
                        it.trim(),
                        task_title = taskTitle.value.toString().trim(),
                        task_description = taskDescription.value.toString().trim(),
                        task_type = taskType.value.toString().trim(),
                        task_stats = true,
                        task_startDate = Date(),
                        task_endDate = Date(),
                    )
                )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        this::onSuccess,
                        this::onError
                    )
            )
        }
    }

    private fun onSuccess() {
        Log.d(Constant.TAG, "onComplete inserted successfully")
    }

    private fun onError(error: Throwable) {
        Log.e(Constant.TAG, "Insert Error : ${error.message}")
    }
}