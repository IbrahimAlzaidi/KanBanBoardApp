package com.example.kanbanboardapp.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kanbanboardapp.BR
import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.TaskItemBinding
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.util.DiffUtilAdapter
import com.example.kanbanboardapp.util.OnDeleteItemListener
import com.example.kanbanboardapp.util.OnPositionItemListener
import com.example.kanbanboardapp.util.OnTransItemListener

class TaskAdapter(
    private var items: List<Task?>,
    private val tranListener: OnTransItemListener? = null,
    private val deletedListener: OnDeleteItemListener? = null,
    private val itemPosition: OnPositionItemListener? = null,
) : RecyclerView.Adapter<TaskAdapter.ItemViewHolder>() {
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val item = R.layout.task_item
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val current = items[position]
        holder.binding.apply {
            setVariable(BR.item, current)
            setVariable(BR.deleteListener, deletedListener)
            setVariable(BR.transListener, tranListener)
            setVariable(BR.positionListener, itemPosition)
        }
    }

    override fun getItemViewType(position: Int) = position

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newItems: List<Task?>) {
        val diffResult = DiffUtil.calculateDiff(DiffUtilAdapter(
            oldItemList = items,
            newItemList = newItems
        ) { oldItemList, newItemList ->
            areItemSame(
                oldItemList, newItemList
            )
        }
        )
        items = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    private fun areItemSame(oldItem: Task?, newItem: Task?): Boolean {
        return oldItem?.task_id == newItem?.task_id &&
                oldItem?.task_title == newItem?.task_title &&
                oldItem?.task_description == newItem?.task_description &&
                oldItem?.task_stats == newItem?.task_stats
    }

    override fun getItemCount() = items.size

    class ItemViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = TaskItemBinding.bind(viewItem)
    }
}
