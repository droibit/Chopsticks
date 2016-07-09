package com.github.droibit.chopsticks.sample.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.github.droibit.chopsticks.Binder
import com.github.droibit.chopsticks.SupportFragmentBinder
import com.github.droibit.chopsticks.bindView
import com.github.droibit.chopsticks.sample.R

class BindViewFragmentActivity : AppCompatActivity() {

    companion object {

        @JvmStatic
        fun makeIntent(context: Context) = Intent(context, BindViewFragmentActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_bind_view)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.content, BindViewFragment())
                    .commit()
        }
    }
}

class BindViewFragment : Fragment(), Binder<Fragment> by SupportFragmentBinder() {

    val textView: TextView by bindView(android.R.id.text1)
    val button: Button by bindView(android.R.id.button1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_bind_view, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView.text = getString(R.string.bind_fragment_text)
        button.setOnClickListener {
            Toast.makeText(context, "Hello, bindView", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        unbindViews()
        super.onDestroyView()
    }
}