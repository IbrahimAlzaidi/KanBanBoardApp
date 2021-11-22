package com.example.kanbanboardapp.ui.base

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kanbanboardapp.BR
import com.example.kanbanboardapp.util.DiffUtilAdapter
import com.example.kanbanboardapp.util.OnClickListener


abstract class BaseAdapter<T>(
    private var items: List<T>,
    private var listener: OnClickListener,
    private val layoutId: Int,
) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val current = items[position]
        when (holder) {
            is ItemViewHolder -> {
                holder.binding.apply {
                    setVariable(BR.item,current)
                    setVariable(BR.listener,current)
                }
            }
        }
    }

    override fun getItemViewType(position: Int) = position

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(view: RecyclerView, newItems: List<T>) {
        val diffUtilResult = DiffUtil.calculateDiff(
            DiffUtilAdapter(items, newItems) { oldItemList, newItemList ->
                areItemSame(
                    oldItemList,
                    newItemList
                )
            }
        )
        items = newItems
        diffUtilResult.dispatchUpdatesTo(this)
    }

    open fun areItemSame(oldItem: T, newItem: T): Boolean {
        return oldItem?.equals(newItem) == true
    }

    override fun getItemCount() = items.size

    fun getItems() = items

    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)

    abstract class BaseViewHolder(bindings: ViewDataBinding) :
        RecyclerView.ViewHolder(bindings.root)
}
