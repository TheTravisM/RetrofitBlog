package io.travis.retroblog.api

import io.travis.retroblog.models.Post
import retrofit2.http.GET

interface BlogApi {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}