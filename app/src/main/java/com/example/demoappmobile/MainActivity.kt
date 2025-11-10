package com.example.demoappmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demoappmobile.components.pages.DetailPage
import com.example.demoappmobile.components.pages.MainPage
import com.example.demoappmobile.models.Weather
import com.example.demoappmobile.ui.theme.DemoAppMobileTheme
import com.example.demoappmobile.utils.loadData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAppMobileTheme {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    val navController = rememberNavController()
    val data = loadData(context = LocalContext.current)

    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") {
            MainPage(data = data, onWeatherClick = { weatherId ->
                navController.navigate("detail/$weatherId")
            })
        }

        composable(
            "detail/{weatherId}", arguments = listOf(
                navArgument("weatherId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val weatherId = backStackEntry.arguments?.getInt("weatherId") ?: 0
            val weather = data.find { it.id == weatherId } as Weather

            DetailPage(
                weather,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoAppMobileTheme {
        MainContent()


    }
}