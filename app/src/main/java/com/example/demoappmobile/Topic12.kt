package com.example.demoappmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.demoappmobile.ui.theme.DemoAppMobileTheme

class Topic12 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAppMobileTheme {
                App()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview8() {
    DemoAppMobileTheme {
        App()
    }
}