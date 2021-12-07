package io.travis.retrofitblog.models

data class Post(
    val userId:Int,
    val id: Int,
    val title: String,
    val body: String)

//https://jsonplaceholder.typicode.com/posts