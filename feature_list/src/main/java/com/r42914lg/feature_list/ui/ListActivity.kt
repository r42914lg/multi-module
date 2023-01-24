package com.r42914lg.feature_list.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.r42914lg.core.di.DaggerCoreComponent
import com.r42914lg.feature_list.databinding.ActivityListBinding
import com.r42914lg.feature_list.di.DaggerFeatureListComponent
import com.r42914lg.feature_list.di.FeatureListComponent
import com.r42914lg.utils.Resource
import com.r42914lg.utils.VmFactory

class ListActivity : AppCompatActivity(), ListAdapter.ClickListener {

    private lateinit var binding: ActivityListBinding
    private lateinit var adapter: ListAdapter

    private lateinit var featureListComponent: FeatureListComponent

    private val listViewModel: ListViewModel by viewModels {
        VmFactory {
            featureListComponent.getVmFactory().create()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coreComponent = DaggerCoreComponent.factory().create(application)
        featureListComponent  = DaggerFeatureListComponent.factory().create(coreComponent)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                returnToMainWithAction(ACTION_BACK)
            }
        })

        initUi()
        getListItems()
    }

    private fun initUi() {
        binding.feedRecycler.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )

        adapter = ListAdapter(this)
        binding.feedRecycler.adapter = adapter
    }

    private fun getListItems() {
        listViewModel.getCategoryList().observe(this) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    adapter.setItems(it.data!!)
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun itemClicked(itemId: Int) {
        listViewModel.saveCategoryId(itemId)
        returnToMainWithAction(ACTION_NAVIGATE_TO_DETAILS)
    }

    private fun returnToMainWithAction(action: String) {
        val data = Intent()

        data.putExtra(EXTRA_NAME, action);
        setResult(Activity.RESULT_OK, data);

        finish()
    }

    companion object {
        const val EXTRA_NAME = "extra name"
        const val ACTION_NAVIGATE_TO_DETAILS = "to details"
        const val ACTION_BACK = "exit"
    }
}