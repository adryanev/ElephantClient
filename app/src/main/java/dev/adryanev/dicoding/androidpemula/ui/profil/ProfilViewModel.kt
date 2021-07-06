package dev.adryanev.dicoding.androidpemula.ui.profil

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dev.adryanev.dicoding.androidpemula.ui.base.BaseViewModel

class ProfilViewModel : BaseViewModel() {

    val name: LiveData<String>
    get() = liveData { emit("Adryan Eka Vandra") }
    val email: LiveData<String>
        get() = liveData { emit("adryanekavandra@gmail.com") }
    val photo: LiveData<String>
        get() = liveData { emit("https://d17ivq9b7rppb3.cloudfront.net/small/avatar/201812102344074b36c9c5a5a71630c5cb3240553a10a5.jpg") }
}