package com.yyz.wanandroid.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.yyz.wanandroid.R
import com.yyz.wanandroid.common.BaseFragment
import com.yyz.wanandroid.databinding.FragmentDashboardBinding

class DashboardFragment : BaseFragment<FragmentDashboardBinding>(R.layout.fragment_dashboard) {
    private val dashboardViewModel by viewModels<DashboardViewModel>()

    override fun initBinding(view: View): FragmentDashboardBinding =
        FragmentDashboardBinding.bind(view)

    override fun initData(savedInstanceState: Bundle?) {
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            binding.tvDashboard.text = it
        }
    }
}