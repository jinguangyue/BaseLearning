package com.example.myalgorithm.livedata

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myalgorithm.R


class LiveDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        var viewModel = ViewModelProvider(this)[MyViewModel::class.java]

        viewModel.data.observe(this, object : Observer<String?> {
            override fun onChanged(value: String?) {
                updateUI(value)
            }
        })

        val setDataButton = findViewById<Button>(R.id.set_data_button)
        setDataButton.setOnClickListener { // 当用户点击按钮时，调用 ViewModel 的方法来设置数据
            viewModel.setData("New Data from Button Click")
        }
    }

    private fun updateUI(value: String?) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show()
    }
}