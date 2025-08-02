package com.aliayali.weather.presenter.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliayali.weather.data.fakeData.Weather
import com.aliayali.weather.ui.theme.Lavender
import com.aliayali.weather.ui.theme.PrimaryDark

@Composable
fun WeatherCitiesItem(data: Weather) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = 20.dp,
                    bottomStart = 20.dp,
                    bottomEnd = 0.dp,
                    topEnd = 0.dp
                )
            )
            .background(
                brush = Brush.horizontalGradient(
                    listOf(Color(0xFF5936B4), Color(0xFF362A84))
                ),
                shape = CutCornerShape(topEnd = 200.dp)
            )
            .fillMaxWidth()
            .padding(all = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = data.degree,
                color = PrimaryDark,
                fontSize = 60.sp
            )

            Image(
                painter = painterResource(data.image),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
        }
        Text(
            text = data.text,
            color = Lavender
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = data.city,
                color = PrimaryDark,
                fontSize = 15.sp
            )
            Text(
                text = data.rain,
                color = PrimaryDark,
                fontSize = 12.sp
            )
        }
    }
}
