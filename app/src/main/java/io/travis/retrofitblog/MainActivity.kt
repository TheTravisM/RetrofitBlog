package io.travis.retrofitblog

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.travis.retrofitblog.databinding.ActivityMainBinding
import io.travis.retrofitblog.models.Post

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var blogPostAdapter: BlogPostAdapter
    private val blogPosts = mutableListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.isLoading.observe(this, Observer { isLoading ->
            Log.i(TAG, "isLoading $isLoading")
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        })

        blogPostAdapter = BlogPostAdapter(this, blogPosts)
        binding.rvPosts.adapter = blogPostAdapter
        binding.rvPosts.layoutManager = LinearLayoutManager(this)

        binding.button.setOnClickListener {
            viewModel.getPosts()
        }
    }
}