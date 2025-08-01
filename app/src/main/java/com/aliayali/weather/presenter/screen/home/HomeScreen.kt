package com.aliayali.weather.presenter.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aliayali.weather.R
import com.aliayali.weather.ui.theme.Lavender
import com.aliayali.weather.ui.theme.PrimaryDark


@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {

    Image(
        painter = painterResource(id = R.drawable.image_back),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Montreal",
                    color = PrimaryDark,
                    fontSize = 30.sp
                )
                Text(
                    text = "19°",
                    color = PrimaryDark,
                    fontSize = 100.sp,
                    fontWeight = FontWeight.W300
                )
                Text(
                    text = "Mostly Clear",
                    color = Lavender,
                    fontSize = 20.sp
                )

                Text(
                    text = "H:24°   L:18°",
                    color = PrimaryDark,
                    fontSize = 20.sp
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(R.drawable.house),
                contentDescription = "house"
            )


            Box(modifier = Modifier.fillMaxSize()) {

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
                        modifier = Modifier.size(60.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.right),
                        contentDescription = "right",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(end = 15.dp)
                    )
                }

            }
        }
    }
}


