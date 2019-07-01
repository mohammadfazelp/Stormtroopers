package com.faz.stormtroopers.ui

import android.os.Bundle
import android.view.Window
import com.faz.stormtroopers.R
import com.faz.stormtroopers.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTION_BAR)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
    }

    override fun getNavControllerId(): Int = R.id.fragment_trips
}