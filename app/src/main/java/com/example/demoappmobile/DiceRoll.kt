package com.example.demoappmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoappmobile.ui.theme.DemoAppMobileTheme

class DiceRoll : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAppMobileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShowContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
private fun ShowImage(dice: Int) {
    val image = when (dice) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Image(
        painter = painterResource(id = image),
        contentDescription = "Dice $dice",
        modifier = Modifier
            .width(200.dp)
            .background(Color(0xfff6eb74))
    )
}

@Composable
private fun ShowContent(modifier: Modifier = Modifier) {
    var dice by remember { mutableIntStateOf(1) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xfff6eb74)),
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ShowImage(dice)
            Button(
                onClick = { dice = (1..6).random() },
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = "Roll the Dice",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShowContent()
}