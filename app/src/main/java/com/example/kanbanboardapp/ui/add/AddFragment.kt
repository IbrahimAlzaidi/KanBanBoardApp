package com.example.kanbanboardapp.ui.add

import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.FragmentAddBinding
import com.example.kanbanboardapp.ui.base.BaseFragment

class AddFragment : BaseFragment<FragmentAddBinding, AddViewModel>(R.layout.fragment_add){
    override fun getViewModel() = AddViewModel::class.java
}