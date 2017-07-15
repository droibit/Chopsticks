package com.github.droibit.chopstick

import android.preference.Preference
import android.preference.PreferenceActivity
import android.preference.PreferenceFragment
import android.support.annotation.StringRes
import android.support.v14.preference.PreferenceFragment as PreferenceFragmentV14
import android.support.v7.preference.Preference as PreferenceCompat
import android.support.v7.preference.PreferenceFragmentCompat

fun <P : PreferenceCompat> PreferenceFragmentCompat.bindPreference(@StringRes resId: Int): Lazy<P>
        = requireCompat { findPreference(getString(resId)) }

fun <P : PreferenceCompat> PreferenceFragmentCompat.bindPreference(key: String): Lazy<P>
        = requireCompat { findPreference(key) }

fun <P : PreferenceCompat> PreferenceFragmentV14.bindPreference(@StringRes resId: Int): Lazy<P>
        = requireCompat { findPreference(getString(resId)) }

fun <P : PreferenceCompat> PreferenceFragmentV14.bindPreference(key: String): Lazy<P>
        = requireCompat { findPreference(key) }

@Suppress("UNCHECKED_CAST")
private inline fun <P : PreferenceCompat> requireCompat(crossinline finder: () -> PreferenceCompat?)
        = lazy { requireNotNull(finder()) as P }

@Deprecated(
        "This function is not relevant for a modern fragment-base PreferenceActivity.",
        ReplaceWith("PreferenceFragment.bindPreference(Int)"),
        level = DeprecationLevel.WARNING
)
fun <P : Preference> PreferenceActivity.bindPreference(@StringRes resId: Int): Lazy<P>
        = require { findPreference(getString(resId)) }

@Deprecated(
        "This function is not relevant for a modern fragment-base PreferenceActivity.",
        ReplaceWith("PreferenceFragment.bindPreference(String)"),
        level = DeprecationLevel.WARNING
)
fun <P : Preference> PreferenceActivity.bindPreference(key: String): Lazy<P>
        = require { findPreference(key) }

fun <P : Preference> PreferenceFragment.bindPreference(@StringRes resId: Int): Lazy<P>
        = require { findPreference(getString(resId)) }

fun <P : Preference> PreferenceFragment.bindPreference(key: String): Lazy<P>
        = require { findPreference(key) }

@Suppress("UNCHECKED_CAST")
private inline fun <P : Preference> require(crossinline finder: () -> Preference?)
        = lazy { requireNotNull(finder()) as P }