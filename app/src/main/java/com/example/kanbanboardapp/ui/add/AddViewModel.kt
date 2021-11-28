package com.example.kanbanboardapp.ui.add

import androidx.lifecycle.MutableLiveData
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseViewModel
import com.example.kanbanboardapp.util.Constant.TO_DO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class AddViewModel : BaseViewModel() {

    val taskTitle = MutableLiveData<String?>()
    val taskDescription = MutableLiveData<String?>()
    val taskType = MutableLiveData<String?>()
    val taskName = MutableLiveData<String?>()


    fun isValid(): Boolean {
        return taskTitle.value != null
    }

    fun insertTask() {
        compositeDisposable.add(
            contentDataSource.insertTask(
                Task(
                    task_name = taskName.value,
                    task_title = taskTitle.value,
                    task_description = taskDescription.value,
                    task_type = taskType.value,
                    task_stats = TO_DO,
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
