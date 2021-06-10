package ro.iss.finalchallenge.model

import java.util.*

class Article(
    var source: ArticleSource,
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var publishedAt: Date,
    var content: String,
){
    class ArticleSource
        (var id: String,
         var name:String
    )

}
