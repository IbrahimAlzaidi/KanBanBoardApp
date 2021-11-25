package com.example.kanbanboardapp.ui.base

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kanbanboardapp.util.Constant
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
    protected fun onSuccess() {
        Log.d(Constant.TAG, "onComplete inserted successfully")
    }

    protected fun onError(error: Throwable) {
        Log.e(Constant.TAG, "Insert Error : ${error.message}")
    }
}
