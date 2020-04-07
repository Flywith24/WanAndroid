package com.yyz.wanandroid.ui.home.tab.project

import android.os.Bundle
import android.view.View
import com.yyz.wanandroid.R
import com.yyz.wanandroid.common.BaseFragment
import com.yyz.wanandroid.databinding.FragmentArticleBinding

class ProjectListFragment : BaseFragment<FragmentArticleBinding>(R.layout.fragment_article) {

    override fun initBinding(view: View): FragmentArticleBinding = FragmentArticleBinding.bind(view)

    override fun initData() {
       
    }

    companion object {
        private const val ARG_PARAM1 = "param1"

        @JvmStatic
        fun newInstance(param1: String) =
            ProjectListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}