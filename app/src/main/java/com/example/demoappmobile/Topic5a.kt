package com.example.demoappmobile

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.demoappmobile.databinding.ActivityMainBinding
import com.example.demoappmobile.entity.Department

class Topic5a : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private var grantAdapter: ArrayAdapter<CharSequence>? = null
    private var departmentAdapter: ArrayAdapter<Department>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view: View? = binding.root
        setContentView(view)

        binding.spGrant.adapter = getGrantAdapter()
        binding.spDepartment.adapter = getDepartmentAdapter()

        binding.btnSubmit.setOnClickListener { e ->
            handleSubmit()
        }
    }


    private fun handleSubmit() {
        val name = binding.etName.text.toString()
        val eligibility = binding.cbEligibility.isChecked
        val gender =
            if (binding.rbMale.isChecked) binding.rbMale.text.toString() else binding.rbFemale.text.toString()
        val grant = binding.spGrant.selectedItem.toString()
        val department = binding.spDepartment.selectedItem.toString()

        Toast.makeText(
            this,
            "$name $gender $eligibility $grant $department",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun getGrantAdapter(): ArrayAdapter<CharSequence>? {
        if (grantAdapter == null) {
            grantAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.grants,
                android.R.layout.simple_spinner_item
            )
            grantAdapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        return grantAdapter
    }

    private fun getDepartmentAdapter(): ArrayAdapter<Department>? {
        if (departmentAdapter == null) {
            departmentAdapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                getDepartments(),
            )
            departmentAdapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        return departmentAdapter
    }

    private fun getDepartments(): List<Department> {
        val departments = listOf(
            Department("72", "Computer Science"),
            Department("73", "Mechanical Engineering"),
            Department("74", "Civil Engineering")
        )
        return departments
    }
}
