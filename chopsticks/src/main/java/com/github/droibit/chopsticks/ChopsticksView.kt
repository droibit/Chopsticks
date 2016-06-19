package com.github.droibit.chopsticks

import android.app.Activity
import android.app.Fragment
import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View

fun <V : View> View.bindView(@IdRes id: Int): Lazy<V> = require { findViewById(id) }
fun <V : View> Activity.bindView(@IdRes id: Int): Lazy<V> = require { findViewById(id) }
fun <V : View> Fragment.bindView(@IdRes id: Int): Lazy<V> = require { view?.findViewById(id) }
fun <V : View> ViewHolder.bindView(@IdRes id: Int): Lazy<V> = require { itemView.findViewById(id) }

@Suppress("UNCHECKED_CAST")
private inline fun <V : View> require(crossinline finder: () -> View?)
        = lazy { requireNotNull(finder()) as V }