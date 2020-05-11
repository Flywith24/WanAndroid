package com.yyz.wanandroid.common

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @author yyz (杨云召)
 * @date   2020/5/11
 * time   10:38
 * description
 */
class DataBindingViewHolder<out T : ViewDataBinding> constructor(val binding: T) :
    RecyclerView.ViewHolder(binding.root)