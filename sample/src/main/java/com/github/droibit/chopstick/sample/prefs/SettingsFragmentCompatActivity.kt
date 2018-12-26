package com.github.droibit.chopstick.sample.prefs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.droibit.chopstick.sample.R
import com.github.droibit.chopstick.sample.prefs.fragment.SettingsFragmentCompat

class SettingsFragmentCompatActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_settings_fragment)

    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
          .replace(android.R.id.content, SettingsFragmentCompat())
          .commitNow()
    }
  }

  companion object {
    @JvmStatic
    fun makeIntent(context: Context) = Intent(context, SettingsFragmentCompatActivity::class.java)
  }
}
