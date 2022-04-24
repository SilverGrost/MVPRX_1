package ru.silcomsoft.mvprx_1.domain.model.retrofit.users

import io.reactivex.rxjava3.schedulers.Schedulers
import ru.silcomsoft.mvprx_1.domain.model.retrofit.IDataSource

class RetrofitGithubUsersRepo(private val api: IDataSource): IGithubUsersRepo {
    
    override fun getUsers() = api.getUsers().subscribeOn(Schedulers.io())
}




