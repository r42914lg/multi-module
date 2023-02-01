package com.r42914lg.core_impl.di

import android.app.Application
import com.r42914lg.module_injector.BaseDependencies

interface CoreDependencies : BaseDependencies {
    fun provideApplication(): Application
}