package com.r42914lg.feature_details.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import com.r42914lg.core.di.DaggerCoreComponent
import com.r42914lg.core.domain.remote.model.CategoryDetailed
import com.r42914lg.feature_details.databinding.ActivityDetailsBinding
import com.r42914lg.feature_details.di.DaggerFeatureDetailsComponent
import com.r42914lg.feature_details.di.FeatureDetailsComponent
import com.r42914lg.utils.Resource
import com.r42914lg.utils.VmFactory

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var featureDetailsComponent: FeatureDetailsComponent

    private val detailsViewModel: DetailsViewModel by viewModels {
        VmFactory {
            featureDetailsComponent.getVmFactory().create()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                returnToMainWithAction(ACTION_NAVIGATE_TO_LIST)
            }
        })

        val coreComponent = DaggerCoreComponent.factory().create(application)
        featureDetailsComponent  = DaggerFeatureDetailsComponent.factory().create(coreComponent)

        setUpObserver()
    }

    private fun setUpObserver() {
        detailsViewModel.categoryDetailed.observe(this) { catId ->
            if (catId == -1)
                return@observe

            detailsViewModel.getDetails().observe(this) {
                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        initUi(it.data!!)
                    }
                    Resource.Status.ERROR -> {
                        Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initUi(data: CategoryDetailed) = with(binding) {
        detailCategoryId.text = "Category ID: ${data.id}"
        detailCategoryTitle.text = "Description: ${data.title}"
        detailCluesCount.text = "Clue count: ${data.cluesCount}"

        val buffer = StringBuffer()
        data.clues.forEach {
                clue -> buffer.append(clue.asString())
        }

        binding.detailClues.text = buffer
    }

    private fun returnToMainWithAction(action: String) {
        val data = Intent()

        data.putExtra(EXTRA_NAME, action);
        setResult(Activity.RESULT_OK, data);

        finish()
    }

    companion object {
        const val EXTRA_NAME = "extra name"
        const val ACTION_NAVIGATE_TO_LIST = "to list"
    }
}