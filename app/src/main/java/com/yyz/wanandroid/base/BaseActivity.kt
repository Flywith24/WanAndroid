package com.yyz.wanandroid.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

/**
 * @author yyz (杨云召)
 * @date   2020-02-07
 * time   14:18
 * description
 */
abstract class BaseActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setContentView())
        initView()
    }

    abstract fun setContentView(): Int
    abstract fun initView()

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}