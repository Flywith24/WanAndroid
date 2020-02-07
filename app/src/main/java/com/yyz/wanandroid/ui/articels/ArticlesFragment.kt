package com.yyz.wanandroid.ui.articels

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.yyz.wanandroid.R
import com.yyz.wanandroid.base.BaseFragment
import com.yyz.wanandroid.databinding.FragmentArticlesBinding

class ArticlesFragment : BaseFragment<FragmentArticlesBinding>(R.layout.fragment_articles) {

    private val articlesViewModel by viewModels<ArticlessViewModel>()

    override fun initBinding(view: View): FragmentArticlesBinding = FragmentArticlesBinding.bind(view)

    override fun initData() {
        articlesViewModel.text.observe(viewLifecycleOwner) {
            binding.tvArticles.text = it
        }
    }
}