package com.r42914lg.mentor.navigation

interface NavApp {
    fun toStart()
}

interface NavAppProvider {
    fun provideNavApp(): NavApp
}