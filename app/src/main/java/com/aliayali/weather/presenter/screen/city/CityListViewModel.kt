package com.aliayali.weather.presenter.screen.city

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliayali.weather.data.local.CityPreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityListViewModel @Inject constructor(
    private val cityPreferenceManager: CityPreferenceManager,
) : ViewModel() {

    private val _cities = listOf(
        "Tehran", "Mashhad", "Isfahan", "Tabriz", "Shiraz",
        "Karaj", "Qom", "Kermanshah", "Ahvaz", "Rasht",
        "Zahedan", "Hamadan", "Yazd", "Ardabil", "Bandar Abbas",
        "Arak", "Kerman", "Sanandaj", "Urmia", "Qazvin",
        "Zanjan", "Birjand", "Khorramabad", "Gorgan", "Sari",
        "Khoy", "Bojnurd", "Dezful", "Sabzevar", "Neyshabur",
        "Sahneh", "Malayer", "Borujerd", "Kashan",
        "Babol", "Mahabad", "Saqqez"
    )

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    val filteredCities: StateFlow<List<String>> = _searchQuery
        .map { query ->
            if (query.isEmpty()) _cities
            else _cities.filter { it.contains(query, ignoreCase = true) }
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, _cities)

    private val _selectedCity = MutableStateFlow<String?>(null)
    val selectedCity: StateFlow<String?> = _selectedCity

    init {
        viewModelScope.launch {
            cityPreferenceManager.selectedCity.collect {
                _selectedCity.value = it
            }
        }
    }

    fun selectCity(city: String) {
        viewModelScope.launch {
            cityPreferenceManager.saveCity(city)
        }
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
}
