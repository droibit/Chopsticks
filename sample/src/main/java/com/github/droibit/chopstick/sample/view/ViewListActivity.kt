package com.github.droibit.chopstick.sample.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import com.github.droibit.chopstick.bindView
import com.github.droibit.chopstick.sample.R

class ViewListActivity : AppCompatActivity() {

    companion object {

        private const val BIND_VIEW_ACTIVITY = 0
        private const val BIND_VIEW_FRAGMENT_ACTIVITY = 1

        @JvmStatic
        fun makeIntent(context: Context) = Intent(context, ViewListActivity::class.java)
    }

    private val listView: ListView by bindView(android.R.id.list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listView.adapter = ArrayAdapter.createFromResource(this, R.array.view_list_items,
                android.R.layout.simple_list_item_1)
        listView.setOnItemClickListener { adapterView, view, i, l -> launchActivity(i) }
    }

    private fun launchActivity(position: Int) {
        when (position) {
            BIND_VIEW_ACTIVITY -> startActivity(BindViewActivity.makeIntent(this))
            BIND_VIEW_FRAGMENT_ACTIVITY -> startActivity(BindViewFragmentActivity.makeIntent(this))
        }
    }
}
