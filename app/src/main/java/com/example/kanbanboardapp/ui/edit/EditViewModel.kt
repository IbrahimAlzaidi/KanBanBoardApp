package com.example.kanbanboardapp.ui.edit

import androidx.lifecycle.MutableLiveData
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class EditViewModel(private val task: Task? = null) : BaseViewModel() {

    val taskTitle = MutableLiveData<String>(task?.task_title)
    val taskDescription = MutableLiveData<String>(task?.task_description)
    val taskType = MutableLiveData<String>(task?.task_type)
    val taskName = MutableLiveData<String>(task?.task_name)


    fun isValid(): Boolean {
        return taskTitle.value != null
    }

    fun updateTask() {
            compositeDisposable.add(
                contentDataSource.updateTask(
                    listOf(task?.let {
                        Task(
                            task_name = taskName.value?.trim(),
                            task_title = taskTitle.value?.trim(),
                            task_description = taskDescription.value?.trim(),
                            task_type = taskType.value?.trim(),
                            task_stats = task.task_stats,
                            task_startDate = Date(),
                            task_endDate = Date(),
                            task_id = it.task_id
                        )
                    }
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
