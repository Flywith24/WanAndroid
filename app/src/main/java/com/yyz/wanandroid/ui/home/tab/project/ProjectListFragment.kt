package com.yyz.wanandroid.ui.home.tab.project

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.yyz.wanandroid.R
import com.yyz.wanandroid.common.BaseFragment
import com.yyz.wanandroid.databinding.FragmentArticleBinding
import com.yyz.wanandroid.ui.home.tab.CommonListAdapter

class ProjectListFragment : BaseFragment<FragmentArticleBinding>(R.layout.fragment_article) {

    private val mAdapter by lazy { CommonListAdapter() }
    private val mViewModel by viewModels<ProjectViewModel> {
        ProjectViewModel.ArticleViewModelFactory(
            ProjectRepository.getInstance()
        )
    }

    override fun initBinding(view: View): FragmentArticleBinding = FragmentArticleBinding.bind(view)

    override fun initData(savedInstanceState: Bundle?) {
        binding.recyclerView.adapter = mAdapter
        mViewModel.getProjectList()
        /*handleData(mViewModel.projectList, {
            mAdapter.submitList(it?.datas)
        }, {
            mAdapter.submitList(emptyList())
        })*/
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