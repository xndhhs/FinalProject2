package ro.iss.finalchallenge.dashboard.news

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import ro.iss.finalchallenge.R
import ro.iss.finalchallenge.service.newsapi.Article

class ArticleViewHolder(item: View) : RecyclerView.ViewHolder(item) {
  private val title: TextView = item.findViewById(R.id.title)
  private val description: TextView = item.findViewById(R.id.description)
  private val category: TextView = item.findViewById(R.id.category)
  private val source: TextView = item.findViewById(R.id.source)
  private val publishedAt: TextView = item.findViewById(R.id.publishedAt)
  private val image: ImageView = item.findViewById(R.id.image)

  fun bind(model: Article, onArticleSelected: OnArticleSelected) {
    itemView.setOnClickListener { onArticleSelected(model) }
    title.text = model.title
    description.text = model.description
    category.text = model.category?.title
    source.text = model.source.name
    publishedAt.text = model.publishedAt.toString() //TODO: format this

    Glide.with(itemView.context)
      .load(model.urlToImage ?: "")
      .listener(object : RequestListener<Drawable?> {
        override fun onLoadFailed(
          e: GlideException?,
          model: Any,
          target: Target<Drawable?>,
          isFirstResource: Boolean
        ): Boolean {
          return false
        }

        override fun onResourceReady(
          resource: Drawable?,
          model: Any,
          target: Target<Drawable?>,
          dataSource: DataSource,
          isFirstResource: Boolean
        ): Boolean {
          return false
        }
      })
      .transition(DrawableTransitionOptions.withCrossFade())
      .into(image)
  }
}
