package com.odysseas.moschidis.dailypulse.atricles.presentation

import com.odysseas.moschidis.dailypulse.atricles.application.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)