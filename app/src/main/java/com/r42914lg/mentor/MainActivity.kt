package com.r42914lg.mentor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.r42914lg.core_impl.di.CoreComponentHolder
import com.r42914lg.feature_details.di.FeatureDetailsComponentHolder
import com.r42914lg.feature_list.di.FeatureListComponentHolder
import com.r42914lg.mentor.databinding.ActivityMainBinding
import com.r42914lg.mentor.di.ActivityComponent
import com.r42914lg.mentor.di.AppComponent
import com.r42914lg.mentor.di.DaggerActivityComponent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        val appComponent = AppComponent.get()
        ActivityComponent.init(DaggerActivityComponent.factory()
            .create(appComponent, this, supportFragmentManager))

        supportFragmentManager.fragmentFactory = ActivityComponent.get()
            .exposeFragmentFactory()

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ActivityComponent.get()
            .exposeAppNavigationApi()
            .startApp()
    }

    override fun onPause() {
        super.onPause()

        if (isFinishing) {
            FeatureListComponentHolder.reset()
            FeatureDetailsComponentHolder.reset()
            CoreComponentHolder.reset()
        }
    }
}