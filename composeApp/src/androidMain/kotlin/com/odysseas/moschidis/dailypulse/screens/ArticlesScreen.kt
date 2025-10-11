package com.odysseas.moschidis.dailypulse.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.odysseas.moschidis.dailypulse.atricles.application.Article
import com.odysseas.moschidis.dailypulse.atricles.presentation.ArticlesViewModel
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ArticlesScreen(
    onAboutButtonClick: () -> Unit,
    articlesViewModel: ArticlesViewModel = koinViewModel(),
) {
    val articlesState = articlesViewModel.articlesState.collectAsState()

    val pullRefreshState = rememberPullRefreshState(
        refreshing = articlesState.value.loading,
        onRefresh = { articlesViewModel.getArticles(forceFetch = true) }
    )

    Column {
        AppBar(onAboutButtonClick)

        Box(modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState)
        ) {

            if (articlesState.value.error != null)
                ErrorMessage(articlesState.value.error!!)
            if (articlesState.value.articles.isNotEmpty())
                ArticlesListView(articlesState.value.articles)

            PullRefreshIndicator(
                refreshing = articlesState.value.loading,
                state = pullRefreshState,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(
    onAboutButtonClick: () -> Unit,
) {
    TopAppBar(
        title = { Text(text = "Articles") },
        actions = {
            IconButton(onClick = onAboutButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "About Device Button",
                )
            }
        }
    )
}

@Composable
fun ArticlesListView(articles: List<Article>) {
    Log.d("ArticlesListView", "Displaying articles: $articles")

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(articles) { article ->
            ArticleItemView(article = article)
        }
    }
}

@Composable
fun ArticleItemView(article: Article) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = article.imageUrl,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = article.desc)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.date,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
fun ErrorMessage(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = TextStyle(fontSize = 28.sp, textAlign = TextAlign.Center)
        )
    }
}
