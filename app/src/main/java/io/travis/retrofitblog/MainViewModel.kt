package io.travis.retrofitblog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.travis.retrofitblog.api.RetrofitInstance

private const val TAG = "MainViewModel"
class MainViewModel : ViewModel() {

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getPosts() {
        viewModelScope.launch {
            RetrofitInstance.api.getPosts()
        }
    }
}