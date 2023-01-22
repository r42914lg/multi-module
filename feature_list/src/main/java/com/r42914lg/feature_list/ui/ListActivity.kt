package com.r42914lg.feature_list.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.r42914lg.feature_list.databinding.ActivityListBinding
import com.r42914lg.utils.Resource

class ListActivity : AppCompatActivity(), ListAdapter.ClickListener {

    private lateinit var binding: ActivityListBinding
    private lateinit var adapter: ListAdapter
    private val listViewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                returnToAppWithAction(ACTION_BACK)
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
        returnToAppWithAction(ACTION_NAVIGATE_TO_DETAILS)
    }

    private fun returnToAppWithAction(action: String) {
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