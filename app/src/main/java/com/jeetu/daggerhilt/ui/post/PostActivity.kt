package com.jeetu.daggerhilt.ui.post

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.viewbinding.ViewBinding
import com.jeetu.daggerhilt.data.model.Post
import com.jeetu.daggerhilt.databinding.ActivityPostBinding
import com.jeetu.daggerhilt.ui.adapter.PostAdapter
import com.jeetu.daggerhilt.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : BaseActivity<ActivityPostBinding>() {
    val TAG = PostActivity::class.java.simpleName
    private lateinit var mBinding : ActivityPostBinding
    private val postViewModel : PostViewModel by viewModels()
    override fun getViewBinding() = ActivityPostBinding.inflate(layoutInflater)
    override fun onActivityReady(savedInstanceState: Bundle?, binding: ViewBinding) {
        mBinding = binding as ActivityPostBinding
        postViewModel.getPostLiveData().observe(this){ posts ->
            posts?.let {
                Log.i(TAG,"Post list size is ${it.size}")
                loadAdapter(it as ArrayList<Post>)
            }
        }
        postViewModel.getPosts()
    }
    fun loadAdapter(posts : ArrayList<Post>){
        var postAdapter = PostAdapter(posts)
        mBinding.postListRecyleView.adapter = postAdapter

    }
}