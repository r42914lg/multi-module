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
import com.r42914lg.feature_list.api.FeatureListNavigationContract
import com.r42914lg.feature_list.databinding.ActivityListBinding
import com.r42914lg.feature_list.di.FeatureListComponentHolder
import com.r42914lg.utils.Resource
import com.r42914lg.core_api.vmfactory.VmFactory
import javax.inject.Inject

class ListFragment : Fragment(), ListAdapter.ClickListener {

    private var _binding: ActivityListBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var featureListNavigationContract: FeatureListNavigationContract

    @Inject
    lateinit var vmFactory: ListViewModel.Factory

    private lateinit var adapter: ListAdapter

    private val listViewModel: ListViewModel by viewModels {
        VmFactory {
            vmFactory.create()
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

        FeatureListComponentHolder.get().inject(this)

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                featureListNavigationContract.goBackFromList()
            }
        })

        initUi()
        getListItems()
    }

    override fun onPause() {
        super.onPause()

        if (isRemoving) {
            FeatureListComponentHolder.reset()
        }
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
        featureListNavigationContract.nextAction()
    }
}