package com.aliayali.weather.presenter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aliayali.weather.ui.theme.Blue
import com.aliayali.weather.ui.theme.DeepIndigo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSlider(
    sliderState: SliderState,
    modifier: Modifier = Modifier,
) {
    Slider(
        state = sliderState,
        modifier = modifier
            .padding(horizontal = 20.dp),
        thumb = {
            Box(
                modifier = Modifier
                    .background(Color.White, CircleShape)
                    .size(15.dp)
                    .border(1.dp, Color.Black, CircleShape)
            )
        },
        track = {
            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                DeepIndigo,
                                Blue,
                                Color.Magenta
                            )
                        ),
                        CircleShape
                    )
                    .height(3.dp)
                    .fillMaxWidth()
            )
        }
    )
}