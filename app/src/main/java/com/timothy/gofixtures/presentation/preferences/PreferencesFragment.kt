package com.timothy.gofixtures.presentation.preferences

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.Preference
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceFragmentCompat
import com.timothy.gofixtures.R
import com.timothy.gofixtures.util.SharedPrefHelper

class PreferencesFragment : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    private lateinit var sharedPrefHelper: SharedPrefHelper
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
        sharedPrefHelper = SharedPrefHelper.getInstance(requireContext())
        init()
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    private fun init() {
        val themePreferenceKey = PREFERENCE_KEY_THEME
        val themePreference = findPreference<androidx.preference.Preference>(themePreferenceKey)
        val selectedOption = sharedPrefHelper.getSelectedThemePref()
        themePreference?.summary = selectedOption
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String?) {
        val themePreferenceKey = PREFERENCE_KEY_THEME
        if (key == themePreferenceKey) {
            val themePreference = findPreference<androidx.preference.Preference>(themePreferenceKey)
            val selectedOption = sharedPrefHelper.getSelectedThemePref()
            themePreference?.summary = selectedOption

            when (selectedOption) {
                getString(R.string.light_theme_value) -> setTheme(AppCompatDelegate.MODE_NIGHT_NO)
                getString(R.string.dark_theme_value) -> setTheme(AppCompatDelegate.MODE_NIGHT_YES)
                getString(R.string.follow_system_value) -> setTheme(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
    }

    private fun setTheme(mode: Int) {
        AppCompatDelegate.setDefaultNightMode(mode)
    }

    companion object {
        private const val PREFERENCE_KEY_THEME = "theme_key"
    }


}