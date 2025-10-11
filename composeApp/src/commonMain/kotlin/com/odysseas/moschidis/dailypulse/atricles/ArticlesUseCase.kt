package com.odysseas.moschidis.dailypulse.atricles

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

class ArticlesUseCase(private val repository: ArticlesRepository) {

    fun getArticles(forceFetch: Boolean): Flow<List<Article>> =
        repository.getArticles(forceFetch).map(::mapArticles)


    private fun mapArticles(articlesRaw: List<ArticleRaw>): List<Article> {
        return articlesRaw.map { raw ->
            Article(
                title = raw.title,
                desc = raw.desc ?: "Click to find out more",
                date = getDaysAgo(raw.date),
                imageUrl = raw.imageUrl ?: "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080"
            )
        }
    }

    @OptIn(ExperimentalTime::class)
    private fun getDaysAgo(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }
}