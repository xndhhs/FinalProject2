package ro.iss.finalchallenge.dashboard.news

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ro.iss.finalchallenge.R
import ro.iss.finalchallenge.service.newsapi.Category

class CategoryListViewHolder(item: View) : RecyclerView.ViewHolder(item) {
  private val list: RecyclerView = item.findViewById(R.id.list)

  fun bind(model: List<Category>, onCategorySelected: OnCategorySelected) {
    list.apply {
      layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
      adapter = CategoryListAdapter(model, onCategorySelected)
    }
  }
}
