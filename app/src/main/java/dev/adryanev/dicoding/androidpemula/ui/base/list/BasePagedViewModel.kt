package dev.adryanev.dicoding.androidpemula.ui.base.list

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import dev.adryanev.dicoding.androidpemula.ui.base.BaseViewModel
import kotlinx.coroutines.flow.Flow

abstract class BasePagedViewModel<Item : Any> : BaseViewModel() {

    val isRefreshing = MutableLiveData<Boolean>().apply { value = false }

    var itemList: Flow<PagingData<Item>>? = null


}
