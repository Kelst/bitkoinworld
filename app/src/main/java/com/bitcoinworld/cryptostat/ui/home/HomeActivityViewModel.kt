package com.bitcoinworld.cryptostat.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import com.bitcoinworld.cryptostat.core.common.BaseViewModel
import com.bitcoinworld.cryptostat.data.repository.settings.SettingsRepository

class HomeActivityViewModel @ViewModelInject constructor(private val repository: SettingsRepository) : BaseViewModel() {

    fun isDarkModeOn () : Boolean{
        return repository.isDarkModeEnabled()
    }
}