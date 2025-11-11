package com.example.demoappmobile.components.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun RadioButtonExample(
    title: String,
    options: Array<String>,
    value: String,
    selectionOption: (String) -> Unit
) {
    Column {
        Text(title)
        options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectionOption(option) },
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = value == option,
                    onClick = { selectionOption(option) }
                )
                Text(option)
            }
        }
    }

}