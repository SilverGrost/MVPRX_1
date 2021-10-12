package ru.silcomsoft.mvprx_1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.silcomsoft.mvprx_1.R
import ru.silcomsoft.mvprx_1.databinding.ActivityMainBinding
import ru.silcomsoft.mvprx_1.presenter.CounterType
import ru.silcomsoft.mvprx_1.presenter.MainPresenter
import ru.silcomsoft.mvprx_1.view.IMainView
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity(), IMainView {

    private var vb: ActivityMainBinding? = null
    private var presenter: MainPresenter? = null

    override fun onStop() {
        presenter = null
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
        presenter = MainPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        val listener = View.OnClickListener { view ->
            val type = when (view.id) {
                R.id.btn_counter1 -> CounterType.FIRST
                R.id.btn_counter2 -> CounterType.SECOND
                R.id.btn_counter3 -> CounterType.THIRD
                else -> throw IllegalStateException("Такой кнопки нет")
            }
            presenter?.counterClick(type)
        }

        vb?.btnCounter1?.setOnClickListener(listener)
        vb?.btnCounter2?.setOnClickListener(listener)
        vb?.btnCounter3?.setOnClickListener(listener)
    }

    //Подсказка к ПЗ: поделить на 3 отдельные функции и избавиться от index
    override fun setButtonText(type: CounterType, text: String) {
        when (type) {
            CounterType.FIRST -> vb?.btnCounter1?.text = text
            CounterType.SECOND -> vb?.btnCounter2?.text = text
            CounterType.THIRD -> vb?.btnCounter3?.text = text
        }
    }
}
