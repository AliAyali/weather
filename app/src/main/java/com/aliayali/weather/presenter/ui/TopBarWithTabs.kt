package com.aliayali.weather.presenter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aliayali.weather.ui.theme.Lavender
import com.aliayali.weather.ui.theme.TertiaryDark

@Composable
fun TopBarWithTabs(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    navController: NavController,
) {
    val tabs = listOf(
        "Hourly Forecast",
        "Weekly Forecast"
    )

    Row(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 8.dp)
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .padding(horizontal = 10.dp)
                        .height(3.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(Color.Transparent, Lavender, Color.Transparent)
                            ),
                            shape = RoundedCornerShape(50)
                        )
                )
            },
            divider = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(TertiaryDark),
                )
            },
            containerColor = Color.Transparent
        ) {
            tabs.forEachIndexed { index, text ->
                val isSelected = selectedTabIndex == index
                Tab(
                    modifier = Modifier.background(Color.Transparent),
                    selected = isSelected,
                    onClick = { onTabSelected(index) },
                    icon = {
                        Text(
                            text = text,
                            color = Lavender
                        )
                    }
                )
            }
        }
    }
}