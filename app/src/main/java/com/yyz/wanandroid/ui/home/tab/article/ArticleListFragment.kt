package com.yyz.wanandroid.ui.home.tab.article

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.yyz.wanandroid.R
import com.yyz.wanandroid.common.BaseFragment
import com.yyz.wanandroid.common.RequestState
import com.yyz.wanandroid.databinding.FragmentArticleBinding

class ArticleListFragment : BaseFragment<FragmentArticleBinding>(R.layout.fragment_article) {
    private var param1: String? = null
    private val mAdapter by lazy { ArticleListAdapter() }
    private val mViewModel by viewModels<ArticleViewModel> {
        ArticleViewModel.ArticleViewModelFactory(
            ArticleRepository.getInstance()
        )
    }

    override fun initBinding(view: View): FragmentArticleBinding = FragmentArticleBinding.bind(view)

    override fun initData() {
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }

        binding.recyclerView.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
        mViewModel.getHomeArticleList()
        mViewModel.articleList.observe(viewLifecycleOwner) {
            when (it) {
                is RequestState.Success -> mAdapter.mData = it.data?.datas
                else -> mAdapter.mData = emptyList()
            }
            mAdapter.notifyDataSetChanged()
        }
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