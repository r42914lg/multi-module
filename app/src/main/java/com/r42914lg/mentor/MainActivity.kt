package com.r42914lg.mentor

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts

import com.r42914lg.feature_details.ui.DetailsActivity
import com.r42914lg.feature_list.ui.ListActivity
import com.r42914lg.feature_list.ui.ListActivity.Companion.ACTION_BACK
import com.r42914lg.feature_list.ui.ListActivity.Companion.ACTION_NAVIGATE_TO_DETAILS
import com.r42914lg.feature_list.ui.ListActivity.Companion.EXTRA_NAME

class MainActivity : AppCompatActivity() {

    private val resultLauncher = registerForActivityResult(ActivityResultContracts
        .StartActivityForResult()) { result ->

        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            handleResponseFromListActivity(data?.getStringExtra(EXTRA_NAME))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, ListActivity::class.java)
        resultLauncher.launch(intent)
    }

    private fun handleResponseFromListActivity(action: String?) {
        when (action) {
            ACTION_NAVIGATE_TO_DETAILS -> startActivity(Intent(
                this,
                DetailsActivity::class.java)
            )
            ACTION_BACK -> finish()
        }
    }
}