package com.yyz.wanandroid.ui.home.tab

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.yyz.wanandroid.R
import com.yyz.wanandroid.base.BaseFragment
import com.yyz.wanandroid.data.api.RetrofitClient
import com.yyz.wanandroid.databinding.FragmentArticleBinding
import kotlinx.coroutines.launch

class ArticleListFragment : BaseFragment<FragmentArticleBinding>(R.layout.fragment_article) {
    private var param1: String? = null
    private val mAdapter by lazy { ArticleListAdapter() }

    override fun initBinding(view: View): FragmentArticleBinding = FragmentArticleBinding.bind(view)

    override fun initData() {
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }

        Log.i("yyz1", "start")
        binding.recyclerView.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
        launch {
            try {
                val homeArticleList = RetrofitClient.api.getHomeArticleList(0)
                Log.i("yyz1", "${homeArticleList.data?.datas}")
                mAdapter.mData = homeArticleList.data?.datas
                mAdapter.notifyDataSetChanged()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        Log.i("yyz1", "end")

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