package com.odysseas.moschidis.dailypulse.atricles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService (private val httpClient: HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "43fb7b8cefcc4a12bff5209a7fd3a20c"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
        return response.articles
    }
}