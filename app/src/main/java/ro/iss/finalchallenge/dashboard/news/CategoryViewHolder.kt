package ro.iss.finalchallenge.dashboard.news

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ro.iss.finalchallenge.R
import ro.iss.finalchallenge.service.newsapi.Category

class CategoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {
  private val title: TextView = item.findViewById(R.id.title)

  fun bind(model: Category, onCategorySelected: OnCategorySelected) {
    itemView.setOnClickListener { onCategorySelected(model) }
    title.text = model.title
  }
}
