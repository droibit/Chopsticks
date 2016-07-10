package com.github.droibit.chopstick.sample.prefs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import com.github.droibit.chopstick.bindView
import com.github.droibit.chopstick.sample.R

class PrefsListActivity : AppCompatActivity() {

    companion object {
        private const val PREFS_ACTIVITY = 0
        private const val PREFS_ACTIVITY_COMPAT = 1
        private const val PREFS_FRAGMENT_ACTIVITY = 2
        private const val PREFS_SUPPORT_V7_ACTIVITY = 3
        private const val PREFS_SUPPORT_V14_ACTIVITY = 4

        @JvmStatic
        fun makeIntent(context: Context) = Intent(context, PrefsListActivity::class.java)
    }

    private val listView: ListView by bindView(android.R.id.list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listView.adapter = ArrayAdapter.createFromResource(this, R.array.prefs_list_items,
                android.R.layout.simple_list_item_1)
        listView.setOnItemClickListener { adapterView, view, i, l -> launchActivity(i) }
    }

    private fun launchActivity(position: Int) {
        when (position) {
            PREFS_ACTIVITY -> startActivity(SettingsActivity.makeIntent(this))
            PREFS_ACTIVITY_COMPAT -> startActivity(SettingsActivityCompat.makeIntent(this))
            PREFS_FRAGMENT_ACTIVITY -> startActivity(SettingsFragmentActivity.makeIntent(this))
            PREFS_SUPPORT_V7_ACTIVITY -> startActivity(SettingsFragmentActivityV7.makeIntent(this))
            PREFS_SUPPORT_V14_ACTIVITY -> startActivity(SettingsFragmentActivityV14.makeIntent(this))
        }
    }
}
