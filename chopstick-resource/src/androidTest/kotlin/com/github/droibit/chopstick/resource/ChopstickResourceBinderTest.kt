package com.github.droibit.chopstick.resource

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.droibit.chopstick.resource.test.R
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChopstickResourceBinderTest {

    private val context: Context = ApplicationProvider.getApplicationContext()

    @Test
    fun bindDrawable() {
        class TestData(context: Context) : Binder by ResourceBinder(context) {
            val testDrawable: Drawable by bindDrawable(R.drawable.ic_icon)
        }

        val data = TestData(context)
        assertNotNull(data.testDrawable)
    }

    @Test
    fun bindString() {
        class TestData(context: Context) : Binder by ResourceBinder(context) {
            val testString: String by bindString(R.string.test_string)
        }

        val data = TestData(context)
        assertEquals(data.testString, context.getString(R.string.test_string))
    }

    @Test
    fun bindColor() {
        class TestData(context: Context) : Binder by ResourceBinder(context) {
            val testColor: Int by bindColor(R.color.test_color)
        }

        val data = TestData(context)
        assertEquals(data.testColor, ContextCompat.getColor(context, R.color.test_color))
    }

    @Test
    fun bindBool() {
        class TestData(context: Context) : Binder by ResourceBinder(context) {
            val testBool: Boolean by bindBoolean(R.bool.test_bool)
        }

        val data = TestData(context)
        assertEquals(data.testBool, context.resources.getBoolean(R.bool.test_bool))
    }

    @Test
    fun bindInt() {
        class TestData(context: Context) : Binder by ResourceBinder(context) {
            val testInt: Int by bindInt(R.integer.test_int)
        }

        val data = TestData(context)
        assertEquals(data.testInt, context.resources.getInteger(R.integer.test_int))
    }

    @Test
    fun bindStringArray() {
        class TestData(context: Context) : Binder by ResourceBinder(context) {
            val testArray: Array<String> by bindStringArray(R.array.test_string_array)
        }

        val data = TestData(context)
        assertArrayEquals(
            data.testArray,
            context.resources.getStringArray(R.array.test_string_array)
        )
    }

    @Test
    fun bindIntArray() {
        class TestData(context: Context) : Binder by ResourceBinder(context) {
            val testArray: IntArray by bindIntArray(R.array.test_int_array)
        }

        val data = TestData(context)
        assertArrayEquals(data.testArray, context.resources.getIntArray(R.array.test_int_array))
    }

    @Test
    fun bindDimension() {
        class TestData(context: Context) : Binder by ResourceBinder(context) {
            val testDimension: Float by bindDimension(R.dimen.test_dimen)
        }

        val data = TestData(context)
        assertEquals(data.testDimension, context.resources.getDimension(R.dimen.test_dimen))
    }

    @Test
    fun bindDimensionPixel() {
        class TestData(context: Context) : Binder by ResourceBinder(context) {
            val testDimensionPixel: Int by bindDimensionPixel(R.dimen.test_dimen)
        }

        val data = TestData(context)
        assertEquals(
            data.testDimensionPixel,
            context.resources.getDimensionPixelSize(R.dimen.test_dimen)
        )
    }
}
