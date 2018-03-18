package com.github.droibit.chopstick.sample.prefs.fragment

import android.os.Bundle
import android.support.v14.preference.PreferenceFragment
import android.support.v14.preference.SwitchPreference
import android.support.v7.preference.CheckBoxPreference
import android.support.v7.preference.EditTextPreference
import android.support.v7.preference.Preference
import android.view.View
import com.github.droibit.chopstick.preference.bindPreference
import com.github.droibit.chopstick.sample.R

class SettingsFragmentV14 : PreferenceFragment() {

  private val checkboxPref: CheckBoxPreference by bindPreference(R.string.key_checkbox_preference)
  private val switchPref: SwitchPreference by bindPreference("switch_preference")
  private val editPref: EditTextPreference by bindPreference(R.string.key_edittext_preference)
  private val listPref: Preference by bindPreference("list_preference")

  override fun onCreatePreferences(
    savedInstanceState: Bundle?,
    rootKey: String?
  ) {
    addPreferencesFromResource(R.xml.settings)
  }

  override fun onViewCreated(
    view: View?,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)

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
}