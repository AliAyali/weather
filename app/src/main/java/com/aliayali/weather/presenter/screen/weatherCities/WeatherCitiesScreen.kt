package com.aliayali.weather.presenter.screen.weatherCities

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliayali.weather.data.fakeData.Weather
import com.aliayali.weather.presenter.ui.WeatherCitiesItem

@Preview
@Composable
fun WeatherCitiesScreen() {
    LazyColumn(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFF2E335A),
                        Color(0xFF1C1B33),
                    )
                )
            )
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        item {
            Spacer(Modifier.height(15.dp))
        }
        items(Weather.weather) {
            WeatherCitiesItem(it)
        }
    }
}