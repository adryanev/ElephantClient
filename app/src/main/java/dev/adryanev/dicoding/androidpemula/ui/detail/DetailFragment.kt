package dev.adryanev.dicoding.androidpemula.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import dev.adryanev.dicoding.androidpemula.R
import dev.adryanev.dicoding.androidpemula.databinding.DetailFragmentBinding
import dev.adryanev.dicoding.androidpemula.ui.base.BaseFragment

@AndroidEntryPoint
class DetailFragment : BaseFragment<DetailFragmentBinding, DetailViewModel>() {
    override val viewModel: DetailViewModel by viewModels()
    override val layoutId: Int
        get() = R.layout.detail_fragment

    private val args : DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.apply {
            args.elephant.let {
                elephant.value = it
            }
        }
    }

}