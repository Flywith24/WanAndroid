package com.yyz.wanandroid.ui.wxarticels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WxArticlesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is WxArticles Fragment"
    }
    val text: LiveData<String> = _text
}