package ru.silcomsoft.mvprx_1.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.silcomsoft.mvprx_1.App
import ru.silcomsoft.mvprx_1.databinding.FragmentUserListBinding
import ru.silcomsoft.mvprx_1.domain.presenter.user_list.ScreenUserListPresenter
import ru.silcomsoft.mvprx_1.domain.repository.GithubUsersRepo
import ru.silcomsoft.mvprx_1.ui.adapter.UsersRVAdapter
import ru.silcomsoft.mvprx_1.ui.screens.Screens
import ru.silcomsoft.mvprx_1.ui.util.IBackButtonListener
import ru.silcomsoft.mvprx_1.view.IUserListView

class UserListFragment : MvpAppCompatFragment(), IUserListView, IBackButtonListener {

    companion object {
        fun newInstance() = UserListFragment()
    }

    private val screenUserListPresenter: ScreenUserListPresenter by moxyPresenter {
        ScreenUserListPresenter(GithubUsersRepo(), App.instance.router, Screens())
    }

    private var adapter: UsersRVAdapter? = null
    private var fragmentUserListBinding: FragmentUserListBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserListBinding.inflate(inflater, container, false).also {
        fragmentUserListBinding = it
    }.root

    override fun onDestroy() {
        super.onDestroy()
        fragmentUserListBinding = null
    }

    override fun init() {
        fragmentUserListBinding?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(screenUserListPresenter.userListPresenter)
        fragmentUserListBinding?.rvUsers?.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = screenUserListPresenter.backPressed()
}

