package com.newgamesoftware.moviesdemo_android_mvvm.ui.home

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.newgamesoftware.moviesdemo_android_mvvm.base.BaseRecyclerView
import com.newgamesoftware.moviesdemo_android_mvvm.databinding.CellHomeBinding
import com.newgamesoftware.moviesdemo_android_mvvm.util.widthRatio

class HomeRecyclerView: BaseRecyclerView<CellHomeBinding, HomeAdapter> {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    init {
        adapter = HomeAdapter()
        addItemDecoration(Decoration())
    }


    private class Decoration: ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: State) {
            super.getItemOffsets(outRect, view, parent, state)

            val margin = 0.01f.widthRatio

            outRect.top = margin
            outRect.left = margin
            outRect.right = margin
        }
    }
}