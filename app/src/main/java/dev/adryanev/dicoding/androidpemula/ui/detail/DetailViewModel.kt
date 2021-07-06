package dev.adryanev.dicoding.androidpemula.ui.detail

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.adryanev.dicoding.androidpemula.data.entities.Elephant
import dev.adryanev.dicoding.androidpemula.ui.base.BaseViewModel

class DetailViewModel : BaseViewModel() {

    val elephant = MutableLiveData<Elephant>()
}