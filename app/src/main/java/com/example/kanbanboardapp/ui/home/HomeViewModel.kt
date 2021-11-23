package com.example.kanbanboardapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kanbanboardapp.model.dataBase.Repository
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModel
import com.example.kanbanboardapp.util.Constant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class HomeViewModel(private val contentDataSource: Repository) : BaseViewModel() {

    val taskTitle = MutableLiveData<String>()
    val taskDescription = MutableLiveData<String>()
    val taskType = MutableLiveData<String>()
    val taskName = MutableLiveData<String>()

    private val _tasks = MutableLiveData<List<Task>?>()
    val task: LiveData<List<Task>?> = _tasks

    init {
        getAllTask()
    }

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
                contentDataSource.insertTask(
                    Task(
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

    private fun getAllTask() {
        contentDataSource.getAllTask()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                this::onGetAllTask,
                this::onError
            )
    }

    private fun onSuccess() {
        Log.d(Constant.TAG, "onComplete inserted successfully")
    }

    private fun onError(error: Throwable) {
        Log.e(Constant.TAG, "Insert Error : ${error.message}")
    }

    private fun onGetAllTask(listOfTask: List<Task>?) {
        if (listOfTask != null){
        _tasks.postValue(listOfTask)
        }
    }
}
