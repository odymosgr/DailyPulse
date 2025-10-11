package com.odysseas.moschidis.dailypulse.atricles

import com.odysseas.moschidis.dailypulse.printLog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
) {
    fun getArticles(forceFetch: Boolean): Flow<List<ArticleRaw>> = flow {
        // 1. Emit articles from the cache.
        val cachedArticles = dataSource.getAllArticles()
        emit(cachedArticles)

        val shouldFetch = forceFetch || cachedArticles.isEmpty()

        // 2. If we need to fetch, do it.
        if (shouldFetch) {
            try {
                val networkResult = service.fetchArticles()
                printLog("Articles.Repo", "Fetched ${networkResult.size} articles from network")
                // Update DB
                dataSource.clearArticles()
                dataSource.insertArticles(networkResult)
                // 3. Emit the new data from the DB (our source of truth).
                emit(dataSource.getAllArticles())
            } catch (e: Exception) {
                printLog("ArticlesRepository", "Network fetch failed: ${e.message}")
            }
        }
    }
}
