package com.fara7.my_weather.di

import android.app.Activity
import android.content.Context
import com.fara7.my_weather.data.remote.GeocoderLocationServiceImplementation
import com.fara7.my_weather.data.remote.KtorWeatherApiImplementation
import com.fara7.my_weather.data.remote.LocationService
import com.fara7.my_weather.data.remote.WeatherApiService
import com.fara7.my_weather.data.repository.WeatherRepositoryImplementation
import com.fara7.my_weather.domain.repository.WeatherRepository
import com.fara7.my_weather.presentation.ui.screens.home.HomeViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single<HttpClient> { HttpClient(CIO) }
    single<WeatherApiService> { KtorWeatherApiImplementation(get()) }
    single<WeatherRepository> { WeatherRepositoryImplementation(get()) }
    single { HomeViewModel(get()) }

    single<Context> { androidContext() as Activity }
    single<LocationService> { GeocoderLocationServiceImplementation(get()) }
}