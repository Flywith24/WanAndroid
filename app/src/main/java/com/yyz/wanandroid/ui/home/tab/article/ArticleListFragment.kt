package com.yyz.wanandroid.ui.home.tab.article

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.yyz.wanandroid.R
import com.yyz.wanandroid.common.BaseFragment
import com.yyz.wanandroid.databinding.FragmentArticleBinding
import com.yyz.wanandroid.ui.home.tab.AppDatabase
import com.yyz.wanandroid.ui.home.tab.CommonListAdapter

class ArticleListFragment : BaseFragment<FragmentArticleBinding>(R.layout.fragment_article) {

    private val mAdapter by lazy { CommonListAdapter() }
    private val mViewModel by viewModels<ArticleViewModel> {
        ArticleViewModel.ArticleViewModelFactory(
            ArticleRepository.getInstance(AppDatabase.getInstance(requireContext().applicationContext).articleDao())
        )
    }

    override fun initBinding(view: View): FragmentArticleBinding = FragmentArticleBinding.bind(view)

    override fun initData() {
        binding.recyclerView.adapter = mAdapter
        mViewModel.getHomeArticleList()

        handleData(mViewModel.articleList, {
            mAdapter.submitList(it)
        }, {
            mAdapter.submitList(emptyList())
        })
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