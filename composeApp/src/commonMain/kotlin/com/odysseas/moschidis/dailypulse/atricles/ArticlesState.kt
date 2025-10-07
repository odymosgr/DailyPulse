package com.odysseas.moschidis.dailypulse.atricles

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
