package com.example.demoappmobile.viewmodel.category

import androidx.lifecycle.ViewModel
import com.example.demoappmobile.entity.Category
import com.example.demoappmobile.repository.CategoryRepository

class CategoryFormViewModel : ViewModel() {
    private val categoryRepository = CategoryRepository()

    fun saveCategory(id: Int, name: String, onResult: () -> Unit) {
        val category = Category(id, name)
        categoryRepository.addCategory(category)
        onResult()
    }
}