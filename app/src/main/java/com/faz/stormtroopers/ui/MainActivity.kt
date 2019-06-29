package com.faz.stormtroopers.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.faz.stormtroopers.R
import com.faz.stormtroopers.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), HasSupportFragmentInjector {

    /**
     * Rather than injecting the ViewModelFactory in the activity, we are going to implement the
     * HasActivityInjector and inject the ViewModelFactory into our MovieListFragment
     **/
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var binding: ActivityMainBinding

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

    private val navController: NavController by lazy {
        findNavController(this, R.id.fragment_trips)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * We need to inject this method into our activity so that our fragment can inject the ViewModelFactory
         * **/
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}
