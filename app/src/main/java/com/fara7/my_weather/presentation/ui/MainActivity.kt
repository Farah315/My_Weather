package com.fara7.my_weather.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.fara7.my_weather.data.remote.GeocoderLocationServiceImplementation
import com.fara7.my_weather.data.remote.LocationService
import com.fara7.my_weather.presentation.ui.screens.home.HomeScreen
import com.fara7.my_weather.presentation.ui.screens.home.HomeViewModel
import com.fara7.my_weather.presentation.ui.theme.My_WeatherTheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.koin.androidx.compose.get

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /*       Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Red
            ) {
                Text("هل يظهر هذا النص؟", color = Color.White)
            }
        }*/
            val context = LocalContext.current
            val fusedLocationClient = remember {
                LocationServices.getFusedLocationProviderClient(context)
            }
            val locationService: LocationService = remember {
                GeocoderLocationServiceImplementation(context)
            }

            My_WeatherTheme(dynamicColor = false) {
                HomeScreen(
                    fusedLocationClient = fusedLocationClient,
                    locationService = locationService,
                    viewModel = get<HomeViewModel>()
                )
            }
        }
    }

}