package com.newgamesoftware.moviesdemo_android_mvvm.base

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerViewHolder<VB: ViewDataBinding>(cell: VB): RecyclerView.ViewHolder(cell.root) {

    fun binding() : VB {
        return DataBindingUtil.findBinding(itemView)!!
    }

}