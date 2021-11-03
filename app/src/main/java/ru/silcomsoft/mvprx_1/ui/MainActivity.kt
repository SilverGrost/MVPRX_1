package ru.silcomsoft.mvprx_1.ui

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.silcomsoft.mvprx_1.App
import ru.silcomsoft.mvprx_1.R
import ru.silcomsoft.mvprx_1.databinding.ActivityMainBinding
import ru.silcomsoft.mvprx_1.domain.presenter.main.MainPresenter
import ru.silcomsoft.mvprx_1.ui.screens.Screens
import ru.silcomsoft.mvprx_1.ui.util.IBackButtonListener
import ru.silcomsoft.mvprx_1.view.IMainView

class MainActivity : MvpAppCompatActivity(), IMainView {

    private val navigator = AppNavigator(this, R.id.container
    )
    private lateinit var activityMainBinding: ActivityMainBinding

    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router, Screens())
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is IBackButtonListener && it.backPressed()){
                return
            }
        }
        presenter.backClicked()
    }
}
