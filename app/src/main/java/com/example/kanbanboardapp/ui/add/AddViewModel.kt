package com.example.kanbanboardapp.ui.add

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kanbanboardapp.model.dataBase.Repository
import com.example.kanbanboardapp.ui.base.BaseViewModel
import com.example.kanbanboardapp.util.Constant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class AddViewModel (private val contentDataSource: Repository): BaseViewModel() {

    val taskTitle = MutableLiveData<String>()
    val taskDescription = MutableLiveData<String>()
    val taskType = MutableLiveData<String>()
    val taskName = MutableLiveData<String>()

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
            compositeDisposable.add(
                contentDataSource.insertToDoTask(
                    ToDoTask(
                        task_name = taskName.value.toString().trim(),
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

    private fun onSuccess() {
        Log.d(Constant.TAG, "onComplete inserted successfully")
    }

    private fun onError(error: Throwable) {
        Log.e(Constant.TAG, "Insert Error : ${error.message}")
    }
}