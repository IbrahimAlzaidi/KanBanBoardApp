package com.example.kanbanboardapp.util

import androidx.recyclerview.widget.DiffUtil

class DiffUtilAdapter<T>(
    private val oldItemList: List<T>,
    private val newItemList: List<T>,
    private val checkIfSame: (oldItemList: T, newItemList: T) -> Boolean
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldItemList.size

    override fun getNewListSize() = newItemList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        checkIfSame(oldItemList[oldItemPosition], newItemList[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true

}
