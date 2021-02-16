package com.github.droibit.chopstick.sample.prefs.fragment

import android.os.Bundle
import android.view.View
import androidx.preference.CheckBoxPreference
import androidx.preference.EditTextPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat
import com.github.droibit.chopstick.preference.bindPreference
import com.github.droibit.chopstick.sample.R

class SettingsFragmentCompat : PreferenceFragmentCompat() {

    private val checkboxPref: CheckBoxPreference by bindPreference(R.string.key_checkbox_preference)
    private val switchPref: SwitchPreferenceCompat by bindPreference("switch_preference")
    private val editPref: EditTextPreference by bindPreference(R.string.key_edittext_preference)
    private val listPref: Preference by bindPreference("list_preference")

    override fun onCreatePreferences(
        savedInstanceState: Bundle?,
        rootKey: String?
    ) {
        addPreferencesFromResource(R.xml.settings_androidx)
    }

    override fun onViewCreated(
        view: View,
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
