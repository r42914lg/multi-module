package com.r42914lg.feature_details.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.r42914lg.core.domain.remote.model.CategoryDetailed
import com.r42914lg.feature_details.databinding.ActivityDetailsBinding
import com.r42914lg.utils.Resource

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val detailsViewModel: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpObserver()
    }

    private fun setUpObserver() {
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
}