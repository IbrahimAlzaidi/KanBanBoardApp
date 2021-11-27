package com.example.kanbanboardapp.util

import androidx.recyclerview.widget.DiffUtil
import com.example.kanbanboardapp.model.entity.Task

class DiffUtilAdapter(
    private val oldItemList: List<Task?>,
    private val newItemList: List<Task?>,
    private val checkIfSame: (oldItemList: Task?, newItemList: Task?) -> Boolean
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldItemList.size

    override fun getNewListSize() = newItemList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        checkIfSame(oldItemList[oldItemPosition], newItemList[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true

}
