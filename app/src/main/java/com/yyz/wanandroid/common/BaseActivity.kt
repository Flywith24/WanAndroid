package com.yyz.wanandroid.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * @author yyz (杨云召)
 * @date   2020-02-07
 * time   14:18
 * description
 * Activity基类
 */
abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {
    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initBinding()
        setContentView(binding.root)
        initView(savedInstanceState)
    }

    /**
     * 初始化[binding]
     */
    abstract fun initBinding(): T

    abstract fun initView(savedInstanceState: Bundle?)

}