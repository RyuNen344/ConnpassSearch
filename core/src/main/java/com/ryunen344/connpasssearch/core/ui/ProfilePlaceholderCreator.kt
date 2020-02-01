package com.ryunen344.connpasssearch.core.ui

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.ryunen344.connpasssearch.core.R

object ProfilePlaceholderCreator {

    fun create(context: Context): VectorDrawableCompat? =
        VectorDrawableCompat.create(
            context.resources,
            R.drawable.ic_launcher_background,
            null
        )?.apply {
            setTint(
                AppCompatResources.getColorStateList(
                    context,
                    R.color.design_default_color_on_primary
                ).defaultColor
            )
        }
}
