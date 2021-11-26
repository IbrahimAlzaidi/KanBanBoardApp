package com.example.kanbanboardapp.ui.edit

import androidx.navigation.fragment.navArgs
import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.FragmentEditBinding
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.add.AddFragmentDirections
import com.example.kanbanboardapp.ui.base.BaseFragment
import com.example.kanbanboardapp.util.OnTransItemListener

class EditFragment : BaseFragment<FragmentEditBinding, EditViewModel>(R.layout.fragment_edit){
    override fun getViewModel() = EditViewModel::class.java

    val args : EditFragmentArgs by navArgs()

    override fun onStart() {
        super.onStart()
    }
}
