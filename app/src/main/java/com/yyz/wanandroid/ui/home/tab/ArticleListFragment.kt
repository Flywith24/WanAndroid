package com.yyz.wanandroid.ui.home.tab

import android.os.Bundle
import android.view.View
import com.yyz.wanandroid.R
import com.yyz.wanandroid.base.BaseFragment
import com.yyz.wanandroid.databinding.FragmentArticleBinding

class ArticleListFragment : BaseFragment<FragmentArticleBinding>(R.layout.fragment_article) {
    private var param1: String? = null

    override fun initBinding(view: View): FragmentArticleBinding = FragmentArticleBinding.bind(view)

    override fun initData() {
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
        binding.tvContent.text = param1
    }

    companion object {
        private const val ARG_PARAM1 = "param1"

        @JvmStatic
        fun newInstance(param1: String) =
            ArticleListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}