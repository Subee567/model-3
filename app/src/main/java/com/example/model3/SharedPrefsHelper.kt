package com.example.model3

import android.content.Context
import android.content.SharedPreferences

object SharedPrefsHelper {
    private const val PREFS_NAME = "app_prefs"
    private const val KEY_SIGNUP_STATUS = "signup_status"
    private const val KEY_USER_CHOICE = "user_choice"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun setSignupStatus(context: Context, isSignedUp: Boolean) {
        val prefs = getPreferences(context)
        prefs.edit().putBoolean(KEY_SIGNUP_STATUS, isSignedUp).apply()
    }

    fun getSignupStatus(context: Context): Boolean {
        val prefs = getPreferences(context)
        return prefs.getBoolean(KEY_SIGNUP_STATUS, false)
    }

    fun setUserChoice(context: Context, choice: String) {
        val prefs = getPreferences(context)
        prefs.edit().putString(KEY_USER_CHOICE, choice).apply()
    }

    fun getUserChoice(context: Context): String? {
        val prefs = getPreferences(context)
        return prefs.getString(KEY_USER_CHOICE, "mentor")
    }
}
