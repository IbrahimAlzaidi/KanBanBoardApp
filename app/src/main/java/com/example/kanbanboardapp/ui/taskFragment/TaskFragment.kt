package com.example.kanbanboardapp.ui.taskFragment

import android.util.Log
import androidx.navigation.fragment.navArgs
import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.FragmentTaskBinding
import com.example.kanbanboardapp.ui.base.BaseFragment
import com.example.kanbanboardapp.util.Constant.TAG


class TaskFragment : BaseFragment<FragmentTaskBinding,TaskViewModel>(R.layout.fragment_task){

    override fun getViewModel(): Class<TaskViewModel> = TaskViewModel::class.java

    private val args : TaskFragmentArgs by navArgs()

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: ${args.taskId}")
    }
}
