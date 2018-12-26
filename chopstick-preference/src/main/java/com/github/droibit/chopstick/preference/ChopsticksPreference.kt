package com.github.droibit.chopstick.preference

import android.preference.Preference
import android.preference.PreferenceActivity
import android.preference.PreferenceFragment
import androidx.annotation.StringRes
import androidx.preference.PreferenceFragmentCompat
import kotlin.LazyThreadSafetyMode.NONE
import androidx.preference.Preference as PreferenceCompat

fun <P : PreferenceCompat> PreferenceFragmentCompat.bindPreference(@StringRes resId: Int): Lazy<P> =
  requiredCompat { findPreference(getString(resId)) }

@Suppress("DEPRECATION")
@Deprecated(
    "This function is not relevant for a modern fragment-base PreferenceActivity.",
    ReplaceWith("PreferenceFragment.bindPreference(Int)"),
    level = DeprecationLevel.WARNING
)
fun <P : Preference> PreferenceActivity.bindPreference(@StringRes resId: Int): Lazy<P> =
  required { findPreference(getString(resId)) }

fun <P : PreferenceCompat> PreferenceFragmentCompat.bindPreference(key: String): Lazy<P> =
  requiredCompat { findPreference(key) }

@Suppress("DEPRECATION")
@Deprecated(
    "This function is not relevant for a modern fragment-base PreferenceActivity.",
    ReplaceWith("PreferenceFragment.bindPreference(String)"),
    level = DeprecationLevel.WARNING
)
fun <P : Preference> PreferenceActivity.bindPreference(key: String): Lazy<P> =
  required { findPreference(key) }

fun <P : Preference> PreferenceFragment.bindPreference(@StringRes resId: Int): Lazy<P> =
  required { findPreference(getString(resId)) }

fun <P : Preference> PreferenceFragment.bindPreference(key: String): Lazy<P> =
  required { findPreference(key) }

@Suppress("UNCHECKED_CAST")
private inline fun <P : Preference> required(crossinline finder: () -> Preference?): Lazy<P> =
  lazy(NONE) { requireNotNull(finder()) as P }

@Suppress("UNCHECKED_CAST")
private inline fun <P : PreferenceCompat> requiredCompat(crossinline finder: () -> PreferenceCompat?) =
  lazy(NONE) { requireNotNull(finder()) as P }
