package com.github.droibit.chopstick.preference

import android.preference.Preference
import android.preference.PreferenceActivity
import android.preference.PreferenceFragment
import androidx.annotation.StringRes
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.Preference as PreferenceV7

fun <P : PreferenceV7> PreferenceFragmentCompat.bindPreference(@StringRes resId: Int): Lazy<P> =
  requireV7 { findPreference(getString(resId)) }

fun <P : PreferenceV7> PreferenceFragmentCompat.bindPreference(key: String): Lazy<P> =
  requireV7 { findPreference(key) }

@Suppress("UNCHECKED_CAST")
private inline fun <P : PreferenceV7> requireV7(crossinline finder: () -> PreferenceV7?) =
  lazy { requireNotNull(finder()) as P }

@Suppress("DEPRECATION")
@Deprecated(
    "This function is not relevant for a modern fragment-base PreferenceActivity.",
    ReplaceWith("PreferenceFragment.bindPreference(Int)"),
    level = DeprecationLevel.WARNING
)
fun <P : Preference> PreferenceActivity.bindPreference(@StringRes resId: Int): Lazy<P> =
  require { findPreference(getString(resId)) }

@Suppress("DEPRECATION")
@Deprecated(
    "This function is not relevant for a modern fragment-base PreferenceActivity.",
    ReplaceWith("PreferenceFragment.bindPreference(String)"),
    level = DeprecationLevel.WARNING
)
fun <P : Preference> PreferenceActivity.bindPreference(key: String): Lazy<P> =
  require { findPreference(key) }

fun <P : Preference> PreferenceFragment.bindPreference(@StringRes resId: Int): Lazy<P> =
  require { findPreference(getString(resId)) }

fun <P : Preference> PreferenceFragment.bindPreference(key: String): Lazy<P> =
  require { findPreference(key) }

@Suppress("UNCHECKED_CAST")
private inline fun <P : Preference> require(crossinline finder: () -> Preference?) =
  lazy { requireNotNull(finder()) as P }