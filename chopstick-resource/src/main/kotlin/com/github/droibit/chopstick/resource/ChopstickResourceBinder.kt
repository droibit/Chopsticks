package com.github.droibit.chopstick.resource

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.ArrayRes
import android.support.annotation.BoolRes
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.annotation.IntegerRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat

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
    lazy { requireNotNull(ContextCompat.getDrawable(context, resId)) }

  override fun bindString(@StringRes resId: Int) = lazy { context.getString(resId) }

  override fun bindColor(@ColorRes resId: Int) = lazy { ContextCompat.getColor(context, resId) }

  override fun bindBoolean(@BoolRes resId: Int) = lazy { context.resources.getBoolean(resId) }

  override fun bindInt(@IntegerRes resId: Int) = lazy { context.resources.getInteger(resId) }

  override fun bindStringArray(@ArrayRes resId: Int) =
    lazy { context.resources.getStringArray(resId) }

  override fun bindIntArray(@ArrayRes resId: Int) = lazy { context.resources.getIntArray(resId) }

  override fun bindDimension(@DimenRes resId: Int) = lazy { context.resources.getDimension(resId) }

  override fun bindDimensionPixel(@DimenRes resId: Int) =
    lazy { context.resources.getDimensionPixelSize(resId) }
}