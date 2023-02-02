package com.r42914lg.mentor.di

import androidx.fragment.app.Fragment
import com.r42914lg.feature_details.impl.ui.DetailsFragment
import com.r42914lg.feature_list.impl.ui.ListFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentsModule {
    @Binds
    @IntoMap
    @FragmentKey(ListFragment::class)
    abstract fun listFragment(listFragment: ListFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(DetailsFragment::class)
    abstract fun detailFragment(detailFragment: DetailsFragment): Fragment
}