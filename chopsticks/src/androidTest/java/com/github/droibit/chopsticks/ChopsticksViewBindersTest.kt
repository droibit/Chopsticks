package com.github.droibit.chopsticks

import android.content.Context
import android.test.AndroidTestCase
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView

class ChopsticksViewBindersTest : AndroidTestCase() {

    fun testGetView() {
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

    fun testUnbindView() {
        class TestLayout(context: Context) : FrameLayout(context), Binder<View> by ViewBinder() {
            val view: View by bindView(0)
        }
        val layout = TestLayout(context)

        val oldTextView = makeView(0).apply {
            layout.addView(this)
        }
        assertNotNull(layout.view)
        assertSame(layout.view, oldTextView)

        val newTextView = makeTextView(0).apply {
            layout.removeAllViews()
            layout.unbindViews()
            layout.addView(this)
        }
        assertNotNull(layout.view)
        assertNotSame(layout.view, oldTextView)
        assertSame(layout.view, newTextView)
    }

    private fun makeView(id: Int) = View(context).apply { setId(id) }
    private fun makeTextView(id: Int) = TextView(context).apply { setId(id) }
}

