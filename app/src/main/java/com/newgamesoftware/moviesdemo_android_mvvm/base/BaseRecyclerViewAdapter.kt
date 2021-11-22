package com.newgamesoftware.moviesdemo_android_mvvm.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


abstract class BaseRecyclerViewAdapter<VB: ViewDataBinding>(private val layoutID: Int): RecyclerView.Adapter<BaseRecyclerViewAdapter<VB>.Holder>() {

    inner class Holder(cell: VB) : BaseRecyclerViewHolder<VB>(cell)

    var request: ((page: Int) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<VB>(inflater, layoutID, parent, false)
        return Holder(binding)
    }
}