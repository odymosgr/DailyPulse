package com.odysseas.moschidis.dailypulse.atricles.di

import com.odysseas.moschidis.dailypulse.atricles.data.ArticlesDataSource
import com.odysseas.moschidis.dailypulse.atricles.data.ArticlesRepository
import com.odysseas.moschidis.dailypulse.atricles.data.ArticlesService
import com.odysseas.moschidis.dailypulse.atricles.application.ArticlesUseCase
import com.odysseas.moschidis.dailypulse.atricles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}