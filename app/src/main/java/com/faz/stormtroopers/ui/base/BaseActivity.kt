package com.faz.stormtroopers.ui.base

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    private val navController: NavController by lazy {
        findNavController(getNavControllerId())
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

    abstract fun getNavControllerId(): View
}