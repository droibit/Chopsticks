package com.github.droibit.chopstick.sample.prefs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.droibit.chopstick.sample.R
import com.github.droibit.chopstick.sample.prefs.fragment.SettingsFragment

class SettingsFragmentActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_settings_fragment)

    if (savedInstanceState == null) {
      fragmentManager.beginTransaction()
          .replace(android.R.id.content, SettingsFragment())
          .commit()
    }
  }

  companion object {
    @JvmStatic
    fun makeIntent(context: Context) = Intent(context, SettingsFragmentActivity::class.java)
  }
}
