package com.jeetu.daggerhilt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeetu.daggerhilt.data.model.Post
import com.jeetu.daggerhilt.databinding.PostItemLayoutBinding

class PostAdapter(val postList : ArrayList<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    class PostViewHolder(var binding : PostItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(post : Post){
            binding.post = post
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(PostItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList.get(position))
    }
    override fun getItemCount(): Int {
        return postList.size
    }
}