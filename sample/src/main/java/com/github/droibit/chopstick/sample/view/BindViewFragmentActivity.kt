package com.github.droibit.chopstick.sample.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.github.droibit.chopstick.sample.R
import com.github.droibit.chopstick.view.Binder
import com.github.droibit.chopstick.view.SupportFragmentViewBinder

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

class BindViewFragment : androidx.fragment.app.Fragment(), Binder<androidx.fragment.app.Fragment> by SupportFragmentViewBinder() {

  private val textView: TextView by bindView(android.R.id.text1)
  private val button: Button by bindView(android.R.id.button1)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    retainInstance = true
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.fragment_bind_view, container, false)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)

    textView.text = getString(R.string.bind_fragment_text)
    button.setOnClickListener {
      Toast.makeText(context, "Hello, bindView", Toast.LENGTH_SHORT)
          .show()
    }
  }

  override fun onDestroyView() {
    unbindViews()
    super.onDestroyView()
  }
}