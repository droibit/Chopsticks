package com.github.droibit.chopstick.sample.prefs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.CheckBoxPreference
import android.preference.EditTextPreference
import android.preference.Preference
import android.preference.PreferenceActivity
import android.preference.SwitchPreference
import com.github.droibit.chopstick.preference.bindPreference
import com.github.droibit.chopstick.sample.R

@Suppress("DEPRECATION")
class SettingsActivity : PreferenceActivity() {

  private val checkboxPref: CheckBoxPreference by bindPreference(R.string.key_checkbox_preference)
  private val switchPref: SwitchPreference by bindPreference("switch_preference")
  private val editPref: EditTextPreference by bindPreference(R.string.key_edittext_preference)
  private val listPref: Preference by bindPreference("list_preference")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    addPreferencesFromResource(R.xml.settings)

    checkboxPref.apply {
      isChecked = false
      title = "Edited: ${checkboxPref.title}"
    }
    switchPref.apply {
      isChecked = false
      title = "Edited: ${switchPref.title}"
    }
    editPref.title = "Edited: ${editPref.title}"
    listPref.title = "Edited: ${listPref.title}"
  }

  companion object {
    @JvmStatic
    fun makeIntent(context: Context) = Intent(context, SettingsActivity::class.java)
  }
}
