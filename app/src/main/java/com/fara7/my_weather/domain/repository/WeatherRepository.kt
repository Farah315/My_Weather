package com.fara7.my_weather.domain.repository

import com.fara7.my_weather.domain.model.Weather

interface WeatherRepository {
    suspend fun getWeather(latitude: Double, longitude: Double): Result<Weather>

}