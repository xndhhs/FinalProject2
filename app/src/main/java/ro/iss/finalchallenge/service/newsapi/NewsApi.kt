package ro.iss.finalchallenge.service.newsapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
  @GET("top-headlines")
  fun getNews(
    @Query("country") country: String?,
    @Query("apiKey") apiKey: String?
  ): Call<News>
}
