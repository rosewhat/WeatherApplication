package com.example.weatherapplication.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherapplication.domain.GetTimeWeather
import com.example.weatherapplication.domain.GetTypeWeather
import com.example.weatherapplication.presentation.viewModel.WeatherViewModel
import com.example.weatherapplication.presentation.bar.AppBar
import com.example.weatherapplication.presentation.bar.BottomBar


@Composable
fun Menu(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Menu", fontSize = 20.sp, fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .clickable { }) {
            MenuItem(text = "Notification") {}
            MenuItem(text = "Privacy Policy") {}
            MenuItem(text = "General Settings") {}
            MenuItem(text = "Help") {}
            MenuItem(text = "About us") {}
            MenuItem(text = "Logout") {}
        }
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
            text = "Calendar", fontSize = 20.sp, fontWeight = FontWeight.Bold
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
            text = "Share", fontSize = 20.sp, fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun MenuItem(text: String, onClick: () -> Unit) {
    Text(text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp))
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun GreetingScreen(navController: NavController, viewModel: WeatherViewModel) {
    val city = viewModel.city
    val currentWeather = viewModel.currentWeather
    val weatherTypeList = viewModel.weatherTypeList
    val weatherTimeList = viewModel.weatherTimeList

    Scaffold(topBar = {
        AppBar(title = "Прогноз погоды", navController = navController)
    }, bottomBar = {
        BottomBar(navController = navController)
    }) {
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
                modifier = Modifier.padding(top = 45.dp),
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
            text = "${getTypeWeather.temp}°C", fontSize = 12.sp, fontWeight = FontWeight.Bold
        )
        Text(
            text = getTypeWeather.time, fontSize = 12.sp
        )
    }
}