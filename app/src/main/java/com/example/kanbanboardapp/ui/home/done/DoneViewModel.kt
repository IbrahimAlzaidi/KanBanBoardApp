package com.example.kanbanboardapp.ui.home.done

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kanbanboardapp.model.dataBase.Repository
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModel
import com.example.kanbanboardapp.util.Constant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class DoneViewModel(private val contentDataSource: Repository): BaseViewModel() {
    private val _tasks = MutableLiveData<List<Task>?>()
    val task: LiveData<List<Task>?> = _tasks

    init {
        getToDoTask()
    }

    private fun getToDoTask() {
        contentDataSource.getAllTask()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                this::onGetAllTask,
                this::onError
            )
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