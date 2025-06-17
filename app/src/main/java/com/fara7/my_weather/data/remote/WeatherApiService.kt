package com.fara7.my_weather.data.remote

import com.fara7.my_weather.data.remote.dto.WeatherResponse

interface WeatherApiService {
    suspend fun getWeather(latitude: Double, longitude: Double): Result<WeatherResponse>
}