package com.example.kanbanboardapp.ui.home.done

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kanbanboardapp.model.dataBase.Repository
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModel
import com.example.kanbanboardapp.util.Constant
import com.example.kanbanboardapp.util.Constant.TAG
import com.example.kanbanboardapp.util.OnClickListener
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class DoneViewModel(private val contentDataSource: Repository) : BaseViewModel(), OnClickListener {
    private val _tasks = MutableLiveData<List<Task>?>()
    val task: LiveData<List<Task>?> = _tasks

    init {
        getToDoTask()
    }

    private fun getToDoTask() {
        contentDataSource.taskProgressFilter(Constant.DONE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                this::onGetAllTask,
                this::onError
            )
    }

    private fun deleteTask(task: Task) {
        compositeDisposable.add(
            contentDataSource.deleteTask(task)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        )
    }

    override fun onClickItem(task: Task) {
        Log.e(TAG, "onClickItemToDoViewModel :${task.task_name}")
        deleteTask(task)
    }

    private fun onError(error: Throwable) {
        Log.e(TAG, "Insert Error : ${error.message}")
    }

    private fun onGetAllTask(listOfTask: List<Task>?) {
        if (listOfTask != null) {
            _tasks.postValue(listOfTask)
        }
    }
}
