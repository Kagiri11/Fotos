package com.cmaina.presentation.di

import com.cmaina.presentation.activities.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationTestModule = module {
    viewModelOf(::MainViewModel)
}
