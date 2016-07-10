package com.github.droibit.chopstick.sample.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.github.droibit.chopstick.bindView
import com.github.droibit.chopstick.sample.R

class BindViewActivity : AppCompatActivity() {

    companion object {

        @JvmStatic
        fun makeIntent(context: Context) = Intent(context, BindViewActivity::class.java)
    }

    val textView: TextView by bindView(android.R.id.text1)
    val button: Button by bindView(android.R.id.button1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bind_view)

        textView.text = getString(R.string.bind_activity_text)
        button.setOnClickListener {
            Toast.makeText(this@BindViewActivity, "Hello, bindView", Toast.LENGTH_SHORT).show()
        }
    }
}