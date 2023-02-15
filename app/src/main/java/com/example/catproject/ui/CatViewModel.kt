package com.example.catproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catproject.data.CatResponse
import com.example.catproject.data.RepositoryImpl
import kotlinx.coroutines.launch

class CatViewModel: ViewModel() {
    private val _catLiveData = MutableLiveData<List<CatResponse>>()
    val catLiveData: LiveData<List<CatResponse>> get() = _catLiveData

    fun getCatImage(typeKey: String) {
        viewModelScope.launch {
            _catLiveData.value = RepositoryImpl().getImage(typeKey)
        }
    }
}