package ro.iss.finalchallenge.model

class ApiResponse(
    var status: String,
    var totalResults: Int,
    var articles: List<Article>
)