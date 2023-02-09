package com.r42914lg.db.api

import com.r42914lg.db.data.local.dao.CategoryDao
import com.r42914lg.module_injector.BaseAPI

interface DbApi: BaseAPI {
    fun dbClient(): CategoryDao
}