package dev.adryanev.dicoding.androidpemula.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dev.adryanev.dicoding.androidpemula.R
import dev.adryanev.dicoding.androidpemula.databinding.SplashFragmentBinding
import dev.adryanev.dicoding.androidpemula.ui.base.BaseFragment
import dev.adryanev.dicoding.androidpemula.ui.base.BaseViewModel
import dev.adryanev.dicoding.androidpemula.ui.base.getNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashFragmentBinding, BaseViewModel>() {

    override val viewModel: BaseViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.splash_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(2000)
            navigateToMain()
        }
    }

    private fun navigateToMain() {
        getNavController()?.navigate(SplashFragmentDirections.actionSplashFragmentToMainFragment())
    }
}