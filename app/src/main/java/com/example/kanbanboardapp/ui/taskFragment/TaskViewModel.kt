package com.example.kanbanboardapp.ui.taskFragment

import com.example.kanbanboardapp.model.dataBase.Repository
import com.example.kanbanboardapp.ui.base.BaseViewModel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kanbanboardapp.model.entity.User
import com.example.kanbanboardapp.util.Constant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class TaskViewModel(val contentDataSource: Repository) :BaseViewModel() {
    val userName = MutableLiveData<String>()
    val userPassword = MutableLiveData<String>()
    val userEmail = MutableLiveData<String>()


    private fun isValid(): Boolean {
        return (userName.value.toString().trim().isEmpty() ||
                userPassword.value.toString().trim().isEmpty() ||
                userEmail.value.toString().trim().isEmpty())
    }

    fun checkTask() {
        if (!isValid()) {
            addUser()
        }
    }

    private fun addUser() {
        userName.value?.let {
            compositeDisposable.add(
                contentDataSource.insertUser(
                    User(
                        user_name = userName.value.toString().trim(),
                        user_password = userPassword.value.toString().trim(),
                        user_email = userEmail.value.toString().trim(),
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

    private fun onSuccess() {
        Log.d(Constant.TAG, "onComplete inserted successfully")
    }

    private fun onError(error: Throwable) {
        Log.e(Constant.TAG, "Insert Error : ${error.message}")
    }
}
