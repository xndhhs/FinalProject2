package ro.iss.finalchallenge.dashboard.news

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ro.iss.finalchallenge.R
import ro.iss.finalchallenge.service.newsapi.Article

class ArticleListViewHolder(item: View) : RecyclerView.ViewHolder(item) {
  private val list: RecyclerView = item.findViewById(R.id.list)

  fun bind(model: List<Article>, onArticleSelected: OnArticleSelected) {
    list.apply {
      layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
      adapter = ArticleListAdapter(model, onArticleSelected)
    }
  }
}
