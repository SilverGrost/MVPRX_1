package ru.silcomsoft.mvprx_1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.silcomsoft.mvprx_1.databinding.ItemRepoBinding
import ru.silcomsoft.mvprx_1.domain.presenter.repo.IReposListPresenter
import ru.silcomsoft.mvprx_1.view.RepoItemView


class ReposRvAdapter(val presenter: IReposListPresenter) :
    RecyclerView.Adapter<ReposRvAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        presenter.bindView(holder)
    }

    override fun getItemCount() = presenter.getCount()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRepoBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding).apply {
            binding.container.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }
    }

    inner class ViewHolder(private val binding: ItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root), RepoItemView {
        override var pos = -1

        override fun setRepositoryName(text: String) {
            binding.tvRepo.text = text
        }
    }

}