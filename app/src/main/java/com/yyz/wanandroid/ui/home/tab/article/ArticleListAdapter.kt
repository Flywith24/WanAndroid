package com.yyz.wanandroid.ui.home.tab.article

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.yyz.wanandroid.R
import com.yyz.wanandroid.data.bean.Data

/**
 * @author yyz (杨云召)
 * @date   2020/2/7
 * time   23:25
 * description
 */
class ArticleListAdapter : RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder>() {
    var mData: List<Data>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_home_list, parent, false)
        return ArticleViewHolder(
            itemView
        )
    }

    override fun getItemCount(): Int = mData?.size ?: 0

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bindData(mData?.get(position))
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: AppCompatTextView = itemView.findViewById(R.id.title)
        var description: AppCompatTextView = itemView.findViewById(R.id.description)

        fun bindData(data: Data?) {
            title.text = data?.title ?: "1"
            description.text = "3"
        }
    }
}