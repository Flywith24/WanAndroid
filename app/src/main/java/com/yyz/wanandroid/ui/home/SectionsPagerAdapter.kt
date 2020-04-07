package com.yyz.wanandroid.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yyz.wanandroid.ui.home.tab.article.ArticleListFragment
import com.yyz.wanandroid.ui.home.tab.project.ProjectListFragment

/**
 * @author yyz (杨云召)
 * @date   2020/2/7
 * time   22:31
 * description
 */
class SectionsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = when (position) {
        1 -> ProjectListFragment()
        else -> ArticleListFragment()
    }
}