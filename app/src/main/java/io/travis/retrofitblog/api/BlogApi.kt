package io.travis.retrofitblog.api

import io.travis.retrofitblog.models.Post
import retrofit2.http.GET

interface BlogApi {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}