package com.yyz.wanandroid.ui.home.tab.article

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.yyz.wanandroid.R
import com.yyz.wanandroid.common.BaseFragment
import com.yyz.wanandroid.databinding.FragmentArticleBinding
import com.yyz.wanandroid.ui.home.tab.AppDatabase
import com.yyz.wanandroid.ui.home.tab.CommonListAdapter

class ArticleListFragment : BaseFragment<FragmentArticleBinding>(R.layout.fragment_article) {

    private val mAdapter by lazy { CommonListAdapter() }
    private val mViewModel by viewModels<ArticleViewModel> {
        ArticleViewModel.ArticleViewModelFactory(
            ArticleRepository.getInstance(
                lifecycleScope,
                AppDatabase.getInstance(
                    requireContext().applicationContext
                ).articleDao()
            )
        )
    }

    override fun initBinding(view: View): FragmentArticleBinding = FragmentArticleBinding.bind(view)

    override fun initData(savedInstanceState: Bundle?) {
        binding.recyclerView.adapter = mAdapter
        mViewModel.getHomeArticleList()
        mViewModel.articleList.observe(viewLifecycleOwner, Observer {
            mAdapter.submitList(it)
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