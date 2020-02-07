package com.yyz.wanandroid.ui.home.tab

import android.os.Bundle
import android.view.View
import com.yyz.wanandroid.R
import com.yyz.wanandroid.base.BaseFragment
import com.yyz.wanandroid.databinding.FragmentTabBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class TabFragment : BaseFragment<FragmentTabBinding>(R.layout.fragment_tab) {
    private var param1: String? = null
    private var param2: String? = null

    override fun initBinding(view: View): FragmentTabBinding = FragmentTabBinding.bind(view)

    override fun initData() {
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        binding.tvContent.text = param1 + param2
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TabFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}