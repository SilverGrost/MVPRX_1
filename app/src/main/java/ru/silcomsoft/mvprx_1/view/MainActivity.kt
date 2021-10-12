package ru.silcomsoft.mvprx_1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.silcomsoft.mvprx_1.R
import ru.silcomsoft.mvprx_1.databinding.ActivityMainBinding
import ru.silcomsoft.mvprx_1.presenter.CounterType
import ru.silcomsoft.mvprx_1.presenter.MainPresenter
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity(), IMainView {

    private var vb: ActivityMainBinding? = null
    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        val listener = View.OnClickListener {
            val type = when (it.id) {
                R.id.btn_counter1 -> CounterType.FIRST
                R.id.btn_counter2 -> CounterType.SECOND
                R.id.btn_counter3 -> CounterType.THIRD
                else -> throw IllegalStateException("Такой кнопки нет")
            }
            presenter.counterClick(type)
        }

        vb?.btnCounter1?.setOnClickListener(listener)
        vb?.btnCounter2?.setOnClickListener(listener)
        vb?.btnCounter3?.setOnClickListener(listener)
    }

    //Подсказка к ПЗ: поделить на 3 отдельные функции и избавиться от index
    override fun setButtonText(index: Int, text: String) {
        when (index) {
            0 -> vb?.btnCounter1?.text = text
            1 -> vb?.btnCounter2?.text = text
            2 -> vb?.btnCounter3?.text = text
        }
    }
}
