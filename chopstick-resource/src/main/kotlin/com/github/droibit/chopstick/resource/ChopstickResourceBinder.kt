package com.github.droibit.chopstick.resource

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ArrayRes
import androidx.annotation.BoolRes
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import kotlin.LazyThreadSafetyMode.NONE

interface Binder {

  fun bindDrawable(@DrawableRes resId: Int): Lazy<Drawable>

  fun bindString(@StringRes resId: Int): Lazy<String>

  fun bindColor(@ColorRes resId: Int): Lazy<Int>

  fun bindBoolean(@BoolRes resId: Int): Lazy<Boolean>

  fun bindInt(@IntegerRes resId: Int): Lazy<Int>

  fun bindStringArray(@ArrayRes resId: Int): Lazy<Array<String>>

  fun bindIntArray(@ArrayRes resId: Int): Lazy<IntArray>

  fun bindDimension(@DimenRes resId: Int): Lazy<Float>

  fun bindDimensionPixel(@DimenRes resId: Int): Lazy<Int>
}

class ResourceBinder(private val context: Context) : Binder {

  override fun bindDrawable(@DrawableRes resId: Int) =
    lazy(NONE) { requireNotNull(ContextCompat.getDrawable(context, resId)) }

  override fun bindString(@StringRes resId: Int) = lazy(NONE) { context.getString(resId) }

  override fun bindColor(@ColorRes resId: Int) =
    lazy(NONE) { ContextCompat.getColor(context, resId) }

  override fun bindBoolean(@BoolRes resId: Int) = lazy(NONE) { context.resources.getBoolean(resId) }

  override fun bindInt(@IntegerRes resId: Int) = lazy(NONE) { context.resources.getInteger(resId) }

  override fun bindStringArray(@ArrayRes resId: Int) =
    lazy { context.resources.getStringArray(resId) }

  override fun bindIntArray(@ArrayRes resId: Int) =
    lazy(NONE) { context.resources.getIntArray(resId) }

  override fun bindDimension(@DimenRes resId: Int) =
    lazy(NONE) { context.resources.getDimension(resId) }

  override fun bindDimensionPixel(@DimenRes resId: Int) =
    lazy(NONE) { context.resources.getDimensionPixelSize(resId) }
}