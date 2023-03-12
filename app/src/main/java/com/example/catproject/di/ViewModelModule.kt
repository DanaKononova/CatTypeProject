package com.example.catproject.di

import androidx.lifecycle.ViewModel
import com.example.catproject.ui.CatViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CatViewModel::class)
    fun bindLoginViewModel(viewModel: CatViewModel): ViewModel
}