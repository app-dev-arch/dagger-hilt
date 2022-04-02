package com.jeetu.apparchitectwithdaggerhilt.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity(){
    lateinit var binding : B
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        supportActionBar?.hide()
        setContentView(binding.root)
        onActivityReady(savedInstanceState,binding)
    }
    abstract fun getViewBinding () : B
    abstract fun onActivityReady (savedInstanceState: Bundle?,binding: ViewBinding)
}