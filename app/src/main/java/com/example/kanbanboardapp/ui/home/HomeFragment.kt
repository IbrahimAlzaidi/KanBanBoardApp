package com.example.kanbanboardapp.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.FragmentHomeBinding
import com.example.kanbanboardapp.ui.base.BaseFragment
import com.example.kanbanboardapp.ui.home.done.DoneFragment
import com.example.kanbanboardapp.ui.home.inProgress.InProgressFragment
import com.example.kanbanboardapp.ui.home.toDo.ToDoFragment
import com.example.kanbanboardapp.util.ViewPager
import com.example.kanbanboardapp.util.ViewPagerTransitions

class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>(R.layout.fragment_home) {
    override fun getViewModel() = HomeViewModel::class.java

    override fun onStart() {
        super.onStart()
        val fragmentList = listOf(
            ToDoFragment(),
            InProgressFragment(),
            DoneFragment(),
        )
        initViewPager(fragmentList,binding.homeViewPager)
    }

    private fun initViewPager(fragmentsList: List<Fragment>, viewPager: ViewPager2) {
        val standingPagerAdapterView = this.activity?.let { ViewPager(it, fragmentsList) }
        viewPager.adapter = standingPagerAdapterView
        viewPager.setPageTransformer(ViewPagerTransitions())
    }
}
