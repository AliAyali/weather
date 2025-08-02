package com.aliayali.weather.presenter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aliayali.weather.ui.theme.WeatherOverlay

@Composable
fun CustomBox(
    isFullWidth: Boolean,
    icon: Int,
    title: String,
    content: @Composable () -> Unit,
) {

    Column(
        modifier = Modifier
            .then(
                if (isFullWidth) Modifier.fillMaxWidth()
                else Modifier.width(100.dp)
            )
            .height(220.dp)
            .padding(20.dp)
            .background(
                WeatherOverlay,
                RoundedCornerShape(10.dp)
            )
    ) {
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(
                painter = painterResource(icon),
                null,
                tint = Color.Gray
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = title,
                color = Color.Gray
            )
        }

        content()
    }

}