package ru.silcomsoft.mvprx_1.ui

import android.os.Bundle
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.silcomsoft.mvprx_1.databinding.ActivityMainBinding
import ru.silcomsoft.mvprx_1.model.CountersModel
import ru.silcomsoft.mvprx_1.presenter.MainPresenter
import ru.silcomsoft.mvprx_1.view.IMainView

class MainActivity : MvpAppCompatActivity(), IMainView {

    private lateinit var activityMainBinding: ActivityMainBinding
    private val presenter by moxyPresenter {MainPresenter(CountersModel())}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.btnCounter1.setOnClickListener { presenter.setButtonText1()}
        activityMainBinding.btnCounter2.setOnClickListener { presenter.setButtonText2()}
        activityMainBinding.btnCounter3.setOnClickListener { presenter.setButtonText3()}
    }

    override fun setButtonText1(text: String) {
        activityMainBinding.btnCounter1.text = text
    }

    override fun setButtonText2(text: String) {
        activityMainBinding.btnCounter2.text = text
    }

    override fun setButtonText3(text: String) {
        activityMainBinding.btnCounter3.text = text
    }
}
