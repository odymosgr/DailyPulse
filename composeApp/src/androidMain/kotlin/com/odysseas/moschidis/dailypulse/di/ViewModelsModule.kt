package com.odysseas.moschidis.dailypulse.di

import com.odysseas.moschidis.dailypulse.atricles.presentation.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { ArticlesViewModel(get()) }
}