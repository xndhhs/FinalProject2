package ro.iss.finalchallenge.dashboard.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ro.iss.finalchallenge.R

class MainListAdapter(private val values: List<MainListModel>, private val onArticleSelected: OnArticleSelected, private val onCategorySelected: OnCategorySelected): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  override fun getItemViewType(position: Int) = values[position].section().ordinal

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return when(viewType) {
      Section.Header.ordinal -> HeaderViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.list_header, parent, false))
      Section.Categories.ordinal -> CategoryListViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.category_list, parent, false))
      Section.Today.ordinal -> ArticleListViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.article_list, parent, false))
      Section.Trending.ordinal -> ArticleListViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.article_list, parent, false))
      Section.Main.ordinal -> ArticleViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.article_item, parent, false))
      else -> throw IllegalStateException()
    }
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    when(val model = values[position]) {
      is HeaderListModel -> (holder as HeaderViewHolder).bind(model.title)
      is CategoriesListModel -> (holder as CategoryListViewHolder).bind(model.categories, onCategorySelected)
      is TodayListModel -> (holder as ArticleListViewHolder).bind(model.articles, onArticleSelected)
      is TrendingListModel -> (holder as ArticleListViewHolder).bind(model.articles, onArticleSelected)
      is ArticleListModel -> (holder as ArticleViewHolder).bind(model.article, onArticleSelected)
    }
  }

  override fun getItemCount(): Int {
    return values.size
  }
}
