package com.example.viewmodel

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get

class MainActivity : AppCompatActivity()
{
    lateinit var txtcounter:TextView
    lateinit var mainViewModel: MainViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(10)).get(MainViewModel::class.java)

        txtcounter = findViewById(R.id.counter)
        setText()
    }

    private fun setText() {
       txtcounter.text = mainViewModel.count.toString()
    }
    fun increment(v:View)
    {
        mainViewModel.increment()
        setText()
    }


}