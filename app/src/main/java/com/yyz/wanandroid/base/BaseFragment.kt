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
 */
abstract class BaseFragment<T : ViewBinding>(layoutId: Int) : Fragment(layoutId),
    CoroutineScope by MainScope() {
    private var _binding: T? = null

    val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = bindView()
        initData()
    }

    abstract fun initData()

    abstract fun bindView(): T

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}