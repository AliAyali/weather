package com.aliayali.weather.presenter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliayali.weather.R
import com.aliayali.weather.ui.theme.DarkPurple
import com.aliayali.weather.ui.theme.Lavender
import com.aliayali.weather.ui.theme.WeatherOverlay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomSheetSample(
    showDialog: Boolean,
    onDismiss: (Boolean) -> Unit,
) {
    val sliderState by remember {
        mutableStateOf(
            SliderState(
                value = 5f,
                valueRange = 0f..10f,
                steps = 9,
                onValueChangeFinished = {}
            )
        )
    }

    if (showDialog) {
        ModalBottomSheet(
            modifier = Modifier,
            onDismissRequest = {
                onDismiss(false)
            },
            containerColor = DarkPurple
        ) {

            CustomBox(
                true,
                R.drawable.ic_blur,
                "ALR QUALITY"
            ) {
                Text(
                    text = "3-Low Health Risk",
                    color = Lavender,
                    modifier = Modifier.padding(horizontal = 20.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                CustomSlider(sliderState)

                Box(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .background(
                            MaterialTheme.colorScheme.secondary
                        )
                        .fillMaxWidth()
                        .height(1.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "See more",
                        color = Lavender,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        null,
                        tint = Lavender
                    )
                }
            }

        }
    }
}
