package com.cmaina.presentation.di

import com.cmaina.presentation.viewmodels.HomeViewModel
import com.cmaina.presentation.viewmodels.PhotoDetailsViewModel
import com.cmaina.presentation.viewmodels.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::PhotoDetailsViewModel)
    viewModelOf(::UserViewModel)
}