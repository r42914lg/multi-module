package com.r42914lg.mentor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.r42914lg.feature_details.navigation.NavFeatureDetailsProvider
import com.r42914lg.feature_list.navigation.NavFeatureListProvider
import com.r42914lg.mentor.databinding.ActivityMainBinding
import com.r42914lg.mentor.di.DaggerNavigationComponent
import com.r42914lg.mentor.di.NavigationComponent
import com.r42914lg.mentor.navigation.NavAppProvider

class MainActivity : AppCompatActivity(),
    NavFeatureDetailsProvider,
    NavFeatureListProvider,
    NavAppProvider
{

    private lateinit var binding: ActivityMainBinding
    private lateinit var navigationComponent: NavigationComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationComponent = DaggerNavigationComponent.factory().create(this)

        provideNavApp().toStart()
    }

    override fun provideNavApp() = navigationComponent.exposeNavApp()
    override fun provideNavFeatureDetails() = navigationComponent.exposeNavFeatureDetails()
    override fun provideNavFeatureList() = navigationComponent.exposeNavFeatureList()
}