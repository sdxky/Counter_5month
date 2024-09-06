package com.example.counter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterContract {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var presenter = MainPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter.attachContract(this)


        binding.apply {
            btnIncrement.setOnClickListener {
                presenter.onIcrement()
            }
            btnDecrement.setOnClickListener {
                presenter.onDecrement()
            }
        }
    }


    override fun showResult(count: Int) {
        binding.tvResult.text = count.toString()
    }


    override fun showToast() {
        Toast.makeText(this, "Поздравляем!", Toast.LENGTH_SHORT).show()
    }

    override fun changeTextGreen() {
        binding.tvResult.setTextColor(Color.GREEN)
    }


    override fun onDestroy() {
        presenter.detachContract()
        super.onDestroy()
    }

}