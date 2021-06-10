package ro.iss.finalchallenge.dashboard.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ro.iss.finalchallenge.R
import ro.iss.finalchallenge.service.newsapi.Article

class ArticleListAdapter(private val values: List<Article>, private val onArticleSelected: OnArticleSelected): RecyclerView.Adapter<ArticleViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
    val itemView = LayoutInflater.from(parent.context)
      .inflate(R.layout.horizontal_article_item, parent, false)

    return ArticleViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
    val model = values[position]
    holder.bind(model, onArticleSelected)
  }

  override fun getItemCount(): Int {
    return values.size
  }
}
