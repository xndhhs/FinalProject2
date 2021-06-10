package ro.iss.finalchallenge.service.newsapi

data class News (
  val status: String,
  val totalResults: Int,
  val articles: List<Article>,
)
