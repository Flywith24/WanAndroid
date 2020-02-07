package com.yyz.wanandroid.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

/**
 * @author yyz (杨云召)
 * @date   2020-02-07
 * time   14:26
 * description
 * Fragment基类,使用ViewBinding
 * 构造传入布局文件
 * 依据ViewBinding官方使用文档，[onDestroyView]中置空[_binding]
 */
abstract class BaseFragment<T : ViewBinding>(layoutId: Int) : Fragment(layoutId),
    CoroutineScope by MainScope() {
    private var _binding: T? = null

    val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = initBinding(view)
        initData()
    }

    /**
     * 初始化 [_binding]
     */
    abstract fun initBinding(view: View): T

    abstract fun initData()

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}