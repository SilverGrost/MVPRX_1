package ru.silcomsoft.mvprx_1.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.silcomsoft.mvprx_1.App
import ru.silcomsoft.mvprx_1.Constant.USER_DETAILS
import ru.silcomsoft.mvprx_1.databinding.FragmentUserDetailsBinding
import ru.silcomsoft.mvprx_1.domain.model.GithubUser
import ru.silcomsoft.mvprx_1.domain.presenter.user_details.UserDetailsPresenter
import ru.silcomsoft.mvprx_1.ui.util.IBackButtonListener
import ru.silcomsoft.mvprx_1.view.IUserDetailsView

class UserDetailsFragment : MvpAppCompatFragment(), IUserDetailsView, IBackButtonListener {

    companion object {
        fun newInstance(gitHubUser: GithubUser): UserDetailsFragment{

            val args = Bundle().apply { putParcelable(USER_DETAILS, gitHubUser) }
            val fragment = UserDetailsFragment()

            fragment.arguments = args
            return fragment
        }
    }

    private val userDetailsPresenter: UserDetailsPresenter by moxyPresenter { UserDetailsPresenter(App.instance.router) }
    private var userDetailsFragmentBinding: FragmentUserDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserDetailsBinding.inflate(inflater, container, false).also {
        userDetailsFragmentBinding = it
    }.root

    override fun onDestroy() {
        super.onDestroy()
        userDetailsFragmentBinding = null
    }

    override fun init() {
        userDetailsPresenter.user = arguments?.getParcelable(USER_DETAILS)
        userDetailsPresenter.user?.login?.let { showUserLogin(it) }
    }

    override fun showUserLogin(login: String) {
        userDetailsFragmentBinding?.userLogin?.text = login
    }

    override fun backPressed() = userDetailsPresenter.backPressed()
}

