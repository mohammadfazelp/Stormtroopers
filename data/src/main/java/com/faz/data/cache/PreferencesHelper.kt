package com.faz.data.cache

import android.content.Context
import android.content.SharedPreferences

import javax.inject.Inject
import javax.inject.Singleton

/**
 * General Preferences Helper class, used for storing preference values using the Preference API
 */
@Singleton
class PreferencesHelper @Inject constructor(context: Context) {

    companion object {
        private const val PREF_TRIP_PACKAGE_NAME = "com.faz.data.cache.preferences"

        private const val PREF_KEY_LAST_CACHE = "last_cache"
    }

    private val tripPref: SharedPreferences

    init {
        tripPref = context.getSharedPreferences(PREF_TRIP_PACKAGE_NAME, Context.MODE_PRIVATE)
    }

    /**
     * Store and retrieve the last time data was cached
     */
    var lastCacheTime: Long
        get() = tripPref.getLong(PREF_KEY_LAST_CACHE, 0)
        set(lastCache) = tripPref.edit().putLong(PREF_KEY_LAST_CACHE, lastCache).apply()

}
