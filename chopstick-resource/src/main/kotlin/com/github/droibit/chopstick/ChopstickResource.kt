package com.github.droibit.chopstick

import android.app.Activity
import android.app.Fragment
import android.support.annotation.ArrayRes
import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.view.View
import android.support.v4.app.Fragment as SupportFragment

fun Activity.bindString(@StringRes resId: Int) = lazy { getString(resId) }
fun Fragment.bindString(@StringRes resId: Int) = lazy { getString(resId) }
fun SupportFragment.bindString(@StringRes resId: Int) = lazy { getString(resId) }
fun View.bindString(@StringRes resId: Int) = lazy { context.getString(resId) }

fun Activity.bindColor(@ColorRes resId: Int) = lazy { ContextCompat.getColor(this, resId) }
fun Fragment.bindColor(@ColorRes resId: Int) = lazy { ContextCompat.getColor(activity, resId) }
fun SupportFragment.bindColor(@ColorRes resId: Int) = lazy { ContextCompat.getColor(context, resId) }
fun View.bindColor(@ColorRes resId: Int) = lazy { ContextCompat.getColor(context, resId) }

fun Activity.bindStringArray(@ArrayRes resId: Int) = lazy { resources.getStringArray(resId) }
fun Fragment.bindStringArray(@ArrayRes resId: Int) = lazy { resources.getStringArray(resId) }
fun SupportFragment.bindStringArray(@ArrayRes resId: Int) = lazy { resources.getStringArray(resId) }
fun View.bindStringArray(@ArrayRes resId: Int) = lazy { resources.getStringArray(resId) }

fun Activity.bindIntArray(@ArrayRes resId: Int) = lazy { resources.getIntArray(resId) }
fun Fragment.bindIntArray(@ArrayRes resId: Int) = lazy { resources.getIntArray(resId) }
fun SupportFragment.bindIntArray(@ArrayRes resId: Int) = lazy { resources.getIntArray(resId) }
fun View.bindIntArray(@ArrayRes resId: Int) = lazy { resources.getIntArray(resId) }