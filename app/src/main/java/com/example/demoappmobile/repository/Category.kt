package com.example.demoappmobile.repository

import com.example.demoappmobile.entity.Category
import com.example.demoappmobile.utils.FirebaseHelper
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class CategoryRepository {
    private val ref = FirebaseHelper.categoryRef

    fun getAllCategories(onResult: (List<Category>) -> Unit) {
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val categories = mutableListOf<Category>()
                snapshot.children.forEach { childSnap ->
                    val category = childSnap.getValue(Category::class.java)
                    category?.let { categories.add(it) }
                }
                onResult(categories)
            }

            override fun onCancelled(error: DatabaseError) {
                onResult(emptyList())
            }

        })
    }

    fun addCategory(category: Category) {
        ref.child(category.id.toString()).setValue(category)
    }

    fun deleteCategory(id: Int) {
        // TODO
    }
}