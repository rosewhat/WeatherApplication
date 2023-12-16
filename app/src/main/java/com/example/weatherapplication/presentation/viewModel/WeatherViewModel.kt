package com.example.weatherapplication.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.domain.GetTimeWeather
import com.example.weatherapplication.domain.GetTypeWeather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private var _city = "Санкт-Петербург"
    val city: String
        get() = _city

    private var _currentWeather = 20
    val currentWeather: Int
        get() = _currentWeather

    private var _weatherTypeList = listOf(
        GetTypeWeather(35, "Жарко"),
        GetTypeWeather(25, "Тепло"),
        GetTypeWeather(20, "Тепло"),
        GetTypeWeather(20, "Тепло"),
        GetTypeWeather(9, "Холодно"),
        GetTypeWeather(3, "Холодно"),
        GetTypeWeather(5, "Холодно"),
    )
    val weatherTypeList: List<GetTypeWeather>
        get() = _weatherTypeList

    private var _weatherTimeList = listOf(
        GetTimeWeather(5, "9:00"),
        GetTimeWeather(10, "12:00"),
        GetTimeWeather(15, "15:00"),
        GetTimeWeather(20, "18:00"),
        GetTimeWeather(25, "21:00"),
        GetTimeWeather(30, "22:00"),
        GetTimeWeather(35, "23:00"),
    )
    val weatherTimeList: List<GetTimeWeather>
        get() = _weatherTimeList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            viewModelScope.launch(Dispatchers.Main) {
                _city = "Санкт - Петербург"
                _currentWeather = 25

            }
        }
    }

    // Функция для обновления списка типа погоды
    fun updateWeatherTypeList(newList: List<GetTypeWeather>) {
        _weatherTypeList = newList
    }

    // Функция для обновления списка времени
    fun updateWeatherTimeList(newList: List<GetTimeWeather>) {
        _weatherTimeList = newList
    }
}