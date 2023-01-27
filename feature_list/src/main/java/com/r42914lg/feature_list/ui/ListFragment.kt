package com.r42914lg.feature_list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.r42914lg.core.di.InjectCoreComponentUtils
import com.r42914lg.core.domain.remote.model.Category
import com.r42914lg.feature_list.databinding.ActivityListBinding
import com.r42914lg.feature_list.di.DaggerFeatureListComponent
import com.r42914lg.feature_list.di.FeatureListComponent
import com.r42914lg.feature_list.navigation.InjectNavFeatureListUtils
import com.r42914lg.feature_list.navigation.NavFeatureList
import com.r42914lg.utils.Resource
import com.r42914lg.utils.VmFactory

class ListFragment : Fragment(), ListAdapter.ClickListener {

    private var _binding: ActivityListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ListAdapter

    private lateinit var featureListComponent: FeatureListComponent
    private lateinit var navFeatureList: NavFeatureList

    private val listViewModel: ListViewModel by viewModels {
        VmFactory {
            featureListComponent.getVmFactory().create()
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

        featureListComponent  = DaggerFeatureListComponent
            .factory()
            .create(InjectCoreComponentUtils.provideCoreComponent(requireActivity().application))

        navFeatureList = InjectNavFeatureListUtils.provideNavFeatureDetails(requireActivity())

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navFeatureList.goBackFromList()
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
        navFeatureList.nextAction()
    }
}