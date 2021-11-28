package com.example.kanbanboardapp.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kanbanboardapp.model.entity.Task
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseViewModelDelete : BaseViewModel() {
    private val _tasks = MutableLiveData<List<Task?>>()
    val task: LiveData<List<Task?>> = _tasks

    protected fun getTask(text: String) {
        contentDataSource.taskProgressFilter(text)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                this::onGetAllTask,
                this::onError
            )
    }

    protected fun deleteTask(task: Task?) {
        compositeDisposable.add(
            contentDataSource.deleteTask(task)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        )
    }

    protected fun updateTask(stats: String, id: Long) {
        compositeDisposable.add(
            contentDataSource.taskUpdate(stats, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        )
    }

    private fun onGetAllTask(listOfTask: List<Task?>) {
            _tasks.postValue(listOfTask)
    }
}