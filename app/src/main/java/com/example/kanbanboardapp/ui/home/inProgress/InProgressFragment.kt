package com.example.kanbanboardapp.ui.home.inProgress

import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.FragmentInProgressBinding
import com.example.kanbanboardapp.ui.base.BaseFragment

class InProgressFragment : BaseFragment<FragmentInProgressBinding, InProgressViewModel>(R.layout.fragment_in_progress){
    override fun getViewModel() = InProgressViewModel::class.java
}