package com.r42914lg.feature_details.impl.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.r42914lg.core_api.domain.remote.model.CategoryDetailed
import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.feature_details.databinding.ActivityDetailsBinding
import com.r42914lg.utils.Resource
import com.r42914lg.utils.VmFactory
import javax.inject.Inject

class DetailsFragment @Inject constructor(
    private val featureDetailsNavigationContract: FeatureDetailsNavigationContract,
    private val vmFactory: DetailsViewModel.Factory
): Fragment() {

    private var _binding: ActivityDetailsBinding? = null
    private val binding get() = _binding!!

    private val detailsViewModel: DetailsViewModel by viewModels {
        VmFactory {
            vmFactory.create()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                featureDetailsNavigationContract.goBackFromDetails()
            }
        })

        setUpObserver()
    }

    private fun setUpObserver() {
        detailsViewModel.categoryDetailed.observe(viewLifecycleOwner) { catId ->
            if (catId == -1)
                return@observe

            detailsViewModel.getDetails().observe(viewLifecycleOwner) {
                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        initUi(it.data!!)
                    }
                    Resource.Status.ERROR -> {
                        Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_SHORT).show()
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
}