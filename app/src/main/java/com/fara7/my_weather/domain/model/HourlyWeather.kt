package com.fara7.my_weather.domain.model

data class HourlyWeather(
    val temperature: Int,
    val time: String,
    val weatherType: WeatherType
)
