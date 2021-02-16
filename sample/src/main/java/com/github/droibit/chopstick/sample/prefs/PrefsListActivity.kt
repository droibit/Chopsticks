package com.github.droibit.chopstick.sample.prefs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.github.droibit.chopstick.sample.R
import com.github.droibit.chopstick.view.bindView

class PrefsListActivity : AppCompatActivity() {

    private val listView: ListView by bindView(android.R.id.list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listView.adapter = ArrayAdapter.createFromResource(
            this, R.array.prefs_list_items,
            android.R.layout.simple_list_item_1
        )
        listView.setOnItemClickListener { _, _, i, _ -> launchActivity(position = i) }
    }

    private fun launchActivity(position: Int) {
        val intent = when (position) {
            PREFS_ACTIVITY -> SettingsActivity.makeIntent(this)
            PREFS_ACTIVITY_COMPAT -> SettingsActivityCompat.makeIntent(this)
            PREFS_FRAGMENT_ACTIVITY -> SettingsFragmentActivity.makeIntent(this)
            PREFS_FRAGMENT_COMPAT_ACTIVITY -> SettingsFragmentCompatActivity.makeIntent(this)
            else -> error("Invalid position: $position")
        }
        startActivity(intent)
    }

    companion object {
        private const val PREFS_ACTIVITY = 0
        private const val PREFS_ACTIVITY_COMPAT = 1
        private const val PREFS_FRAGMENT_ACTIVITY = 2
        private const val PREFS_FRAGMENT_COMPAT_ACTIVITY = 3

        @JvmStatic
        fun makeIntent(context: Context) = Intent(context, PrefsListActivity::class.java)
    }
}
