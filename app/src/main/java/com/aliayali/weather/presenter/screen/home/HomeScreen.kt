package com.aliayali.weather.presenter.screen.home

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aliayali.weather.R
import com.aliayali.weather.navigation.NavigationScreen
import com.aliayali.weather.presenter.ui.CustomBottomSheetSample
import com.aliayali.weather.presenter.ui.TopBarWithTabs
import com.aliayali.weather.presenter.ui.WeatherSmallItem
import com.aliayali.weather.ui.theme.DeepIndigo
import com.aliayali.weather.ui.theme.Lavender
import com.aliayali.weather.ui.theme.MidnightBlue
import com.aliayali.weather.ui.theme.PrimaryDark


@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    var stateCustomBottomSheet by remember { mutableStateOf(false) }
    val weather by homeViewModel.currentWeather

    Box(modifier = Modifier.fillMaxSize()) {

        // image back
        Image(
            painter = painterResource(id = R.drawable.image_back),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // top box -> weather
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = weather?.name ?: "Loading...",
                    color = PrimaryDark,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = weather?.main?.temp?.toInt()?.toString()?.plus("°") ?: "--",
                    color = PrimaryDark,
                    fontSize = 100.sp,
                    fontWeight = FontWeight.W300,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = weather?.weather?.getOrNull(0)?.description?.replaceFirstChar { it.uppercase() }
                        ?: "**",
                    color = Lavender,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "H:${weather?.main?.temp_max?.toInt() ?: "--"}°   L:${weather?.main?.temp_min?.toInt() ?: "**"}°",
                    color = PrimaryDark,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(R.drawable.house),
                    contentDescription = "house",
                    modifier = Modifier.padding(top = 50.dp)
                )
            }
        }

        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(MidnightBlue, DeepIndigo)
                        ),
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
                    .align(Alignment.BottomCenter)
            ) {

                TopBarWithTabs(
                    selectedTabIndex,
                    onTabSelected = { selectedTabIndex = it }
                )

                when (selectedTabIndex) {
                    0 -> {

                        LazyRow(
                            modifier = Modifier
                                .padding(top = 60.dp)
                                .height(280.dp)
                        ) {
                            items(10) {
                                WeatherSmallItem()
                            }
                        }

                    }

                    1 -> {

                        LazyRow(
                            modifier = Modifier
                                .padding(top = 60.dp)
                                .height(280.dp)
                        ) {
                            items(10) {
                                WeatherSmallItem()
                            }
                        }

                    }
                }

            }

            Image(
                painter = painterResource(R.drawable.bottom_back),
                contentDescription = null,
                modifier = Modifier.align(Alignment.BottomCenter)
            )

            Image(
                painter = painterResource(R.drawable.subtract),
                contentDescription = "subtract",
                modifier = Modifier.align(Alignment.BottomCenter)
            )

            Image(
                painter = painterResource(R.drawable.add),
                contentDescription = "add",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.BottomCenter)
                    .clickable {
                        stateCustomBottomSheet = true
                    }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 16.dp)
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.left),
                    contentDescription = "left",
                    modifier = Modifier
                        .size(60.dp)
                        .clickable {
                            navController.navigate(NavigationScreen.WeatherCitiesScreen.route)
                        }
                )
                Image(
                    painter = painterResource(R.drawable.right),
                    contentDescription = "right",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(end = 15.dp)
                        .clickable {
                            navController.navigate(NavigationScreen.CityScreen.route)
                        }
                )
            }

        }
    }

    CustomBottomSheetSample(stateCustomBottomSheet) {
        stateCustomBottomSheet = it
    }
}


