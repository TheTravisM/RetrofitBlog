package io.travis.retrofitblog.models

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val company: Company,
    val website: String
)