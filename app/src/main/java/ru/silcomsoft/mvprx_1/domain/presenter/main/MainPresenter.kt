package ru.silcomsoft.mvprx_1.domain.presenter.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.silcomsoft.mvprx_1.view.IMainView
import ru.silcomsoft.mvprx_1.ui.screens.IScreens

class MainPresenter(private val router: Router, private val screen: IScreens): MvpPresenter<IMainView>(){

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screen.userList())
    }

    fun backClicked(){
        router.exit()
    }
}

