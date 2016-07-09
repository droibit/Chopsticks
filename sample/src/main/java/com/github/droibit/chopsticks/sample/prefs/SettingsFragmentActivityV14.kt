package com.github.droibit.chopsticks.sample.prefs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.droibit.chopsticks.sample.R
import com.github.droibit.chopsticks.sample.prefs.fragment.SettingsFragmentV14

class SettingsFragmentActivityV14 : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun makeIntent(context: Context) = Intent(context, SettingsFragmentActivityV14::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_fragment)

        fragmentManager.beginTransaction()
                .replace(android.R.id.content, SettingsFragmentV14())
                .commit()
    }
}
