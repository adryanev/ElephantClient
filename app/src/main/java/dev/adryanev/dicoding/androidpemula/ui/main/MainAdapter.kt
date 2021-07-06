package dev.adryanev.dicoding.androidpemula.ui.main

import androidx.recyclerview.widget.DiffUtil
import dev.adryanev.dicoding.androidpemula.R
import dev.adryanev.dicoding.androidpemula.data.entities.Elephant
import dev.adryanev.dicoding.androidpemula.databinding.ItemElephantBinding
import dev.adryanev.dicoding.androidpemula.ui.base.list.BasePagingAdapter
import dev.adryanev.dicoding.androidpemula.utils.BindingAdapter.setSingleClick

class MainAdapter(val itemClickListener: (Elephant)->Unit = {}):
BasePagingAdapter<Elephant, ItemElephantBinding>(object :DiffUtil.ItemCallback<Elephant>(){
    override fun areItemsTheSame(oldItem: Elephant, newItem: Elephant): Boolean {
        return oldItem.index == newItem.index
    }

    override fun areContentsTheSame(oldItem: Elephant, newItem: Elephant): Boolean {
        return oldItem == newItem
    }

}){
    override fun getLayoutRes(viewType: Int): Int = R.layout.item_elephant

    override fun bindFirstTime(binding: ItemElephantBinding) {
        binding.apply {
            root.setSingleClick{
                item?.apply {
                    itemClickListener(this)
                }
            }
        }
    }
}