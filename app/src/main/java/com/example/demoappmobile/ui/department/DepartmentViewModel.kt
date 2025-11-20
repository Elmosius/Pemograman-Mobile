package com.example.demoappmobile.ui.department

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoappmobile.entity.MyDepartment
import com.example.demoappmobile.service.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DepartmentViewModel : ViewModel() {
    private val _departments = MutableStateFlow<List<MyDepartment>>(emptyList())
    val departments = _departments.asStateFlow()

    init {
        loadDepartments()
    }

    private fun loadDepartments() {
        viewModelScope.launch {
            val res = ApiClient.instance.getAllDepartments()
            _departments.value = res
        }
    }
}