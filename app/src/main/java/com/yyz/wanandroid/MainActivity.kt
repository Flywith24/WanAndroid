package com.yyz.wanandroid


import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.yyz.wanandroid.common.BaseActivity
import com.yyz.wanandroid.common.setupWithNavController
import com.yyz.wanandroid.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private var currentNavController: LiveData<NavController>? = null

    override fun initBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(R.navigation.home, R.navigation.project, R.navigation.wx)

        val controller = binding.navView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.home, R.id.project, R.id.wx)
        )
        controller.observe(this, Observer { navController ->
            setupActionBarWithNavController(navController, appBarConfiguration)
        })
        currentNavController = controller

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
