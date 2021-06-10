package ro.iss.finalchallenge.dashboard.news

import android.os.Bundle
import android.text.format.DateUtils
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import kotlinx.android.synthetic.main.news_activity.*
import retrofit2.Response
import ro.iss.finalchallenge.Constants
import ro.iss.finalchallenge.R
import ro.iss.finalchallenge.Secrets
import ro.iss.finalchallenge.service.newsapi.Article
import ro.iss.finalchallenge.service.newsapi.Category
import ro.iss.finalchallenge.service.newsapi.News
import ro.iss.finalchallenge.service.newsapi.NewsClient

class NewsActivity : AppCompatActivity() {
  private val newsClient = NewsClient(Secrets.API_KEY)

  private var models: List<MainListModel> = listOf()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.news_activity)
    if (list is RecyclerView) {
      with(list) {
        layoutManager = LinearLayoutManager(context)
        adapter = MainListAdapter(listOf(), {}, {})
      }
    }

    progress_indicator.visibility = View.VISIBLE
    list.visibility = View.GONE

    newsClient.getNews().enqueue(object : Callback<News>{
      override fun onResponse(call: Call<News>, response: Response<News>) {
        if (response.isSuccessful){
          val articles = response.body()!!.articles.map { it.copy(category = Category(Constants.CATEGORIES.random())) }

          if (articles.isNotEmpty()) {

            val todayArticles = articles.filter { DateUtils.isToday(it.publishedAt.time) }

            val trendingArticles = mutableListOf<Article>()
            var next = articles.random()
            while (trendingArticles.size <= 3 && !trendingArticles.contains(next)) {
              trendingArticles.add(next)
              next = articles.random()
            }

            models = mutableListOf(
              HeaderListModel("Select a category"),
              CategoriesListModel(Constants.CATEGORIES.map { Category(it) }),
              HeaderListModel("Today"),
              TodayListModel(todayArticles),
              HeaderListModel("Trending"),
              TrendingListModel(trendingArticles),
              HeaderListModel("Latest"),
              ).also { it.addAll(articles.map{ article -> ArticleListModel(article) }) }
          }

          list.apply {
            layoutManager = LinearLayoutManager(this@NewsActivity)
            adapter = MainListAdapter(
              models,
              {article -> //TODO: start article detail activity },
              {category -> //TODO: start article list activity },
            )
          }
        }
        progress_indicator.visibility = View.GONE
        list.visibility = View.VISIBLE
      }
      override fun onFailure(call: Call<News>, t: Throwable) {
        Toast.makeText(this@NewsActivity, "${t.message}", Toast.LENGTH_SHORT).show()
      }
    })
  }
}
