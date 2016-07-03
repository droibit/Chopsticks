package com.github.droibit.chopsticks

import android.app.Activity
import android.app.Fragment
import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView.ViewHolder
import android.util.SparseArray
import android.view.View

import android.support.v4.app.Fragment as SupportFragment

private class UnbindableLazy<out T : View>(private @IdRes val id: Int,
                                           private val finder: (Int) -> View?,
                                           private val cache: SparseArray<View>) : Lazy<T> {

    @Suppress("UNCHECKED_CAST")
    override val value: T
        get() {
            return if (isInitialized()) {
                cache.get(id) as T
            } else {
                requireNotNull(finder(id)).apply { cache.put(id, this) } as T
            }
        }

    override fun isInitialized() = cache.indexOfKey(id) > 0
}

interface Binder<in T> {
    fun <V : View> T.bindView(@IdRes id: Int): Lazy<V>
    fun unbindViews()
}

class ActivityBinder : Binder<Activity> {

    private val cache = SparseArray<View>()

    override fun <V : View> Activity.bindView(@IdRes id: Int): Lazy<V>
            = UnbindableLazy(id, { id -> findViewById(id) }, cache)

    override fun unbindViews() = cache.clear()
}

class FragmentBinder : Binder<Fragment> {

    private val cache = SparseArray<View>()

    override fun <V : View> Fragment.bindView(@IdRes id: Int): Lazy<V>
            = UnbindableLazy(id, { id -> view?.findViewById(id) }, cache)

    override fun unbindViews() = cache.clear()
}

class SupportFragmentBinder : Binder<SupportFragment> {

    private val cache = SparseArray<View>()

    override fun <V : View> SupportFragment.bindView(@IdRes id: Int): Lazy<V>
            = UnbindableLazy(id, { id -> view?.findViewById(id) }, cache)

    override fun unbindViews() = cache.clear()
}

class ViewBinder : Binder<View> {

    private val cache = SparseArray<View>()

    override fun <V : View> View.bindView(@IdRes id: Int): Lazy<V>
            = UnbindableLazy(id, { id -> findViewById(id) }, cache)

    override fun unbindViews() = cache.clear()
}

class ViewHolderBinder : Binder<ViewHolder> {

    private val cache = SparseArray<View>()

    override fun <V : View> ViewHolder.bindView(@IdRes id: Int): Lazy<V>
            = UnbindableLazy(id, { id -> itemView.findViewById(id) }, cache)

    override fun unbindViews() = cache.clear()
}