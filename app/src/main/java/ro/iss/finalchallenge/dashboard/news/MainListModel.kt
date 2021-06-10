package ro.iss.finalchallenge.dashboard.news

import ro.iss.finalchallenge.service.newsapi.Article
import ro.iss.finalchallenge.service.newsapi.Category

enum class Section {
  Header,
  Categories,
  Today,
  Trending,
  Main;
}

typealias OnCategorySelected = (category: Category) -> Unit
typealias OnArticleSelected = (article: Article) -> Unit

sealed class MainListModel

data class HeaderListModel(val title: String): MainListModel()
data class CategoriesListModel(val categories: List<Category>): MainListModel()
data class TodayListModel(val articles: List<Article>): MainListModel()
data class TrendingListModel(val articles: List<Article>): MainListModel()
data class ArticleListModel(val article: Article): MainListModel()

fun MainListModel.section() = when(this) {
  is HeaderListModel -> Section.Header
  is CategoriesListModel -> Section.Categories
  is TodayListModel -> Section.Today
  is TrendingListModel -> Section.Trending
  is ArticleListModel -> Section.Main
}
