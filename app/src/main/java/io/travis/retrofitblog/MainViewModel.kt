package io.travis.retrofitblog

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.travis.retrofitblog.api.RetrofitInstance
import io.travis.retrofitblog.models.Post
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"
class MainViewModel : ViewModel() {

    private val _posts: MutableLiveData<List<Post>> = MutableLiveData()
    val posts: LiveData<List<Post>>
        get() = _posts

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _errorMessage = MutableLiveData<String?>(null)
    val errorMessage: LiveData<String?>
        get() = _errorMessage

    fun getPosts() {
        viewModelScope.launch {
            // -- Data Starts Loading, Loading is True
            _isLoading.value = true
            try {
                // -- Networking Call
                val fetchedPosts = RetrofitInstance.api.getPosts()
                Log.i(TAG, "Fetched Posts: $fetchedPosts")
                _posts.value = fetchedPosts
                // -- Once Data is done Loading, Loading is set to false
                _isLoading.value = false
            } catch (e: Exception) {
                _errorMessage.value = e.message
                Log.e(TAG,"Exception $e")
            } finally {
                _isLoading.value = false
            }

        }
    }
}
