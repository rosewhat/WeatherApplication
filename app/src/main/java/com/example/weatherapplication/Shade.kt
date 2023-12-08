package com.example.weatherapplication

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherapp.presentation.AppBar
import com.example.weatherapp.presentation.BottomBar



@Composable
fun Menu() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Menu",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Calendar() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Calendar",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Share() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Share",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun GreetingScreen(navController: NavController) {
    val city = "Санкт - Петербург"
    val currentWeather = 20
    val weatherTypeList = listOf(
        GetTypeWeather(35, "Жарко"),
        GetTypeWeather(25, "Тепло"),
        GetTypeWeather(20, "Тепло"),
        GetTypeWeather(20, "Тепло"),
        GetTypeWeather(9, "Холодно"),
        GetTypeWeather(3, "Холодно"),
        GetTypeWeather(5, "Холодно"),
    )
    val weatherTimeList = listOf(
        GetTimeWeather(5, "9:00"),
        GetTimeWeather(10, "12:00"),
        GetTimeWeather(15, "15:00"),
        GetTimeWeather(20, "18:00"),
        GetTimeWeather(25, "21:00"),
        GetTimeWeather(30, "22:00"),
        GetTimeWeather(35, "23:00"),
    )

    Scaffold(
        topBar = {
            AppBar(title = "Прогноз погоды", navController = navController)
        },
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = city,
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 35.dp),
            )
            Text(
                text = "$currentWeather °C",
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 15.dp),
            )
            LazyRow {
                items(weatherTypeList) {
                    TypeWeather(it)
                }
            }
            LazyRow {
                items(weatherTimeList) {
                    TimeWeather(it)
                }
            }
        }
    }
}

@Composable
fun TypeWeather(getTypeWeather: GetTypeWeather) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp)
    ) {
        Text(
            text = "${getTypeWeather.temp} °C",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = getTypeWeather.typeWeather,
            fontSize = 12.sp,
        )
    }
}


@Composable
fun TimeWeather(getTypeWeather: GetTimeWeather) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 60.dp, 0.dp, 20.dp),
    ) {
        Text(
            text = "${getTypeWeather.temp}°C",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = getTypeWeather.time,
            fontSize = 12.sp
        )
    }
}