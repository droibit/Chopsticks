package com.github.droibit.chopstick.resource

import android.app.Activity
import android.content.Context
import android.support.annotation.*
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.support.v4.app.Fragment as SupportFragment

fun Activity.bindDrawable(@DrawableRes resId: Int) = lazy { ContextCompat.getDrawable(this, resId) }
fun SupportFragment.bindDrawable(@DrawableRes resId: Int) = lazy { ContextCompat.getDrawable(context, resId) }
fun View.bindDrawable(@DrawableRes resId: Int) = lazy { ContextCompat.getDrawable(context, resId) }
fun ViewHolder.bindDrawable(@DrawableRes resId: Int) = lazy { ContextCompat.getDrawable(context, resId) }

fun Activity.bindString(@StringRes resId: Int) = lazy { getString(resId) }
fun SupportFragment.bindString(@StringRes resId: Int) = lazy { getString(resId) }
fun View.bindString(@StringRes resId: Int) = lazy { context.getString(resId) }
fun ViewHolder.bindString(@StringRes resId: Int) = lazy { context.getString(resId) }

fun Activity.bindColor(@ColorRes resId: Int) = lazy { ContextCompat.getColor(this, resId) }
fun SupportFragment.bindColor(@ColorRes resId: Int) = lazy { ContextCompat.getColor(context, resId) }
fun View.bindColor(@ColorRes resId: Int) = lazy { ContextCompat.getColor(context, resId) }
fun ViewHolder.bindColor(@ColorRes resId: Int) = lazy { ContextCompat.getColor(context, resId) }

fun Activity.bindBoolean(@BoolRes resId: Int) = lazy { resources.getBoolean(resId) }
fun SupportFragment.bindBoolean(@BoolRes resId: Int) = lazy { resources.getBoolean(resId) }
fun View.bindBoolean(@BoolRes resId: Int) = lazy { context.resources.getBoolean(resId) }
fun ViewHolder.bindBoolean(@BoolRes resId: Int) = lazy { context.resources.getBoolean(resId) }

fun Activity.bindInt(@IntegerRes resId: Int) = lazy { resources.getInteger(resId) }
fun SupportFragment.bindInt(@IntegerRes resId: Int) = lazy { resources.getInteger(resId) }
fun View.bindInt(@IntegerRes resId: Int) = lazy { resources.getInteger(resId) }
fun ViewHolder.bindInt(@IntegerRes resId: Int) = lazy { context.resources.getInteger(resId) }

fun Activity.bindStringArray(@ArrayRes resId: Int) = lazy { resources.getStringArray(resId) }
fun SupportFragment.bindStringArray(@ArrayRes resId: Int) = lazy { resources.getStringArray(resId) }
fun View.bindStringArray(@ArrayRes resId: Int) = lazy { resources.getStringArray(resId) }
fun ViewHolder.bindStringArray(@ArrayRes resId: Int) = lazy { context.resources.getStringArray(resId) }

fun Activity.bindIntArray(@ArrayRes resId: Int) = lazy { resources.getIntArray(resId) }
fun SupportFragment.bindIntArray(@ArrayRes resId: Int) = lazy { resources.getIntArray(resId) }
fun View.bindIntArray(@ArrayRes resId: Int) = lazy { resources.getIntArray(resId) }
fun ViewHolder.bindIntArray(@ArrayRes resId: Int) = lazy { context.resources.getIntArray(resId) }

fun Activity.bindDimension(@DimenRes resId: Int) = lazy { resources.getDimension(resId) }
fun SupportFragment.bindDimension(@DimenRes resId: Int) = lazy { resources.getDimension(resId) }
fun View.bindDimension(@DimenRes resId: Int) = lazy { resources.getDimension(resId) }
fun ViewHolder.bindDimension(@DimenRes resId: Int) = lazy { context.resources.getDimension(resId) }

fun Activity.bindDimensionPixel(@DimenRes resId: Int) = lazy { resources.getDimensionPixelSize(resId) }
fun SupportFragment.bindDimensionPixel(@DimenRes resId: Int) = lazy { resources.getDimensionPixelSize(resId) }
fun View.bindDimensionPixel(@DimenRes resId: Int) = lazy { resources.getDimensionPixelSize(resId) }
fun ViewHolder.bindDimensionPixel(@DimenRes resId: Int) = lazy { context.resources.getDimensionPixelSize(resId) }

private val ViewHolder.context: Context
    inline get() = itemView.context