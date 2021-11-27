package com.example.kanbanboardapp.ui.base

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kanbanboardapp.model.dataBase.Repository
import com.example.kanbanboardapp.util.Constant
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Action
import io.reactivex.rxjava3.functions.Consumer

abstract class BaseViewModel : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()
    protected val contentDataSource = Repository()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
    protected fun onSuccess() {
        Log.d(Constant.TAG, "onComplete inserted successfully")
    }

    protected fun onError(error: Throwable){
        Log.e(Constant.TAG, "Insert Error : ${error.message}")
    }
}
