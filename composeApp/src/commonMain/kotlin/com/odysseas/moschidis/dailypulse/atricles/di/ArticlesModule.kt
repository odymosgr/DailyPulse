package com.odysseas.moschidis.dailypulse.atricles.di

import com.odysseas.moschidis.dailypulse.atricles.ArticlesDataSource
import com.odysseas.moschidis.dailypulse.atricles.ArticlesRepository
import com.odysseas.moschidis.dailypulse.atricles.ArticlesService
import com.odysseas.moschidis.dailypulse.atricles.ArticlesUseCase
import com.odysseas.moschidis.dailypulse.atricles.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}