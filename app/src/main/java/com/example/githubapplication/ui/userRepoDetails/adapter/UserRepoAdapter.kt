package com.example.githubapplication.ui.userRepoDetails.adapter

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapplication.R
import com.example.githubapplication.api.models.GitHubUserRepositoriesModel
import com.example.githubapplication.databinding.RowItemBinding

class UserRepoAdapter(var list: MutableList<GitHubUserRepositoriesModel>, val context: Context) :
    RecyclerView.Adapter<UserRepoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): UserRepoAdapter.ViewHolder {
        var root = LayoutInflater.from(parent.context)
        val binding: RowItemBinding = RowItemBinding.inflate(root, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserRepoAdapter.ViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setItemList(list: MutableList<GitHubUserRepositoriesModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: RowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: GitHubUserRepositoriesModel) {
            binding.repoName.text = model.repoName
            binding.openIssues.text = model.totalCount.toString()
            binding.repoInfoButton.setOnClickListener {
                val customDialog = Dialog(context)
                customDialog.setContentView(R.layout.custom_dialog)
                customDialog.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                val defaultBranch = customDialog.findViewById<TextView>(R.id.default_branch)
                val watchers = customDialog.findViewById<TextView>(R.id.watchers)
                val size = customDialog.findViewById<TextView>(R.id.size)
                val closeBtn = customDialog.findViewById<Button>(R.id.close_user_repo_button)

                defaultBranch.text = model.defaultBranch
                watchers.text = model.watchers.toString()
                size.text = model.size.toString()

                closeBtn.setOnClickListener {
                    customDialog.dismiss()
                }
                customDialog.show()
            }
        }
    }
}

