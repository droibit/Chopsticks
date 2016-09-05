package com.github.droibit.chopstick

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.support.v4.content.ContextCompat
import android.view.View
import com.github.droibit.chopstick.test.R
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChopstickResourceTest {

    private val context = InstrumentationRegistry.getContext()

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
}