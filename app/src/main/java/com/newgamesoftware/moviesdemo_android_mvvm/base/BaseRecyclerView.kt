package com.newgamesoftware.moviesdemo_android_mvvm.base

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerView<VB: ViewDataBinding, A: BaseRecyclerViewAdapter<VB>>: RecyclerView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    @Suppress("UNCHECKED_CAST")
    fun adapter() : A{
        return adapter as A
    }
}