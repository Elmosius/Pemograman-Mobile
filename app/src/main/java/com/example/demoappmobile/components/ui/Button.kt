package com.example.demoappmobile.components.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun NavButton(title: String, onClick: () -> Unit){
    Row {
        Button(
            onClick = { onClick },
            shape = RoundedCornerShape(10.dp),

        ) {
            Text(text = title)
        }
    }
}