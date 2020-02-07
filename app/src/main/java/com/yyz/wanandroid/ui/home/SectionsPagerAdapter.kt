package com.yyz.wanandroid.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yyz.wanandroid.ui.home.tab.ArticleListFragment
import com.yyz.wanandroid.ui.home.tab.ProjectListFragment

private val TAB_TITLES = arrayOf(
    "最新博文",
    "最新项目"
)

/**
 * @author yyz (杨云召)
 * @date   2020/2/7
 * time   22:31
 * description
 */
class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(
    fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            ArticleListFragment.newInstance(TAB_TITLES[position])
        } else {
            ProjectListFragment.newInstance(TAB_TITLES[position])
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES[position]
    }

    override fun getCount(): Int = TAB_TITLES.size
}