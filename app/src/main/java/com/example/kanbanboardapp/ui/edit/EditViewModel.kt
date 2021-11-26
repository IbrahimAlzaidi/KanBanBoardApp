package com.example.kanbanboardapp.ui.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kanbanboardapp.model.dataBase.Repository
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModel
import com.example.kanbanboardapp.util.Event
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class EditViewModel (task: Task? = null): BaseViewModel() {

    val taskTitle = MutableLiveData<String>(task?.task_title)
    val taskDescription = MutableLiveData<String>(task?.task_description)
    val taskType = MutableLiveData<String>(task?.task_type)
    val taskName = MutableLiveData<String>(task?.task_name)

    private val _navigateToDetails = MutableLiveData<Event<String>>()

    val navigateToDetails : LiveData<Event<String>>
        get() = _navigateToDetails

    private fun userClicksOnButton(itemId: String) {
        _navigateToDetails.value = Event(itemId)
    }


    fun isValid(): Boolean {
        return (taskName.value.toString().trim().isEmpty() ||
                taskDescription.value.toString().trim().isEmpty())
    }

    fun checkTask() {
        if (!isValid()) {
            updateTask()
        }
    }

    fun updateTask() {
            compositeDisposable.add(
                contentDataSource.updateTask(
                    Task(
                        task_name = taskName.value.toString().trim(),
                        task_title = taskTitle.value.toString().trim(),
                        task_description = taskDescription.value.toString().trim(),
                        task_type = taskType.value.toString().trim(),
                        task_stats = "ToDo",
                        task_startDate = Date(),
                        task_endDate = Date(),
                        task_id = 1L
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
