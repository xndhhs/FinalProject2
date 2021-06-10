package ro.iss.finalchallenge.service.newsapi

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://newsapi.org/v2/"

class NewsClient(
  private val apiKey: String,
  private val country: String = "us",
) {
  private val client = OkHttpClient.Builder().build()
  private val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(client)
    .build()

  private val api: NewsApi = retrofit.create(NewsApi::class.java)

  fun getNews() : Call<News> {
    return api.getNews(country, apiKey)
  }
}
