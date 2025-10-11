package com.odysseas.moschidis.dailypulse.atricles

import com.odysseas.moschidis.dailypulse.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel(
    private val useCase: ArticlesUseCase
): BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState>
        get() = _articlesState

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch {
            _articlesState.value = _articlesState.value.copy(loading = true)
            delay(500)

            try {
                // .collect is a suspend function that "listens" to the flow.
                useCase.getArticles(forceFetch).collect { fetchedArticles ->
                    _articlesState.value = ArticlesState(articles = fetchedArticles)
                }
            } catch (e: Exception) {
                _articlesState.value = ArticlesState(error = e.message ?: "Something went wrong!")
            }
        }
    }
}
