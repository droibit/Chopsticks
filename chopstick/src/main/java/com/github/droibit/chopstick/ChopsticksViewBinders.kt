package com.github.droibit.chopstick

import android.app.Activity
import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView.ViewHolder
import android.util.SparseArray
import android.view.View

import android.support.v4.app.Fragment as SupportFragment

private class UnbindableLazy<out T : View>(private @IdRes val id: Int,
                                           private val cache: SparseArray<View>,
                                           private val finder: (Int) -> View?) : Lazy<T> {

    @Suppress("UNCHECKED_CAST")
    override val value: T
        get() {
            return if (isInitialized()) {
                cache.get(id) as T
            } else {
                requireNotNull(finder(id)) { "Not found view by id($id)." }
                        .apply { cache.put(id, this) } as T
            }
        }

    override fun isInitialized() = cache.indexOfKey(id) > 0
}

private class UnbindableLazyList<out T : View>(private val ids: IntArray,
                                               private val cache: SparseArray<View>,
                                               private val finder: (Int) -> View?) : Lazy<List<T>> {

    @Suppress("UNCHECKED_CAST")
    override val value: List<T>
        get() {
            return if (isInitialized()) {
                ids.map { cache.get(it) as T }.toList()
            } else {
                require(ids.size > 0) { "ids size > 0" }
                ids.map {
                    requireNotNull(finder(it)) { "Not found view by id($it)." }
                            .apply { cache.put(id, this) } as T
                }.toList()
            }
        }

    override fun isInitialized() = ids.any { cache.indexOfKey(it) > 0 }
}

interface Binder<in T> {
    fun <V : View> T.bindView(@IdRes id: Int): Lazy<V>
    fun <V : View> T.bindViews(vararg ids: Int): Lazy<List<V>>
    fun unbindViews()
}

class ActivityBinder : Binder<Activity> {

    private val cache = SparseArray<View>()

    override fun <V : View> Activity.bindView(@IdRes id: Int): Lazy<V>
            = UnbindableLazy(id, cache, viewFinder)

    override fun <V : View> Activity.bindViews(vararg ids: Int): Lazy<List<V>>
            = UnbindableLazyList(ids, cache, viewFinder)

    override fun unbindViews() = cache.clear()
}

class SupportFragmentBinder : Binder<SupportFragment> {

    private val cache = SparseArray<View>()

    override fun <V : View> SupportFragment.bindView(@IdRes id: Int): Lazy<V>
            = UnbindableLazy(id, cache, viewFinder)

    override fun <V : View> SupportFragment.bindViews(vararg ids: Int): Lazy<List<V>>
            = UnbindableLazyList(ids, cache, viewFinder)


    override fun unbindViews() = cache.clear()
}

class ViewBinder : Binder<View> {

    private val cache = SparseArray<View>()

    override fun <V : View> View.bindView(@IdRes id: Int): Lazy<V>
            = UnbindableLazy(id, cache, viewFinder)

    override fun <V : View> View.bindViews(vararg ids: Int): Lazy<List<V>>
            = UnbindableLazyList(ids, cache, viewFinder)

    override fun unbindViews() = cache.clear()
}

class ViewHolderBinder : Binder<ViewHolder> {

    private val cache = SparseArray<View>()

    override fun <V : View> ViewHolder.bindView(@IdRes id: Int): Lazy<V>
            = UnbindableLazy(id, cache, viewFinder)

    override fun <V : View> ViewHolder.bindViews(vararg ids: Int): Lazy<List<V>>
            = UnbindableLazyList(ids, cache, viewFinder)

    override fun unbindViews() = cache.clear()
}