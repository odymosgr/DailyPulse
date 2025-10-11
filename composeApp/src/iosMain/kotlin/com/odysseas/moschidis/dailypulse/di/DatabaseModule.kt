package com.odysseas.moschidis.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.odysseas.moschidis.dailypulse.db.DailyPulseDatabase
import com.odysseas.moschidis.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}