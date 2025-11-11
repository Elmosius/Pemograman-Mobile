package com.example.demoappmobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoappmobile.components.ui.CheckBoxExample
import com.example.demoappmobile.components.ui.DropDownField
import com.example.demoappmobile.components.ui.RadioButtonExample
import com.example.demoappmobile.ui.theme.DemoAppMobileTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAppMobileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainContent(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@SuppressLint("ResourceType")
@Composable
private fun MainContent(modifier: Modifier = Modifier) {
    var selectedOption by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        DropDownField(
            label = "Select an option",
            value = selectedOption,
            onValueChange = {
                selectedOption = it
            },
            options = stringArrayResource(R.array.list_options)
        )

        Text(
            text = "Selected option: $selectedOption",
            modifier = modifier
        )

        RadioButtonExample(
            title = "Select an option",
            options = stringArrayResource(R.array.list_options),
            value = selectedOption,
            selectionOption = {
                selectedOption = it
            }
        )

        CheckBoxExample(
            text = "I agree to the terms and conditions"
        )

        Button(
            onClick = {
                Toast.makeText(context, "Button clicked!", Toast.LENGTH_LONG).show()
            },
            shape = CircleShape
        ) {
            Text("Click Me")
        }


    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    DemoAppMobileTheme {
        MainContent()
    }
}