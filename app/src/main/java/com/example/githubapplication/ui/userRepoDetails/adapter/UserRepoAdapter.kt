package com.example.githubapplication.ui.userRepoDetails.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapplication.api.models.GitHubUserRepositoriesModel
import com.example.githubapplication.databinding.RowItemBinding

class UserRepoAdapter(var list: MutableList<GitHubUserRepositoriesModel>, val context: Context) : RecyclerView.Adapter<UserRepoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ): UserRepoAdapter.ViewHolder {
        var root = LayoutInflater.from(parent.context)
        val binding: RowItemBinding = RowItemBinding.inflate(root,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserRepoAdapter.ViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setItemList(list: MutableList<GitHubUserRepositoriesModel>){
        this.list = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: GitHubUserRepositoriesModel){
            binding.repoName.text = model.repoName
            binding.openIssues.text = model.totalCount.toString()
        }
    }
}

