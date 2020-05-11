package com.yyz.wanandroid.common

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class DataBindingPagingListAdapter<T, V : ViewDataBinding>(
    diffCallback: DiffUtil.ItemCallback<T>
) : PagedListAdapter<T, DataBindingViewHolder<V>>(
    AsyncDifferConfig.Builder<T>(diffCallback)
        .build()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<V> {
        val binding = createBinding(parent)
        return DataBindingViewHolder(binding)
    }

    protected abstract fun createBinding(parent: ViewGroup): V

    override fun onBindViewHolder(holder: DataBindingViewHolder<V>, position: Int) {
        bind(holder.binding, getItem(position))
        holder.binding.executePendingBindings()
    }

    protected abstract fun bind(binding: V, item: T?)
}
