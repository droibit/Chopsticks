package com.github.droibit.chopstick.resource

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.ArrayRes
import androidx.annotation.BoolRes
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import android.view.View
import androidx.fragment.app.Fragment as SupportFragment

fun Activity.bindDrawable(@DrawableRes resId: Int): Lazy<Drawable> =
  lazy { requireNotNull(ContextCompat.getDrawable(this, resId)) }

fun SupportFragment.bindDrawable(@DrawableRes resId: Int): Lazy<Drawable> =
  lazy { requireNotNull(ContextCompat.getDrawable(requireContext(), resId)) }

fun Fragment.bindDrawable(@DrawableRes resId: Int): Lazy<Drawable> =
  lazy {
    requireNotNull(
        ContextCompat.getDrawable(if (isAtLeastM()) context!! else activity!!, resId)
    )
  }

fun View.bindDrawable(@DrawableRes resId: Int): Lazy<Drawable> =
  lazy { requireNotNull(ContextCompat.getDrawable(context, resId)) }

fun ViewHolder.bindDrawable(@DrawableRes resId: Int): Lazy<Drawable> =
  lazy { requireNotNull(ContextCompat.getDrawable(context, resId)) }

fun Activity.bindString(@StringRes resId: Int) = lazy { getString(resId) }
fun SupportFragment.bindString(@StringRes resId: Int) = lazy { getString(resId) }
fun Fragment.bindString(@StringRes resId: Int): Lazy<String> = lazy { getString(resId) }
fun View.bindString(@StringRes resId: Int) = lazy { context.getString(resId) }
fun ViewHolder.bindString(@StringRes resId: Int) = lazy { context.getString(resId) }

fun Activity.bindColor(@ColorRes resId: Int) = lazy { ContextCompat.getColor(this, resId) }
fun SupportFragment.bindColor(@ColorRes resId: Int) =
  lazy { ContextCompat.getColor(requireContext(), resId) }

fun Fragment.bindColor(@ColorRes resId: Int) =
  lazy { ContextCompat.getColor(if (isAtLeastM()) context!! else activity!!, resId) }

fun View.bindColor(@ColorRes resId: Int) = lazy { ContextCompat.getColor(context, resId) }
fun ViewHolder.bindColor(@ColorRes resId: Int) = lazy { ContextCompat.getColor(context, resId) }

fun Activity.bindBoolean(@BoolRes resId: Int) = lazy { resources.getBoolean(resId) }
fun SupportFragment.bindBoolean(@BoolRes resId: Int) = lazy { resources.getBoolean(resId) }
fun Fragment.bindBoolean(@BoolRes resId: Int) = lazy { resources.getBoolean(resId) }
fun View.bindBoolean(@BoolRes resId: Int) = lazy { context.resources.getBoolean(resId) }
fun ViewHolder.bindBoolean(@BoolRes resId: Int) = lazy { context.resources.getBoolean(resId) }

fun Activity.bindInt(@IntegerRes resId: Int) = lazy { resources.getInteger(resId) }
fun SupportFragment.bindInt(@IntegerRes resId: Int) = lazy { resources.getInteger(resId) }
fun Fragment.bindInt(@IntegerRes resId: Int) = lazy { resources.getInteger(resId) }
fun View.bindInt(@IntegerRes resId: Int) = lazy { resources.getInteger(resId) }
fun ViewHolder.bindInt(@IntegerRes resId: Int) = lazy { context.resources.getInteger(resId) }

fun Activity.bindStringArray(@ArrayRes resId: Int) = lazy { resources.getStringArray(resId) }
fun SupportFragment.bindStringArray(@ArrayRes resId: Int) = lazy { resources.getStringArray(resId) }
fun Fragment.bindStringArray(@ArrayRes resId: Int) = lazy { resources.getStringArray(resId) }
fun View.bindStringArray(@ArrayRes resId: Int) = lazy { resources.getStringArray(resId) }
fun ViewHolder.bindStringArray(@ArrayRes resId: Int) =
  lazy { context.resources.getStringArray(resId) }

fun Activity.bindIntArray(@ArrayRes resId: Int) = lazy { resources.getIntArray(resId) }
fun SupportFragment.bindIntArray(@ArrayRes resId: Int) = lazy { resources.getIntArray(resId) }
fun Fragment.bindIntArray(@ArrayRes resId: Int) = lazy { resources.getIntArray(resId) }
fun View.bindIntArray(@ArrayRes resId: Int) = lazy { resources.getIntArray(resId) }
fun ViewHolder.bindIntArray(@ArrayRes resId: Int) = lazy { context.resources.getIntArray(resId) }

fun Activity.bindDimension(@DimenRes resId: Int) = lazy { resources.getDimension(resId) }
fun SupportFragment.bindDimension(@DimenRes resId: Int) = lazy { resources.getDimension(resId) }
fun Fragment.bindDimension(@DimenRes resId: Int) = lazy { resources.getDimension(resId) }
fun View.bindDimension(@DimenRes resId: Int) = lazy { resources.getDimension(resId) }
fun ViewHolder.bindDimension(@DimenRes resId: Int) = lazy { context.resources.getDimension(resId) }

fun Activity.bindDimensionPixel(@DimenRes resId: Int) =
  lazy { resources.getDimensionPixelSize(resId) }

fun SupportFragment.bindDimensionPixel(@DimenRes resId: Int) =
  lazy { resources.getDimensionPixelSize(resId) }

fun Fragment.bindDimensionPixel(@DimenRes resId: Int) =
  lazy { resources.getDimensionPixelSize(resId) }

fun View.bindDimensionPixel(@DimenRes resId: Int) = lazy { resources.getDimensionPixelSize(resId) }
fun ViewHolder.bindDimensionPixel(@DimenRes resId: Int) =
  lazy { context.resources.getDimensionPixelSize(resId) }

private val ViewHolder.context: Context inline get() = itemView.context

private fun Fragment.isAtLeastM(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M