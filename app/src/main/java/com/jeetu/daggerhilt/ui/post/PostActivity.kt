package com.jeetu.daggerhilt.ui.post

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.viewbinding.ViewBinding
import com.jeetu.daggerhilt.databinding.ActivityPostBinding
import com.jeetu.daggerhilt.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : BaseActivity<ActivityPostBinding>() {
    val TAG = PostActivity::class.java.simpleName
    private val postViewModel : PostViewModel by viewModels()
    override fun getViewBinding() = ActivityPostBinding.inflate(layoutInflater)
    override fun onActivityReady(savedInstanceState: Bundle?, binding: ViewBinding) {
        postViewModel.getPostLiveData().observe(this){
            Log.i(TAG,"Post list size is ${it.size}")
        }
        postViewModel.getPosts()
    }
}