package com.github.droibit.chopstick.view

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChopsticksViewTest {

  private val context: Context = ApplicationProvider.getApplicationContext()

  @Test
  fun bindView() {
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

  @Test(expected = IllegalArgumentException::class)
  fun bindView_notFound() {
    class TestLayout(context: Context) : FrameLayout(context) {
      val view: View by bindView(0)
    }

    TestLayout(context).apply {
      view.isEnabled = false
    }
  }

  @Test
  fun bindViews() {
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

  @Test(expected = IllegalArgumentException::class)
  fun bindViews_notFound() {
    class TestLayout(context: Context) : FrameLayout(context) {
      val textViews: List<TextView> by bindViews(0, 1, 2)
    }

    TestLayout(context).apply {
      textViews[0].isEnabled = false
    }
  }

  @Test(expected = IllegalArgumentException::class)
  fun bindViews_emptyIds() {
    class TestLayout(context: Context) : FrameLayout(context) {
      val textViews: List<TextView> by bindViews()
    }

    TestLayout(context).apply {
      textViews[0].isEnabled = false
    }
  }

  fun test_findView() {
    class TestLayout(context: Context) : FrameLayout(context) {
      init {
        addView(makeView(id = 0))
        addView(makeTextView(id = 1))
      }
    }

    val layout = TestLayout(context)

    val v1: View = layout.findView(id = 0)
    assertNotNull(v1)

    val v2: TextView = layout.findView(id = 1)
    assertNotNull(v2)
  }

  private fun makeView(id: Int) = View(context).apply { setId(id) }

  private fun makeTextView(id: Int) = TextView(context).apply { setId(id) }
}
