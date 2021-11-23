package com.example.kanbanboardapp.ui.home

import android.util.Log
import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.FragmentHomeBinding
import com.example.kanbanboardapp.ui.base.BaseFragment
import com.example.kanbanboardapp.util.Constant.TAG
import com.example.kanbanboardapp.util.OnClickListener

class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>(R.layout.fragment_home) , OnClickListener{
    override fun getViewModel() = HomeViewModel::class.java

    override fun onStart() {
        super.onStart()
        val adapter = TaskAdapter(emptyList(),this)
        binding.myRecycler.adapter = adapter
    }

    override fun onClickItem(itemId: Long) {
        Log.i(TAG, "onClickItem: $itemId")
    }
}
