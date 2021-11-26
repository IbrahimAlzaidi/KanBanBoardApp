package com.example.kanbanboardapp.ui.add

import androidx.lifecycle.MutableLiveData
import com.example.kanbanboardapp.model.dataBase.Repository
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModel
import com.example.kanbanboardapp.util.Constant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class AddViewModel : BaseViewModel() {

    val taskTitle = MutableLiveData<String>()
    val taskDescription = MutableLiveData<String>()
    val taskType = MutableLiveData<String>()
    val taskName = MutableLiveData<String>()


    fun isValid(): Boolean {
        return (taskName.value.toString().trim().isEmpty() ||
                taskDescription.value.toString().trim().isEmpty())
    }


    fun insertTask() {
        compositeDisposable.add(
            contentDataSource.insertTask(
                Task(
                    task_name = taskName.value.toString().trim(),
                    task_title = taskTitle.value.toString().trim(),
                    task_description = taskDescription.value.toString().trim(),
                    task_type = taskType.value.toString().trim(),
                    task_stats = Constant.IN_PROGRESS,
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
