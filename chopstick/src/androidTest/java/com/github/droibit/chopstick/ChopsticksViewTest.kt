package com.github.droibit.chopstick

import android.content.Context
import android.test.AndroidTestCase
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView

class ChopsticksViewTest : AndroidTestCase() {

    fun test_bindView() {
        class TestLayout(context: Context) : FrameLayout(context) {
            val view: View by bindView(0)
            val textView: TextView by bindView(1)
        }

        val layout = TestLayout(context).apply {
            addView(makeView(id = 0))
            addView(makeTextView(id = 1))
        }

        assertNotNull(layout.view)
        assertEquals(layout.view.id, 0)

        assertNotNull(layout.textView)
        assertEquals(layout.textView.id, 1)
    }

    fun test_bindView_notFound() {
        class TestLayout(context: Context) : FrameLayout(context) {
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
        class TestLayout(context: Context) : FrameLayout(context) {
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
        class TestLayout(context: Context) : FrameLayout(context) {
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
        class TestLayout(context: Context) : FrameLayout(context) {
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

    private fun makeView(id: Int) = View(context).apply { setId(id) }
    private fun makeTextView(id: Int) = TextView(context).apply { setId(id) }
}
