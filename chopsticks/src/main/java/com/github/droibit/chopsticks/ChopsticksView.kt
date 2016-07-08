package com.github.droibit.chopsticks

import android.app.Activity
import android.app.Fragment
import android.support.annotation.IdRes
import android.support.v4.app.Fragment as SupportFragment
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View

fun <V : View> Activity.bindView(@IdRes id: Int): Lazy<V> = require(id, viewFinder)
fun <V : View> Fragment.bindView(@IdRes id: Int): Lazy<V> = require(id, viewFinder)
fun <V : View> SupportFragment.bindView(@IdRes id: Int): Lazy<V> = require(id, viewFinder)
fun <V : View> ViewHolder.bindView(@IdRes id: Int): Lazy<V> = require(id, viewFinder)
fun <V : View> View.bindView(@IdRes id: Int): Lazy<V> = require(id, viewFinder)

fun <V : View> Activity.bindViews(vararg ids: Int): Lazy<List<V>>
        = require(ids) { findViewById(it) }

fun <V : View> Fragment.bindViews(vararg ids: Int): Lazy<List<V>>
        = require(ids) { view?.findViewById(it) }

fun <V : View> SupportFragment.bindViews(vararg ids: Int): Lazy<List<V>>
        = require(ids) { view?.findViewById(it) }

fun <V : View> ViewHolder.bindViews(vararg ids: Int): Lazy<List<V>>
        = require(ids) { itemView.findViewById(it) }

fun <V : View> View.bindViews(vararg ids: Int): Lazy<List<V>>
        = require(ids) { findViewById(it) }

internal val Activity.viewFinder: (Int) -> View?
    get() = { findViewById(it) }

internal val Fragment.viewFinder: (Int) -> View?
    get() = { view?.findViewById(it) }

internal val SupportFragment.viewFinder: (Int) -> View?
    get() = { view?.findViewById(it) }

internal val ViewHolder.viewFinder: (Int) -> View?
    get() = { itemView.findViewById(it) }

internal val View.viewFinder: (Int) -> View?
    get() = { findViewById(it) }

@Suppress("UNCHECKED_CAST")
private inline fun <V : View> require(id: Int, crossinline finder: (Int) -> View?)
        = lazy { requireNotNull(finder(id)) { "Not found view by id($id)." } as V }

@Suppress("UNCHECKED_CAST")
private inline fun <V : View> require(ids: IntArray, crossinline finder: (Int) -> View?) = lazy {
    require(ids.size > 0) { "ids size > 0" }
    ids.map { requireNotNull(finder(it)) { "Not found view by id($it)." } as V }.toList()
}
