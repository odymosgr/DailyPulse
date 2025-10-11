package com.odysseas.moschidis.dailypulse.atricles

import com.odysseas.moschidis.dailypulse.db.DailyPulseDatabase

class ArticlesDataSource(private val database: DailyPulseDatabase) {
    fun getAllArticles() : List<ArticleRaw> =
        database.dailyPulseDatabaseQueries.selectAllArticles(::mapArticleQueryToRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        database.dailyPulseDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun clearArticles() =
        database.dailyPulseDatabaseQueries.removeAllArticles()

    private fun insertArticle(articleRaw: ArticleRaw) {
        database.dailyPulseDatabaseQueries.insertArticle(
            articleRaw.title,
            articleRaw.desc,
            articleRaw.date,
            articleRaw.imageUrl
        )
    }

    private fun mapArticleQueryToRaw(
        title: String,
        desc: String?,
        date: String,
        imageUrl: String?
    ) : ArticleRaw {
        return ArticleRaw(title, desc, date, imageUrl)
    }
}