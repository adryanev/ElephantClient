package dev.adryanev.dicoding.androidpemula.ui.profil

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.adryanev.dicoding.androidpemula.R
import dev.adryanev.dicoding.androidpemula.databinding.ProfilFragmentBinding
import dev.adryanev.dicoding.androidpemula.ui.base.BaseFragment

@AndroidEntryPoint
class ProfilFragment : BaseFragment<ProfilFragmentBinding, ProfilViewModel>() {
    override val viewModel: ProfilViewModel by viewModels()
    override val layoutId: Int
        get() = R.layout.profil_fragment


}