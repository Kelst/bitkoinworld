package com.bitcoinworld.cryptostat.data.repository.settings

import com.bitcoinworld.cryptostat.data.local.prefs.PreferenceStorage
import javax.inject.Inject

/**
 * [SettingsRepository] is to manage preference for dark mode option
 */
class SettingsRepository @Inject constructor(private val preferenceStorage: PreferenceStorage) {

    fun isDarkModeEnabled(): Boolean {
        return preferenceStorage.isDarkMode
    }

    fun setThemeMode(isDarkMode: Boolean) {
        preferenceStorage.isDarkMode = isDarkMode
    }
}