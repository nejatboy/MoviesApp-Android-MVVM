package com.newgamesoftware.moviesdemo_android_mvvm.ui.home.top

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import com.newgamesoftware.moviesdemo_android_mvvm.base.recyclerView.BaseRecyclerViewHasSnapHelper
import com.newgamesoftware.moviesdemo_android_mvvm.databinding.CellTopBinding


class TopRecyclerView: BaseRecyclerViewHasSnapHelper<CellTopBinding, TopAdapter> {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        adapter = TopAdapter()
        layoutManager = GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
    }
}