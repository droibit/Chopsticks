package com.github.droibit.chopstick

import android.content.Context
import android.test.AndroidTestCase
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView

class ChopsticksViewBindersTest : AndroidTestCase() {

    fun test_bindView() {
        class TestLayout(context: Context) : FrameLayout(context), Binder<View> by ViewBinder() {
            val view: View by bindView(0)
            val textView: TextView by bindView(1)
        }

        val layout = TestLayout(context).apply {
            addView(makeView(id=0))
            addView(makeTextView(id=1))
        }

        assertNotNull(layout.view)
        assertEquals(layout.view.id, 0)

        assertNotNull(layout.textView)
        assertEquals(layout.textView.id, 1)
    }

    fun test_bindView_notFound() {
        class TestLayout(context: Context) : FrameLayout(context), Binder<View> by ViewBinder() {
            val view: View by bindView(0)
        }

        try {
            TestLayout(context).apply {
                view.isEnabled = false
            }
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "Not found view by id(0).")
        }
    }
    fun test_bindViews() {
        class TestLayout(context: Context) : FrameLayout(context), Binder<View> by ViewBinder() {
            val textViews: List<TextView> by bindViews(0, 1, 2)
        }

        val layout = TestLayout(context).apply {
            addView(makeTextView(id = 0))
            addView(makeTextView(id = 1))
            addView(makeTextView(id = 2))
        }

        assertNotNull(layout.textViews)
        assertEquals(layout.textViews.size, 3)
        layout.textViews.forEachIndexed { i, textView -> assertEquals(textView.id, i) }
    }

    fun test_bindViews_notFound() {
        class TestLayout(context: Context) : FrameLayout(context), Binder<View> by ViewBinder() {
            val textViews: List<TextView> by bindViews(0, 1, 2)
        }

        try {
            TestLayout(context).apply {
                textViews[0].isEnabled = false
            }
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "Not found view by id(0).")
        }
    }

    fun test_bindViews_emptyIds() {
        class TestLayout(context: Context) : FrameLayout(context), Binder<View> by ViewBinder() {
            val textViews: List<TextView> by bindViews()
        }

        try {
            TestLayout(context).apply {
                textViews[0].isEnabled = false
            }
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "ids size > 0")
        }
    }

    fun test_unbindViews() {
        class TestLayout(context: Context) : FrameLayout(context), Binder<View> by ViewBinder() {
            val view: View by bindView(0)
            val views: List<TextView> by bindViews(1, 2)
        }
        val layout = TestLayout(context)

        val oldTextView_0 = makeView(0).apply { layout.addView(this) }
        val oldTextView_1 = makeView(1).apply { layout.addView(this) }
        val oldTextView_2 = makeView(2).apply { layout.addView(this) }

        assertNotNull(layout.view)
        assertSame(layout.view, oldTextView_0)

        assertNotNull(layout.views)
        assertEquals(layout.views.size, 2)
        assertSame(layout.views[0], oldTextView_1)
        assertSame(layout.views[1], oldTextView_2)

        // Unbind all views.
        layout.removeAllViews()
        layout.unbindViews()

        val newTextView_0 = makeTextView(0).apply { layout.addView(this) }
        val newTextView_1 = makeTextView(1).apply { layout.addView(this) }
        val newTextView_2 = makeTextView(2).apply { layout.addView(this) }

        assertNotNull(layout.view)
        assertSame(layout.view, newTextView_0)

        assertNotNull(layout.views)
        assertEquals(layout.views.size, 2)
        assertSame(layout.views[0], newTextView_1)
        assertSame(layout.views[1], newTextView_2)
    }

    private fun makeView(id: Int) = View(context).apply { setId(id) }
    private fun makeTextView(id: Int) = TextView(context).apply { setId(id) }
}

