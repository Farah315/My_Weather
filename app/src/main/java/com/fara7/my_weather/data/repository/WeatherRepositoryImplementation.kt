package com.fara7.my_weather.data.repository

import com.fara7.my_weather.data.remote.WeatherApiService
import com.fara7.my_weather.data.remote.dto.toWeather
import com.fara7.my_weather.domain.model.Weather
import com.fara7.my_weather.domain.repository.WeatherRepository

class WeatherRepositoryImplementation(
    private val weatherApiService: WeatherApiService
) : WeatherRepository {
    override suspend fun getWeather(latitude: Double, longitude: Double): Result<Weather> {
        val result = weatherApiService.getWeather(latitude,longitude)
        return result.fold(
            onSuccess =  {
                Result.success(it.toWeather())
            },
            onFailure = {
                Result.failure<Weather>(it)
            }
        )
    }
}