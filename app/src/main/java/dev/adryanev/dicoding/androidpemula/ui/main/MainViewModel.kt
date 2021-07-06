package dev.adryanev.dicoding.androidpemula.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.adryanev.dicoding.androidpemula.data.entities.Elephant
import dev.adryanev.dicoding.androidpemula.data.repository.ElephantRepository
import dev.adryanev.dicoding.androidpemula.ui.base.list.BasePagedViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val elephantRepository: ElephantRepository) : BasePagedViewModel<Elephant>() {
    init {
        getElephantList()
    }

    private fun getElephantList()  = launchPagingAsync(
        execute = {
            elephantRepository.getElephantList().cachedIn(viewModelScope)
        },
        onSuccess = {itemList = it}
    )
}