package ru.silcomsoft.mvprx_1.domain.model.retrofit.repos

import io.reactivex.rxjava3.schedulers.Schedulers
import ru.silcomsoft.mvprx_1.domain.model.GithubUser
import ru.silcomsoft.mvprx_1.domain.model.retrofit.IDataSource

class RetrofitGithubReposByUser(private val api: IDataSource): IGithubReposByUser {

    //override fun getUsers() = api.getUsers().subscribeOn(Schedulers.io())

    override fun getRepositories(user: GithubUser) =
        user.reposUrl?.let { url ->
            api.getRepos(url).subscribeOn(Schedulers.io())
        }

    //override fun getRepositories(user: GithubUser): Single<List<GithubRepository>> = user.login?.let { api.getRepos(it).subscribeOn(Schedulers.io()) }

    /*override fun getRepositories(user: GithubUser): Single<List<GithubRepository>> {
        //TODO("Not yet implemented")
        return user.login?.let {
            api.getRepos(it).subscribeOn(Schedulers.io())
        }
    }*/
}