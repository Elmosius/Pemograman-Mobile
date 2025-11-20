package com.example.demoappmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.demoappmobile.page.DepartmentPage
import com.example.demoappmobile.ui.theme.DemoAppMobileTheme

class Topic9b : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DepartmentPage()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    DemoAppMobileTheme {
        DepartmentPage()
    }
}