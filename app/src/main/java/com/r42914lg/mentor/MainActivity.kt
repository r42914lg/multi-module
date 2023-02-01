package com.r42914lg.mentor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.r42914lg.mentor.databinding.ActivityMainBinding
import com.r42914lg.mentor.di.ActivityComponent
import com.r42914lg.mentor.di.AppComponent
import com.r42914lg.mentor.di.DaggerActivityComponent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val appComponent = AppComponent.get()

        ActivityComponent.init(DaggerActivityComponent.factory()
            .create(appComponent, this))

        ActivityComponent.get()
            .exposeAppNavigationApi()
            .startApp()
    }
}