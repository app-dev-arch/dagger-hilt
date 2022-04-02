package com.jeetu.daggerhilt.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeetu.daggerhilt.data.model.Post
import com.jeetu.daggerhilt.data.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(val appRepository: ApiRepository) : ViewModel(){
    //both object create bcos mutable live data is read and writable so we not want to write someone from outer this class
    private val postMutableLiveData = MutableLiveData<List<Post>>()
    private val postLiveData : LiveData<List<Post>> = postMutableLiveData

    fun getPostLiveData() : LiveData<List<Post>> = postLiveData

    fun getPosts() = viewModelScope.launch {
        postMutableLiveData.value = appRepository.getPost()
    }

}