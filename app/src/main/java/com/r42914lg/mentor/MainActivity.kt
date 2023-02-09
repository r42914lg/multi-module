package com.r42914lg.mentor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.r42914lg.mentor.databinding.ActivityMainBinding
import com.r42914lg.mentor.di.ActivityComponent
import com.r42914lg.mentor.di.AppComponent
import com.r42914lg.mentor.di.DaggerActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var activityNavigationContract: ActivityNavigationContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ActivityComponent.init(
            DaggerActivityComponent
                .factory()
                .create(
                    AppComponent.get(),
                    this,
                    supportFragmentManager
                )
        )

        ActivityComponent.get().inject(this)

        activityNavigationContract.startApp()
    }
}