package com.github.droibit.chopstick.sample.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.droibit.chopstick.resource.bindString
import com.github.droibit.chopstick.sample.R
import com.github.droibit.chopstick.view.bindView

class BindViewActivity : AppCompatActivity() {

    companion object {

        @JvmStatic
        fun makeIntent(context: Context) = Intent(context, BindViewActivity::class.java)
    }

    private val textView: TextView by bindView(android.R.id.text1)
    private val button: Button by bindView(android.R.id.button1)

    private val activityText: String by bindString(R.string.bind_activity_text)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bind_view)

        textView.text = activityText
        button.setOnClickListener {
            Toast.makeText(this@BindViewActivity, "Hello, bindView", Toast.LENGTH_SHORT)
                .show()
        }
    }
}
