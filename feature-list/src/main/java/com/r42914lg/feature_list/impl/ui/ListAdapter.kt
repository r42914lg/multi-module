package com.r42914lg.feature_list.impl.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.r42914lg.core_api.domain.local.model.Category
import com.r42914lg.feature_list.databinding.ListItemBinding

class ListAdapter(private val listener: ClickListener) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private val items = mutableListOf<Category>()

    interface ClickListener {
        fun itemClicked(itemId: Int)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<Category>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListItemBinding = ListItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
            false
        )

        return ViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(
        private val itemBinding: ListItemBinding,
        private val listener: ClickListener
    ) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

        private lateinit var _item: Category

        init {
            itemBinding.root.setOnClickListener(this)
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: Category) = with(itemBinding) {
            _item = item

            categoryIdText.text = "Category ID: ${item.id}"
            categoryTitleText.text = "Title: ${item.title}"
            categoryCluesCount.text = "Clue count: ${item.cluesCount}"
        }

        override fun onClick(v: View?) {
            listener.itemClicked(_item.id)
        }
    }
}