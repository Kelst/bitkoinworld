package com.bitcoinworld.cryptostat.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.bitcoinworld.cryptostat.R
import com.bitcoinworld.cryptostat.core.common.BaseActivity
import com.bitcoinworld.cryptostat.core.common.NavigationHost
import com.bitcoinworld.cryptostat.util.ThemeHelper
import com.bitcoinworld.cryptostat.util.ThemeMode
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class HomeActivity : BaseActivity(),
    NavigationHost {

    private val viewModel: HomeActivityViewModel by viewModels()

    companion object {
        private val TOP_LEVEL_DESTINATIONS = setOf(
            R.id.navigation_coins_list,
            R.id.navigation_favourites,
            R.id.navigation_settings
        )
    }

    private lateinit var navController: NavController
    private var navHostFragment: NavHostFragment? = null
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ThemeHelper.applyTheme(if (viewModel.isDarkModeOn()) ThemeMode.Dark else ThemeMode.Light)

        setContentView(R.layout.activity_main)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.homeNavHostFragment) as? NavHostFragment
                ?: return

        navController = findNavController(R.id.homeNavHostFragment)
        appBarConfiguration = AppBarConfiguration(TOP_LEVEL_DESTINATIONS)

        homeBottomNavView.setupWithNavController(navController)
    }

    //Callback method to update the toolbar's title based on the selected bottom tab
    override fun registerToolbarWithNavigation(toolbar: Toolbar) {
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}