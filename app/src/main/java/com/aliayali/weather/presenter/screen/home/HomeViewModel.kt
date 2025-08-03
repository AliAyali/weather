package com.aliayali.weather.presenter.screen.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliayali.weather.data.remote.model.CurrentWeatherResponse
import com.aliayali.weather.data.remote.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val apiKey: String,
) : ViewModel() {

    private val _currentWeather = mutableStateOf<CurrentWeatherResponse?>(null)
    val currentWeather: State<CurrentWeatherResponse?> = _currentWeather

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    init {
        getWeather("Montreal")
    }

    fun getWeather(cityName: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val result = repository.getCurrentWeather(cityName, apiKey)
                _currentWeather.value = result
            } catch (e: Exception) {
                Log.e("RETROFIT", e.message.toString())
            }
            _isLoading.value = false
        }
    }

}