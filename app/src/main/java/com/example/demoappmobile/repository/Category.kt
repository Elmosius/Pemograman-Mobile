package com.example.demoappmobile.repository

import com.example.demoappmobile.entity.Category
import com.example.demoappmobile.utils.FirebaseHelper
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class CategoryRepository {
    private val ref = FirebaseHelper.categoryRef

    private var categoriesListener: ValueEventListener? = null

    fun getAllCategories(onResult: (List<Category>) -> Unit) {
        categoriesListener?.let { ref.removeEventListener(it) }

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val categories = snapshot.children.mapNotNull { child ->
                    child.getValue(Category::class.java)
                }
                onResult(categories)
            }

            override fun onCancelled(error: DatabaseError) {
                onResult(emptyList())
            }
        }

        categoriesListener = listener
        ref.addValueEventListener(listener)
    }

    fun clearListeners() {
        categoriesListener?.let { ref.removeEventListener(it) }
        categoriesListener = null
    }

    fun addCategory(category: Category) {
        ref.child(category.id.toString()).setValue(category)
    }

    fun deleteCategory(id: Int) {
        // TODO
    }
}