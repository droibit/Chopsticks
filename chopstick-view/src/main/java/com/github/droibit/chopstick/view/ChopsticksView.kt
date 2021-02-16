package com.github.droibit.chopstick.view

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlin.LazyThreadSafetyMode.NONE
import androidx.fragment.app.Fragment as SupportFragment

fun <V : View> Activity.bindView(@IdRes id: Int): Lazy<V> = required(id, viewFinder)
fun <V : View> SupportFragment.bindView(@IdRes id: Int): Lazy<V> = required(id, viewFinder)
fun <V : View> ViewHolder.bindView(@IdRes id: Int): Lazy<V> = required(id, viewFinder)
fun <V : View> View.bindView(@IdRes id: Int): Lazy<V> = required(id, viewFinder)

fun <V : View> Activity.bindViews(vararg ids: Int): Lazy<List<V>> =
    required(ids) { findViewById(it) }

fun <V : View> SupportFragment.bindViews(vararg ids: Int): Lazy<List<V>> =
    required(ids) { view?.findViewById(it) }

fun <V : View> ViewHolder.bindViews(vararg ids: Int): Lazy<List<V>> =
    required(ids) { itemView.findViewById(it) }

fun <V : View> View.bindViews(vararg ids: Int): Lazy<List<V>> =
    required(ids) { findViewById(it) }

internal val Activity.viewFinder: (Int) -> View? get() = { findViewById(it) }

internal val SupportFragment.viewFinder: (Int) -> View? get() = { view?.findViewById(it) }

internal val ViewHolder.viewFinder: (Int) -> View? get() = { itemView.findViewById(it) }

internal val View.viewFinder: (Int) -> View? get() = { findViewById(it) }

@Suppress("UNCHECKED_CAST")
private inline fun <V : View> required(
    id: Int,
    crossinline finder: (Int) -> View?
) = lazy(NONE) { requireNotNull(finder(id)) { "Not found view by id($id)." } as V }

@Suppress("UNCHECKED_CAST")
private inline fun <V : View> required(
    ids: IntArray,
    crossinline finder: (Int) -> View?
) = lazy(NONE) {
    require(ids.isNotEmpty()) { "ids size > 0" }
    ids.map { requireNotNull(finder(it)) { "Not found view by id($it)." } as V }
}
