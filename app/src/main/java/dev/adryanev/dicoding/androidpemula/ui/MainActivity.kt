package dev.adryanev.dicoding.androidpemula.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.adryanev.dicoding.androidpemula.R
import dev.adryanev.dicoding.androidpemula.databinding.MainActivityBinding
import dev.adryanev.dicoding.androidpemula.ui.base.BaseActivity
import dev.adryanev.dicoding.androidpemula.ui.base.BaseViewModel

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding, BaseViewModel>() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val toolbar = viewBinding.toolbarMovie

        navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
           setOf(R.id.mainFragment)
        )


        navController.let {
            toolbar.setupWithNavController(it, appBarConfiguration)
            it.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.splashFragment -> {
                        toolbar.visibility = View.GONE
                    }
                    else -> {
                        toolbar.visibility = View.VISIBLE

                    }
                }
            }
        }
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override val viewModel: BaseViewModel by viewModels()
    override val layoutId: Int
        get() = R.layout.main_activity



}