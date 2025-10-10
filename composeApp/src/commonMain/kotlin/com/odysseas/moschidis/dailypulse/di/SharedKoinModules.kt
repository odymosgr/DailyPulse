package com.odysseas.moschidis.dailypulse.di

import com.odysseas.moschidis.dailypulse.atricles.di.articlesModule

val sharedKoinModules = listOf(
    articlesModule,
    networkModule
)