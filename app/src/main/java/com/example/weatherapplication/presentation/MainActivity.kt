package com.example.weatherapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapplication.presentation.navigation.Calendar
import com.example.weatherapplication.presentation.navigation.GreetingScreen
import com.example.weatherapplication.presentation.navigation.Menu
import com.example.weatherapplication.presentation.navigation.Share
import com.example.weatherapplication.presentation.viewModel.WeatherViewModel
import com.example.weatherapplication.ui.theme.WeatherApplicationTheme

class MainActivity : ComponentActivity() {
    private val viewModel: WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            WeatherApplicationTheme {
                NavHost(
                    navController = navController,
                    startDestination = "Home"
                ) {
                    composable("Home") {
                        GreetingScreen(navController = navController, viewModel = viewModel)
                    }
                    composable("Menu") {
                        Menu(navController = navController)
                    }
                    composable("Calendar") {
                        Calendar()
                    }
                    composable("Share") {
                        Share()
                    }
                }
            }
        }
    }
}