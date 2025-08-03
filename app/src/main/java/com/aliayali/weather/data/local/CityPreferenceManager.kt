package com.aliayali.weather.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class CityPreferenceManager @Inject constructor(
    @ApplicationContext context: Context
) {

    private val dataStore = context.dataStore
    private val CITY_KEY = stringPreferencesKey("selected_city")

    val selectedCity: Flow<String?> = dataStore.data
        .map { preferences ->
            preferences[CITY_KEY]
        }

    suspend fun saveCity(city: String) {
        dataStore.edit { preferences ->
            preferences[CITY_KEY] = city
        }
    }
}