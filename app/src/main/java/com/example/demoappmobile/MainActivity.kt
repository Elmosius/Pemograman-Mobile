package com.example.demoappmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demoappmobile.ui.theme.DemoAppMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAppMobileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BoxExample(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.test),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = "This is a Box Example",
            color = Color.White,
            fontSize = 24.sp
        )
    }
}

@Composable
fun ColumnExample(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            color = Color.Blue,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = "Item #1",
                fontSize = 24.sp,
                textAlign = TextAlign.Left
            )
        }
        Surface(
            color = Color.Yellow,
        ) {
            Text(
                text = "Item #2",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
        Surface(
            color = Color.Red,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = "Item #3",
                fontSize = 24.sp,
                textAlign = TextAlign.Right
            )
        }
    }
}

@Composable
fun RowExample(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Surface(
            color = Color.Blue,
            modifier = modifier.weight(1f)
        ) {
            Text(
                text = "Item #1",
                fontSize = 24.sp,
                textAlign = TextAlign.Left
            )
        }
        Surface(
            color = Color.Yellow,
            modifier = modifier.weight(1f)
        ) {
            Text(
                text = "Item #2",
                fontSize = 24.sp,
                textAlign = TextAlign.Right
            )
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    BoxExample()
//    ColumnExample()
    RowExample()
}