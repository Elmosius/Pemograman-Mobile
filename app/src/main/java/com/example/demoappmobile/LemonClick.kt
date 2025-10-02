package com.example.demoappmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demoappmobile.ui.theme.DemoAppMobileTheme

class LemonClick : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAppMobileTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopBar()
                    }
                ) { innerPadding ->
                    AppContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name_lemon_click),
                fontWeight = FontWeight.Bold,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xfff6eb74),
        )
    )
}

@Composable
private fun AppContent(modifier: Modifier = Modifier) {
    var step by remember { mutableIntStateOf(1) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                step = step % 4 + 1
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xffffd7e1),
            ),
            shape = RoundedCornerShape(40.dp),
        ) {
            ShowImage(step)
        }
        ShowText(step)
    }
}

@Composable
private fun ShowImage(step: Int) {
    var image = R.drawable.lemon_tree
    when (step) {
        1 -> image = R.drawable.lemon_tree
        2 -> image = R.drawable.lemon_squeeze
        3 -> image = R.drawable.lemon_drink
        4 -> image = R.drawable.lemon_restart
    }

    Image(
        painter = painterResource(id = image),
        contentDescription = "Lemon step $step",
        modifier = Modifier
            .width(150.dp)
            .padding(20.dp)
    )
}

@Composable
fun ShowText(step: Int) {
    var text = stringResource(R.string.step1)
    when (step) {
        1 -> text = stringResource(R.string.step1)
        2 -> text = stringResource(R.string.step2)
        3 -> text = stringResource(R.string.step3)
        4 -> text = stringResource(R.string.step4)
    }

    Text(
        text = text,
        modifier = Modifier.padding(20.dp),
        fontSize = 15.sp
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    AppContent()
}