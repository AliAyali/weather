package com.aliayali.weather.presenter.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aliayali.weather.R
import com.aliayali.weather.ui.theme.Blue
import com.aliayali.weather.ui.theme.PrimaryDark
import com.aliayali.weather.ui.theme.WeatherOverlay

@Composable
fun WeatherSmallItem() {

    Card(
        modifier = Modifier.padding(10.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = WeatherOverlay
        ),
        shape = CircleShape
    ) {

        Column(
            modifier = Modifier
                .width(70.dp)
                .height(160.dp)
                .background(WeatherOverlay, CircleShape)
                .padding(vertical = 10.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "12 AM",
                color = PrimaryDark,
                fontWeight = FontWeight.Bold
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.moon_cloud_mid_rain),
                    null,
                    modifier = Modifier.size(35.dp)
                )
                Text(
                    text = "30%",
                    color = Blue,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "19°",
                color = PrimaryDark,
                fontWeight = FontWeight.Bold
            )
        }

    }
}