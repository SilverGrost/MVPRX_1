package ru.silcomsoft.mvprx_1.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.silcomsoft.mvprx_1.App
import ru.silcomsoft.mvprx_1.databinding.FragmentRepoBinding
import ru.silcomsoft.mvprx_1.domain.model.GithubRepository
import ru.silcomsoft.mvprx_1.domain.presenter.repo.RepoPresenter
import ru.silcomsoft.mvprx_1.ui.util.IBackButtonListener
import ru.silcomsoft.mvprx_1.view.RepoView


class RepoFragment : MvpAppCompatFragment(), RepoView, IBackButtonListener {

    private var binding: FragmentRepoBinding? = null

    companion object {
        val USER_KEY = "repo_key"
        fun newInstance(repo: GithubRepository) = RepoFragment().apply {
            arguments = Bundle().apply {
                putParcelable(USER_KEY, repo)
            }
        }
    }

    val presenter by moxyPresenter {
        val repo = arguments?.get(USER_KEY) as GithubRepository
        RepoPresenter(
            App.instance.router, repo
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRepoBinding.inflate(inflater, container, false);
        return binding?.root
    }

    override fun backPressed() = presenter.backClick()

    override fun setRepoName(repoName: String) {
        binding?.repoName?.text = repoName
    }

}