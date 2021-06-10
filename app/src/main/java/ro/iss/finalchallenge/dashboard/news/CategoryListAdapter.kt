package ro.iss.finalchallenge.dashboard.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ro.iss.finalchallenge.R
import ro.iss.finalchallenge.service.newsapi.Category

class CategoryListAdapter(private val values: List<Category>, private val onCategorySelected: OnCategorySelected): RecyclerView.Adapter<CategoryViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
    val itemView = LayoutInflater.from(parent.context)
      .inflate(R.layout.category_item, parent, false)

    return CategoryViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
    val model = values[position]
    holder.bind(model, onCategorySelected)
  }

  override fun getItemCount(): Int {
    return values.size
  }
}
