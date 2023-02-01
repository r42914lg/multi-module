package com.r42914lg.feature_list.impl.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.r42914lg.feature_list.databinding.ActivityListBinding
import com.r42914lg.feature_list.di.FeatureListDependencies
import com.r42914lg.utils.Resource
import com.r42914lg.utils.VmFactory

class ListFragment : Fragment(), ListAdapter.ClickListener {

    private var _binding: ActivityListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ListAdapter

    private lateinit var featureListDependencies: FeatureListDependencies

    private val listViewModel: ListViewModel by viewModels {
        VmFactory {
            featureListDependencies.getVmFactory().create()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)

        _binding = ActivityListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        featureListComponent  = DaggerFeatureListComponent
//            .factory()
//            .create(InjectCoreComponentUtils.provideCoreComponent(requireActivity().application))
//
//        navFeatureList = InjectNavFeatureListUtils.provideNavFeatureDetails(requireActivity())

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                featureListDependencies.goBackFromList()
            }
        })

        initUi()
        getListItems()
    }

    private fun initUi() {
        binding.feedRecycler.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )

        adapter = ListAdapter(this)
        binding.feedRecycler.adapter = adapter
    }

    private fun getListItems() {
        listViewModel.getCategoryList().observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    adapter.setItems(it.data!!)
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun itemClicked(itemId: Int) {
        listViewModel.saveCategoryId(itemId)
        featureListDependencies.nextAction()
    }
}