package com.aliayali.weather.presenter.screen.city

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aliayali.weather.presenter.ui.CityItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityListScreen(
    viewModel: CityListViewModel = hiltViewModel(),
    onCitySelected: (String) -> Unit,
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val cities by viewModel.filteredCities.collectAsState()
    val selectedCity by viewModel.selectedCity.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Select City") })
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { viewModel.updateSearchQuery(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                label = { Text("Search city") },
                singleLine = true,
                trailingIcon = {
                    Icon(
                        Icons.Default.Search, null
                    )
                }
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(cities) { city ->
                    val isSelected = city == selectedCity
                    CityItem(cityName = city, isSelected = isSelected) {
                        viewModel.selectCity(city)
                        onCitySelected(city)
                    }
                }
            }
        }
    }
}
