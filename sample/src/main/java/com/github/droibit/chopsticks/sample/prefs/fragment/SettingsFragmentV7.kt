package com.github.droibit.chopsticks.sample.prefs.fragment

import android.os.Bundle
import android.support.v7.preference.*
import android.view.View
import com.github.droibit.chopsticks.preference.bindPreference
import com.github.droibit.chopsticks.sample.R

class SettingsFragmentV7: PreferenceFragmentCompat() {

    private val checkboxPref: CheckBoxPreference by bindPreference(R.string.key_checkbox_preference)
    private val switchPref: SwitchPreferenceCompat by bindPreference("switch_preference")
    private val editPref: EditTextPreference by bindPreference(R.string.key_edittext_preference)
    private val listPref: Preference by bindPreference("list_preference")

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.settings_support_v7)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkboxPref.isChecked = false
        checkboxPref.title = "Edited: ${checkboxPref.title}"

        switchPref.isChecked = false
        switchPref.title = "Edited: ${switchPref.title}"

        editPref.title = "Edited: ${editPref.title}"

        listPref.title = "Edited: ${listPref.title}"
    }
}