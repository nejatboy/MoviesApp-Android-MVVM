package com.newgamesoftware.moviesdemo_android_mvvm.subviews

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel
import com.newgamesoftware.moviesdemo_android_mvvm.util.widthRatio

class RadiusImageView: ShapeableImageView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)


    init {
        shapeAppearanceModel = ShapeAppearanceModel().withCornerSize(0.02f.widthRatio.toFloat())
    }
}