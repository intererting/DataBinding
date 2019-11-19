package com.yly.databinding

import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.databinding.BindingConversion
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods

@BindingMethods(
    BindingMethod(attribute = "android:tint", method = "setImageTintList", type = ImageView::class)
)
object DataBindingAnnotation {

    @BindingConversion
    @JvmStatic
    fun convertIntColorToDrawable(intColor: Int): ColorDrawable {
        return ColorDrawable(intColor)
    }
}