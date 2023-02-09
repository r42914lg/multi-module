package com.r42914lg.core_other

import android.util.Log

inline fun <reified T> T.log(message: String) {
    if (BuildConfig.DEBUG)
        Log.d("LG>" + T::class.java.simpleName, message)
}