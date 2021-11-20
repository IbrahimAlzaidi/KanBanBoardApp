package com.example.kanbanboardapp.ui.home

import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.FragmentHomeBinding
import com.example.kanbanboardapp.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>(R.layout.fragment_home){
    override fun getViewModel() = HomeViewModel::class.java

}
