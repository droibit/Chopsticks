package com.github.droibit.chopstick.resource

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import android.view.View
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.droibit.chopstick.resource.test.R
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChopstickResourceTest {

  private val context: Context = ApplicationProvider.getApplicationContext()

  @Test
  fun bindDrawable() {
    class TestView(context: Context) : View(context) {
      val testDrawable: Drawable by bindDrawable(R.drawable.ic_icon)
    }

    val view = TestView(context)
    assertNotNull(view.testDrawable)
  }

  @Test
  fun bindString() {
    class TestView(context: Context) : View(context) {
      val testString: String by bindString(R.string.test_string)
    }

    val view = TestView(context)
    assertEquals(view.testString, context.getString(R.string.test_string))
  }

  @Test
  fun bindColor() {
    class TestView(context: Context) : View(context) {
      val testColor: Int by bindColor(R.color.test_color)
    }

    val view = TestView(context)
    assertEquals(view.testColor, ContextCompat.getColor(context, R.color.test_color))
  }

  @Test
  fun bindBool() {
    class TestView(context: Context) : View(context) {
      val testBool: Boolean by bindBoolean(R.bool.test_bool)
    }

    val view = TestView(context)
    assertEquals(view.testBool, context.resources.getBoolean(R.bool.test_bool))
  }

  @Test
  fun bindInt() {
    class TestView(context: Context) : View(context) {
      val testInt: Int by bindInt(R.integer.test_int)
    }

    val view = TestView(context)
    assertEquals(view.testInt, context.resources.getInteger(R.integer.test_int))
  }

  @Test
  fun bindStringArray() {
    class TestView(context: Context) : View(context) {
      val testArray: Array<String> by bindStringArray(R.array.test_string_array)
    }

    val view = TestView(context)
    assertArrayEquals(view.testArray, context.resources.getStringArray(R.array.test_string_array))
  }

  @Test
  fun bindIntArray() {
    class TestView(context: Context) : View(context) {
      val testArray: IntArray by bindIntArray(R.array.test_int_array)
    }

    val view = TestView(context)
    assertArrayEquals(view.testArray, context.resources.getIntArray(R.array.test_int_array))
  }

  @Test
  fun bindDimension() {
    class TestView(context: Context) : View(context) {
      val testDimension: Float by bindDimension(R.dimen.test_dimen)
    }

    val view = TestView(context)
    assertEquals(view.testDimension, context.resources.getDimension(R.dimen.test_dimen))
  }

  @Test
  fun bindDimensionPixel() {
    class TestView(context: Context) : View(context) {
      val testDimensionPixel: Int by bindDimensionPixel(R.dimen.test_dimen)
    }

    val view = TestView(context)
    assertEquals(
        view.testDimensionPixel,
        context.resources.getDimensionPixelSize(R.dimen.test_dimen)
    )
  }
}