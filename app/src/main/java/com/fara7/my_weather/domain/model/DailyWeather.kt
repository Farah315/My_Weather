package com.fara7.my_weather.domain.model

data class DailyWeather(
    val maxTemperature: Int,
    val minTemperature: Int,
    val dayOfWeek: String,
    val weatherType: WeatherType
)
