package com.yyz.wanandroid.ui.home.tab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.yyz.wanandroid.common.DataBindingListAdapter
import com.yyz.wanandroid.common.DataBindingPagingListAdapter
import com.yyz.wanandroid.data.bean.Data
import com.yyz.wanandroid.databinding.ItemHomeListBinding

/**
 * @author yyz (杨云召)
 * @date   2020/2/7
 * time   23:25
 * description
 */

class CommonListAdapter : DataBindingPagingListAdapter<Data, ItemHomeListBinding>(object :
    DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.link == newItem.link &&
                oldItem.title == newItem.title
    }
}) {
    override fun createBinding(parent: ViewGroup): ItemHomeListBinding {
        return ItemHomeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun bind(binding: ItemHomeListBinding, item: Data?) {
        item?.let { data ->
            binding.article = data
        }
    }
}