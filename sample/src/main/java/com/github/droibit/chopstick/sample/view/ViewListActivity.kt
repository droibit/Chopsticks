package com.github.droibit.chopstick.sample.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import com.github.droibit.chopstick.sample.R
import com.github.droibit.chopstick.view.bindView

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

    listView.adapter = ArrayAdapter.createFromResource(
        this, R.array.view_list_items,
        android.R.layout.simple_list_item_1
    )
    listView.setOnItemClickListener { _, _, i, _ -> launchActivity(position = i) }
  }

  private fun launchActivity(position: Int) {
    when (position) {
      BIND_VIEW_ACTIVITY -> startActivity(BindViewActivity.makeIntent(this))
      BIND_VIEW_FRAGMENT_ACTIVITY -> startActivity(BindViewFragmentActivity.makeIntent(this))
    }
  }
}
