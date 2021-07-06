package dev.adryanev.dicoding.androidpemula.ui.main

import android.os.Bundle
import android.view.*
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dagger.hilt.android.AndroidEntryPoint
import dev.adryanev.dicoding.androidpemula.R
import dev.adryanev.dicoding.androidpemula.data.entities.Elephant
import dev.adryanev.dicoding.androidpemula.databinding.MainFragmentBinding
import dev.adryanev.dicoding.androidpemula.ui.base.getNavController
import dev.adryanev.dicoding.androidpemula.ui.base.list.BasePagedFragment
import dev.adryanev.dicoding.androidpemula.ui.base.list.BasePagingAdapter

@AndroidEntryPoint
class MainFragment : BasePagedFragment<MainFragmentBinding, MainViewModel, Elephant>() {
    override val pagerAdapter: BasePagingAdapter<Elephant, out ViewDataBinding> by lazy {
        MainAdapter(itemClickListener = { toDetail(it) })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        activity?.menuInflater?.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_profile){
            toProfile()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun toProfile() {
        getNavController()?.navigate(MainFragmentDirections.actionMainFragmentToProfilFragment())
    }

    private fun toDetail(elephant: Elephant) {
        getNavController()?.navigate(
            MainFragmentDirections.actionMainFragmentToDetailFragment(
                elephant
            )
        )
    }

    override val swipeRefreshLayout: SwipeRefreshLayout
        get() = viewBinding.refreshMain
    override val recyclerView: RecyclerView
        get() = viewBinding.rvMain
    override val viewModel: MainViewModel by viewModels()
    override val layoutId: Int
        get() = R.layout.main_fragment


}