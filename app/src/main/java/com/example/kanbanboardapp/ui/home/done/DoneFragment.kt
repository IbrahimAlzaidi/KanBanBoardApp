package com.example.kanbanboardapp.ui.home.done

import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.FragmentDoneBinding
import com.example.kanbanboardapp.ui.base.BaseFragment

class DoneFragment : BaseFragment<FragmentDoneBinding, DoneViewModel>(R.layout.fragment_done){
    override fun getViewModel() = DoneViewModel::class.java
}