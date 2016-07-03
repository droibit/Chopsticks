package com.github.droibit.chopsticks.sample.prefs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.droibit.chopsticks.sample.R
import com.github.droibit.chopsticks.sample.prefs.fragment.SettingsFragmentV7

class SettingsFragmentActivityV7 : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun makeIntent(context: Context) = Intent(context, SettingsFragmentActivityV7::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_fragment)

        supportFragmentManager.beginTransaction().apply {
            replace(android.R.id.content, SettingsFragmentV7())
        }.commit()
    }
}
