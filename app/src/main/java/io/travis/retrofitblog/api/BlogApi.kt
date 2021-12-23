package io.travis.retrofitblog.api

import io.travis.retrofitblog.models.Post
import io.travis.retrofitblog.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface BlogApi {
    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPost(@Path("id") postId: Int): Post

    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): User
}