package com.example.kanbanboardapp.ui.edit

import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.FragmentAddBinding
import com.example.kanbanboardapp.databinding.FragmentEditBinding
import com.example.kanbanboardapp.ui.base.BaseFragment

class EditFragment : BaseFragment<FragmentEditBinding, EditViewModel>(R.layout.fragment_edit){
    override fun getViewModel() = EditViewModel::class.java
}