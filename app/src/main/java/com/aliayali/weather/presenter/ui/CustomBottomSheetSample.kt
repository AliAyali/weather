package com.aliayali.weather.presenter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliayali.weather.R
import com.aliayali.weather.ui.theme.Lavender
import com.aliayali.weather.ui.theme.MidnightBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomSheetSample(
    showDialog: Boolean,
    onDismiss: (Boolean) -> Unit,
) {
    val sliderStateALR by remember {
        mutableStateOf(
            SliderState(
                value = 5f,
                valueRange = 0f..10f,
                onValueChangeFinished = {}
            )
        )
    }
    val sliderStateUV by remember {
        mutableStateOf(
            SliderState(
                value = 0f,
                valueRange = 0f..10f,
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
            containerColor = MidnightBlue
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
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

                    CustomSlider(sliderStateALR)

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
                            .padding(horizontal = 20.dp, vertical = 15.dp)
                            .clickable {},
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

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomBox(
                        false,
                        R.drawable.ic_sunny,
                        "UV INDEX"
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = "4",
                                color = Lavender,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Moderate",
                                color = Lavender,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            CustomSlider(sliderStateUV)
                        }

                    }

                    CustomBox(
                        false,
                        R.drawable.ic_sunblock,
                        "SUNRISE"
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = "5:28 AM",
                                color = Lavender,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Sunset: 7:25 PM",
                                color = Lavender,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomBox(
                        false,
                        R.drawable.ic_wind,
                        "WIND"
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painterResource(R.drawable.compass),
                                null,
                                tint = Lavender
                            )
                        }

                    }

                    CustomBox(
                        false,
                        R.drawable.ic_water,
                        "RAINFALL"
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = "1.8 mm",
                                color = Lavender,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "in last hour",
                                color = Lavender,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "1.2 mm expected in next 24h.",
                                color = Lavender,
                                fontSize = 15.sp
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomBox(
                        false,
                        R.drawable.temperature,
                        "FEELS LIKE"
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = "19°",
                                color = Lavender,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Similar to the actual temperature",
                                color = Lavender,
                                fontSize = 20.sp
                            )
                        }

                    }

                    CustomBox(
                        false,
                        R.drawable.humidity,
                        "HUMIDITY"
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = "90%",
                                color = Lavender,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "The dew point is 17 right now.",
                                color = Lavender,
                                fontSize = 15.sp
                            )

                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomBox(
                        false,
                        R.drawable.visibility,
                        "VISIBILITY"
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = "8 km",
                                color = Lavender,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Similar to the actual temperature",
                                color = Lavender,
                                fontSize = 20.sp
                            )
                        }

                    }

                    CustomBox(
                        false,
                        R.drawable.gauge,
                        "PRESSURE"
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.SpaceAround,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            CircularProgressIndicator(
                                progress = {
                                    0.4f
                                },
                                color = Lavender,
                                modifier = Modifier.size(100.dp),
                                trackColor = Color.Gray,
                                strokeWidth = 4.dp,
                                strokeCap = StrokeCap.Round
                            )

                        }
                    }
                }

            }

        }
    }
}
