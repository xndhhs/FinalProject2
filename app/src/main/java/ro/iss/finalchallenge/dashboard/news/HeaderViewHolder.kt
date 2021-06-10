package ro.iss.finalchallenge.dashboard.news

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ro.iss.finalchallenge.R

class HeaderViewHolder(item: View) : RecyclerView.ViewHolder(item) {
  private val title: TextView = item.findViewById(R.id.title)

  fun bind(model: String) {
    title.text = model
  }
}
