package com.yyz.wanandroid.ui.wxarticels

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.yyz.wanandroid.R
import com.yyz.wanandroid.common.BaseFragment
import com.yyz.wanandroid.databinding.FragmentWxarticlesBinding

class WxArticlesFragment : BaseFragment<FragmentWxarticlesBinding>(R.layout.fragment_wxarticles) {

    private val articlesViewModel by viewModels<WxArticlesViewModel>()

    override fun initBinding(view: View): FragmentWxarticlesBinding = FragmentWxarticlesBinding.bind(view)

    override fun initData(savedInstanceState: Bundle?) {
        articlesViewModel.text.observe(viewLifecycleOwner) {
            binding.tvArticles.text = it
        }
    }
}