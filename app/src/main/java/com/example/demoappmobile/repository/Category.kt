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

            val categories = mutableListOf<Category>()

            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach { child ->
                    val category = child.getValue(Category::class.java)
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

    }
}