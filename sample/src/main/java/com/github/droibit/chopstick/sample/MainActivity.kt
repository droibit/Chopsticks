package com.github.droibit.chopstick.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import com.github.droibit.chopstick.bindView
import com.github.droibit.chopstick.sample.prefs.PrefsListActivity
import com.github.droibit.chopstick.sample.view.ViewListActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private const val VIEW_LIST_ACTIVITY = 0
        private const val PREFS_LIST_ACTIVITY = 1
    }

    private val listView: ListView by bindView(android.R.id.list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listView.adapter = ArrayAdapter.createFromResource(this, R.array.main_list_items,
                android.R.layout.simple_list_item_1)
        listView.setOnItemClickListener { adapterView, view, i, l -> launchActivity(i) }
    }

    private fun launchActivity(position: Int) {
        when (position) {
            VIEW_LIST_ACTIVITY -> startActivity(ViewListActivity.makeIntent(this))
            PREFS_LIST_ACTIVITY -> startActivity(PrefsListActivity.makeIntent(this))
        }
    }
}
