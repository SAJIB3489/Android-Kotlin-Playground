package mobile.technology.l8_ex1

import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// 1. Data Model
data class WeatherResponse(val main: Main)
data class Main(val temp: Float, val humidity: Int)

// 2. Retrofit API Interface
interface WeatherApiService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherResponse
}

// 3. Retrofit Instance
object RetrofitInstance {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    val api: WeatherApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
    }
}

// 4. ViewModel (Stores List of Cities & Weather)
class WeatherViewModel : ViewModel() {
    private val _weatherList = mutableStateListOf<Pair<String, String>>() // City -> Weather
    val weatherList: List<Pair<String, String>> get() = _weatherList

    fun fetchWeather(city: String, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getWeather(city, apiKey)
                val weatherText = "Temp: ${response.main.temp}°C | Humidity: ${response.main.humidity}%"
                _weatherList.add(city to weatherText)
            } catch (e: Exception) {
                _weatherList.add(city to "Oops! Failed to fetch weather.")
            }
        }
    }
}

// 5. Main Activity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { WeatherScreen() }
    }
}

// 6. Jetpack Compose UI
@Composable
fun WeatherScreen(viewModel: WeatherViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    var city by remember { mutableStateOf("") }
    val apiKey = "43651117abddfbe5490d0f82aae86231"  // My API key
    val weatherList by remember { derivedStateOf { viewModel.weatherList } }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Enter city") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { if (city.isNotBlank()) viewModel.fetchWeather(city, apiKey) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("ADD")
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(weatherList) { (cityName, weatherData) ->
                WeatherCard(cityName, weatherData)
            }
        }
    }
}

// 7. WeatherCard Composable
@Composable
fun WeatherCard(city: String, weatherData: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFBBDEFB)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = city, style = MaterialTheme.typography.headlineSmall, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = weatherData, style = MaterialTheme.typography.bodyLarge, color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherScreen()
}
