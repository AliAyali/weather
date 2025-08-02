package com.aliayali.weather.data.fakeData

import com.aliayali.weather.R

data class Weather(
    val id: Int,
    val image: Int,
    val degree: String,
    val text: String,
    val city: String,
    val rain: String,
) {
    companion object {
        val weather = listOf(
            Weather(
                1,
                R.drawable.sun_cloud_angled_rain,
                "19°",
                "H:24° L:18°",
                "Montreal, Canada",
                "Mid Rain"
            ),
            Weather(
                2,
                R.drawable.moon_cloud_mid_rain,
                "28°",
                "H:31° L:25°",
                "Dubai, UAE",
                "Heavy Rain"
            ),
            Weather(
                3,
                R.drawable.sun_cloud_mid_rain,
                "35°",
                "H:38° L:29°",
                "Cairo, Egypt",
                "Sunny"
            ),
            Weather(
                4,
                R.drawable.tornado,
                "12°",
                "H:14° L:8°",
                "Berlin, Germany",
                "Cloudy"
            ),
            Weather(
                5,
                R.drawable.moon_cloud_fast_wind,
                "7°",
                "H:10° L:4°",
                "Oslo, Norway",
                "Light Rain"
            )
        )
    }

}
