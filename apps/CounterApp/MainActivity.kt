package mobile.technology.myapplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                    ) {
                        Counter()
                        Counter()
                        Counter()
                    }
                }
            }
        }
    }
}
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    var initialValue by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        TextField(
            value = initialValue,
            onValueChange = {
                initialValue = it
                count = it.toIntOrNull() ?: 0},
            label = { Text("Enter initial value") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            Button(
                onClick = { count-- },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor =
                MaterialTheme.colorScheme.secondary)
            ) {
                Text("-")
            }
            Text(
                text = "$count",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(16.dp)
            )
            Button(
                onClick = { count++ },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor =
                MaterialTheme.colorScheme.secondary)
            ) {
                Text("+")
            }
        }
    }
}
// I found easy way to add the custom color
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
        Column {
            Counter()
            Counter()
            Counter()
        }
    }
}