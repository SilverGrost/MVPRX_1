package ru.silcomsoft.mvprx_1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.silcomsoft.mvprx_1.databinding.ActivityMainBinding
import ru.silcomsoft.mvprx_1.presenter.CounterType
import ru.silcomsoft.mvprx_1.presenter.MainPresenter

class MainActivity : AppCompatActivity(), IMainView {

    private var vb: ActivityMainBinding? = null
    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        val function: (CounterType) -> Unit =
            { counterType: CounterType -> presenter.counterClick(counterType) }

        vb?.btnCounter1?.setOnClickListener { function(CounterType.FIRST) }
        vb?.btnCounter2?.setOnClickListener { function(CounterType.SECOND) }
        vb?.btnCounter3?.setOnClickListener { function(CounterType.THIRD) }
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
