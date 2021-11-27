package com.example.kanbanboardapp.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.util.Constant.DONE
import com.example.kanbanboardapp.util.Constant.IN_PROGRESS
import com.example.kanbanboardapp.util.Constant.TO_DO
import com.example.kanbanboardapp.util.OnPositionItemListener
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

abstract class BaseViewModelDelete: BaseViewModel() , OnPositionItemListener {
    private val _tasks = MutableLiveData<List<Task>?>()
    val task: LiveData<List<Task>?> = _tasks
    private val oldTask = MutableLiveData<Task>()

    protected fun getTask(text: String) {
        contentDataSource.taskProgressFilter(text)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                this::onGetAllTask,
                this::onError
            )
    }

    protected fun deleteTask(task: Task) {
        compositeDisposable.add(
            contentDataSource.deleteTask(task)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        )
    }
    private fun updateTask(stats: String){
            contentDataSource.updateTask(
                Task(
                task_name = oldTask.value?.task_name.toString().trim(),
                    task_title = oldTask.value?.task_title.toString().trim(),
                    task_description = oldTask.value?.task_description.toString().trim(),
                    task_type = oldTask.value?.task_type.toString().trim(),
                    task_stats = stats,
                    task_startDate = Date(),
                    task_endDate = Date()
            ))
    }

    private fun onGetAllTask(listOfTask: List<Task>?) {
        if (listOfTask != null) {
            _tasks.postValue(listOfTask)
        }
    }
    override fun onPositionItem(position: Int?, item: Task) {
        oldTask.postValue(item)
        when (position){
            0 -> updateTask(TO_DO)
            1 -> updateTask(IN_PROGRESS)
            else -> updateTask(DONE)
        }
    }
}