package com.example.demoappmobile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Rectangle
import androidx.compose.material.icons.filled.Square
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demoappmobile.ui.theme.DemoAppMobileTheme
import kotlin.math.PI
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAppMobileTheme {
                var currentScreen by remember { mutableStateOf("main") }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopBar(
                            title = when (currentScreen) {
                                "square" -> "Square"
                                "rectangle" -> "Rectangle"
                                "triangle" -> "Triangle"
                                "circle" -> "Circle"
                                else -> stringResource(R.string.app_name)
                            },
                            showBack = currentScreen != "main",
                            onBackClick = { currentScreen = "main" }
                        )
                    }
                ) { innerPadding ->
                    when (currentScreen) {
                        "main" -> MainContent(
                            modifier = Modifier.padding(innerPadding),
                            onShapeClick = { shape ->
                                currentScreen = shape
                            }
                        )

                        "square" -> CalculatorSquare(Modifier.padding(innerPadding))
                        "rectangle" -> CalculatorRectangle(Modifier.padding(innerPadding))
                        "triangle" -> CalculatorTriangle(Modifier.padding(innerPadding))
                        "circle" -> CalculatorCircle(Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(title: String, showBack: Boolean, onBackClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            if (showBack) {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
    )
}

@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
    onShapeClick: (String) -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ShowButton("Square", Color(0xff6100ed), onClick = { onShapeClick("square") })
            Spacer(modifier = Modifier.padding(20.dp))
            ShowButton("Rectangle", Color(0xff05d9c4), onClick = { onShapeClick("rectangle") })
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ShowButton("Triangle", Color(0xfffe5620), onClick = { onShapeClick("triangle") })
            Spacer(modifier = Modifier.padding(20.dp))
            ShowButton("Circle", Color(0xff4aaf4e), onClick = { onShapeClick("circle") })
        }
    }
}

@Composable
private fun ShowButton(
    text: String,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val shape = when (text) {
        "Square" -> Icons.Filled.Square
        "Rectangle" -> Icons.Filled.Rectangle
        "Triangle" -> Icons.Filled.PlayArrow
        else -> Icons.Filled.Circle
    }

    Button(
        onClick = onClick,
        modifier = modifier.size(150.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(60.dp),
                imageVector = shape,
                contentDescription = text
            )
            Text(text = text)
        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
private fun CalculatorSquare(modifier: Modifier = Modifier) {
    var sisiInput by remember { mutableStateOf("") }
    val sisi = sisiInput.toDoubleOrNull() ?: 0.0
    val luas = sisi * sisi
    val keliling = 4 * sisi

    CalculatorLayout(
        modifier = modifier,
        inputs = listOf(
            InputFieldData("Sisi (cm)", sisiInput) { sisiInput = it }
        ),
        hasilLuas = String.format("%.2f", luas),
        hasilKeliling = String.format("%.2f", keliling)
    )
}

@SuppressLint("DefaultLocale")
@Composable
private fun CalculatorRectangle(modifier: Modifier = Modifier) {
    var panjangInput by remember { mutableStateOf("") }
    var lebarInput by remember { mutableStateOf("") }

    val panjang = panjangInput.toDoubleOrNull() ?: 0.0
    val lebar = lebarInput.toDoubleOrNull() ?: 0.0

    val luas = panjang * lebar
    val keliling = 2 * (panjang + lebar)

    CalculatorLayout(
        modifier = modifier,
        inputs = listOf(
            InputFieldData("Panjang (cm)", panjangInput) { panjangInput = it },
            InputFieldData("Lebar (cm)", lebarInput) { lebarInput = it }
        ),
        hasilLuas = String.format("%.2f", luas),
        hasilKeliling = String.format("%.2f", keliling)
    )
}

@SuppressLint("DefaultLocale")
@Composable
private fun CalculatorTriangle(modifier: Modifier = Modifier) {
    var alasInput by remember { mutableStateOf("") }
    var tinggiInput by remember { mutableStateOf("") }
    var sisiInput by remember { mutableStateOf("") }

    val alas = alasInput.toDoubleOrNull() ?: 0.0
    val tinggi = tinggiInput.toDoubleOrNull() ?: 0.0
    val sisi = sisiInput.toDoubleOrNull() ?: 0.0

    val luas = 0.5 * alas * tinggi
    val keliling = 3 * sisi

    CalculatorLayout(
        modifier = modifier,
        inputs = listOf(
            InputFieldData("Alas (cm)", alasInput) { alasInput = it },
            InputFieldData("Tinggi (cm)", tinggiInput) { tinggiInput = it },
            InputFieldData("Sisi (cm)", sisiInput) { sisiInput = it }
        ),
        hasilLuas = String.format("%.2f", luas),
        hasilKeliling = String.format("%.2f", keliling)
    )
}

@SuppressLint("DefaultLocale")
@Composable
private fun CalculatorCircle(modifier: Modifier = Modifier) {
    var jariInput by remember { mutableStateOf("") }
    val jari = jariInput.toDoubleOrNull() ?: 0.0

    val luas = PI * jari.pow(2)
    val keliling = 2 * PI * jari

    CalculatorLayout(
        modifier = modifier,
        inputs = listOf(
            InputFieldData("Jari-jari (cm)", jariInput) { jariInput = it }
        ),
        hasilLuas = String.format("%.2f", luas),
        hasilKeliling = String.format("%.2f", keliling)
    )
}

data class InputFieldData(
    val label: String,
    val value: String,
    val onChange: (String) -> Unit
)

@Composable
private fun CalculatorLayout(
    modifier: Modifier = Modifier,
    inputs: List<InputFieldData>,
    hasilLuas: String,
    hasilKeliling: String
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFEFEFEF))
            .padding(16.dp)
    ) {
        for (input in inputs) {
            TextField(
                value = input.value,
                onValueChange = input.onChange,
                singleLine = true,
                label = { Text(input.label) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Luas: $hasilLuas cm²",
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Keliling: $hasilKeliling cm",
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}
