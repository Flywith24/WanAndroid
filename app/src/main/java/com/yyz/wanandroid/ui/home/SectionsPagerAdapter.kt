package com.yyz.wanandroid.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yyz.wanandroid.ui.home.tab.TabFragment

private val TAB_TITLES = arrayOf(
    "1",
    "2"
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
        return TabFragment.newInstance(TAB_TITLES[position], "newInstance")
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES[position]
    }

    override fun getCount(): Int = TAB_TITLES.size
}