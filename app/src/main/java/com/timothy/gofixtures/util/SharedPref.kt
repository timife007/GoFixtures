package com.timothy.gofixtures.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.core.content.edit
import com.google.gson.Gson

class SharedPrefHelper {
    companion object {
        private var prefs: SharedPreferences? = null


        @Volatile
        private var instance: SharedPrefHelper? = null


        /**
         * This checks if there is an existing instance of the [SharedPreferences] in the
         * specified [context] and creates one if there isn't or else, it returns the
         * already existing instance. This function ensures that the [SharedPreferences] is
         * accessed at any instance by a single thread.
         */
        fun getInstance(context: Context): SharedPrefHelper {
            synchronized(this) {
                val _instance = instance
                if (_instance == null) {
                    prefs = PreferenceManager.getDefaultSharedPreferences(context)
                    instance = _instance
                }
                return SharedPrefHelper()
            }
        }
    }

    /**
     * This function gets the value of the app theme the user set in the
     * Settings Fragment.
     */
    fun getSelectedThemePref() = prefs?.getString("theme_key", "")

}