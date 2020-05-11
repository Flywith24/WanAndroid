package com.yyz.wanandroid.utils

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * @author yyz (杨云召)
 * @date   2020/5/11
 * time   11:20
 * description
 */
@BindingAdapter("app:isVisible")
fun showHide(view: View, show: Boolean) {
    view.visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter("app:isSelected")
fun setSelected(view: View, isSelected: Boolean) {
    if (view.isSelected != isSelected) {
        view.isSelected = isSelected
    }
}