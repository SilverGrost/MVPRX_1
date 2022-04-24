package ru.silcomsoft.mvprx_1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.silcomsoft.mvprx_1.databinding.ItemUserBinding
import ru.silcomsoft.mvprx_1.domain.model.retrofit.users.IImageLoader
import ru.silcomsoft.mvprx_1.view.IUserItemView
import ru.silcomsoft.mvprx_1.domain.presenter.user_list.IUserListPresenter

class UsersRVAdapter(private val presenter: IUserListPresenter, val imageLoader: IImageLoader<ImageView>) :
    RecyclerView.Adapter<UsersRVAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        ).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(private val itemUserBinding: ItemUserBinding) :
        RecyclerView.ViewHolder(itemUserBinding.root), IUserItemView {
        override var pos = -1

        override fun setLogin(text: String) = with(itemUserBinding) {
            tvLogin.text = text
        }

        override fun loadAvatar(url: String) {
            imageLoader.loadInto(url, itemUserBinding.ivAvatar)
        }
    }

}