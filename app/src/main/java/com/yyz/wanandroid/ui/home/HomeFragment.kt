package com.yyz.wanandroid.ui.home

import android.view.View
import androidx.fragment.app.viewModels
import com.yyz.wanandroid.R
import com.yyz.wanandroid.base.BaseFragment
import com.yyz.wanandroid.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun initBinding(view: View): FragmentHomeBinding = FragmentHomeBinding.bind(view)

    override fun initData() {
        binding.viewPager.adapter = SectionsPagerAdapter(parentFragmentManager)
        binding.tabs.setupWithViewPager(binding.viewPager)
    }

}