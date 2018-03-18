package com.github.droibit.chopstick.sample.res

import android.content.Context
import com.github.droibit.chopstick.resource.Binder
import com.github.droibit.chopstick.resource.ResourceBinder
import com.github.droibit.chopstick.sample.R

class ResourceData(context: Context) : Binder by ResourceBinder(context) {

  val appName: String by bindString(R.string.app_name)
}