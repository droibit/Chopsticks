package com.github.droibit.chopsticks.sample.prefs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.*
import com.github.droibit.chopsticks.preference.bindPreference
import com.github.droibit.chopsticks.sample.R

class SettingsActivity : PreferenceActivity() {

    companion object {
        @JvmStatic
        fun makeIntent(context: Context) = Intent(context, SettingsActivity::class.java)
    }

    private val checkboxPref: CheckBoxPreference by bindPreference(R.string.key_checkbox_preference)
    private val switchPref: SwitchPreference by bindPreference("switch_preference")
    private val editPref: EditTextPreference by bindPreference(R.string.key_edittext_preference)
    private val listPref: Preference by bindPreference("list_preference")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.settings)

        checkboxPref.isChecked = false
        checkboxPref.title = "Edited: ${checkboxPref.title}"

        switchPref.isChecked = false
        switchPref.title = "Edited: ${switchPref.title}"

        editPref.title = "Edited: ${editPref.title}"

        listPref.title = "Edited: ${listPref.title}"
    }
}
