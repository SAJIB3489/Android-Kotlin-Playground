package mobile.technology.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colorScheme = customColorScheme
            ) {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    var counterList by remember { mutableStateOf(
                        mutableListOf(
                            R.drawable.dingo,
                            R.drawable.panther,
                            R.drawable.rosbot3,
                            R.drawable.unitree
                        )
                    )}
                    LazyColumn(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                    ) {
                        itemsIndexed(counterList) { index, image ->
                            Counter(
                                counterName = "Robot_${index + 1}",
                                imageRes = image,
                                onDelete = {
                                    counterList = counterList.toMutableList().apply { removeAt(index) }
                                }
                            )
                        }
                    }
                }}
        }
    }
}
@Composable
fun Counter(counterName: String, imageRes: Int, onDelete: () -> Unit) {
    var count by remember { mutableStateOf("0") }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
// Robot by name
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Product Image",
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 8.dp)
        )
        Text(
            text = counterName,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(top = 8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    val currentValue = count.toIntOrNull() ?: 0
                    count = (currentValue - 1).toString()
                },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor =
                MaterialTheme.colorScheme.secondary)
            ) {
                Text("-", fontSize = 20.sp)
            }
            TextField(
                value = count,
                onValueChange = { input ->
                    if (input.all { it.isDigit() || it == '-' }) {
                        count = input
                    }
                },
                modifier = Modifier
                    .width(80.dp)
                    .heightIn(min = 40.dp, max = 50.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary
                )
            )
            Button(
                onClick = {val currentValue = count.toIntOrNull() ?: 0
                    count = (currentValue + 1).toString()
                },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor =
                MaterialTheme.colorScheme.secondary)
            ) {
                Text("+", fontSize = 20.sp)
            }
        }
// Delete button is here
        IconButton(onClick = onDelete) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = Color.Red
            )
        }
    }
}
// I added the color of the button
private val customColorScheme = lightColorScheme(
    primary = Color(0xFF080012),
    secondary = Color(0xFF03DAC5),
    background = Color(0xFFF5F5F5),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black
)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme(colorScheme = customColorScheme) {
        var counterList by remember { mutableStateOf(
            mutableListOf(
                R.drawable.dingo,
                R.drawable.panther,
                R.drawable.rosbot3,
                R.drawable.unitree
            )
        )}
        LazyColumn {
            itemsIndexed(counterList) { index, image ->
                Counter(
                    counterName = "Robot_${index + 1}",
                    imageRes = image,
                    onDelete = {
                        counterList = counterList.toMutableList().apply { removeAt(index) }
                    }
                )
            }
        }
    }
}