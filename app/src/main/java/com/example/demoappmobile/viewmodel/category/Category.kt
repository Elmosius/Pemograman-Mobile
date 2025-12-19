package com.example.demoappmobile.viewmodel.category

import androidx.lifecycle.ViewModel
import com.example.demoappmobile.entity.Category
import com.example.demoappmobile.repository.CategoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CategoryViewModel : ViewModel() {
    private val categoryRepository: CategoryRepository = CategoryRepository()

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories = _categories.asStateFlow()

    init {
        loadCategories()
    }

    fun loadCategories() {
        categoryRepository.getAllCategories {
            _categories.value = it
        }
    }

    override fun onCleared() {
        super.onCleared()
        categoryRepository.clearListeners()
    }
}