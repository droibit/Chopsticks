package com.github.droibit.chopstick.sample.prefs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.CheckBoxPreference
import android.preference.EditTextPreference
import android.preference.Preference
import android.preference.SwitchPreference
import com.example.android.supportv7.app.AppCompatPreferenceActivity
import com.github.droibit.chopstick.bindPreference
import com.github.droibit.chopstick.sample.R

@Suppress("DEPRECATION")
class SettingsActivityCompat : AppCompatPreferenceActivity() {

    companion object {

        @JvmStatic
        fun makeIntent(context: Context) = Intent(context, SettingsActivityCompat::class.java)
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