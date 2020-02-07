package com.yyz.wanandroid.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

/**
 * @author yyz (杨云召)
 * @date   2020-02-07
 * time   14:18
 * description
 * Activity基类
 */
abstract class BaseActivity<T : ViewBinding> : AppCompatActivity(), CoroutineScope by MainScope() {
    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initBinding()
        setContentView(binding.root)
        initView()
    }

    /**
     * 初始化[binding]
     */
    abstract fun initBinding(): T

    abstract fun initView()

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}