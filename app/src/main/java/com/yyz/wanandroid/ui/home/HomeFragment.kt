package com.yyz.wanandroid.ui.home

import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.yyz.wanandroid.R
import com.yyz.wanandroid.common.BaseFragment
import com.yyz.wanandroid.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun initBinding(view: View): FragmentHomeBinding = FragmentHomeBinding.bind(view)

    override fun initData() {
        binding.viewPager.adapter = SectionsPagerAdapter(this)
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = TAB_TITLES[position]
        }.attach()
    }

    companion object {
        private val TAB_TITLES = arrayOf(
            "最新博文",
            "最新项目"
        )
    }
}