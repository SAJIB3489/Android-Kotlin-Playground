package mobile.technology.simplee_commerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mobile.technology.simplee_commerceapp.ui.theme.SimpleEcommerceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleEcommerceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.finnma_logo),
            contentDescription = "Finnma Logo",
            modifier = Modifier
                .size(120.dp)
                .padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            ProductRow(
                product1 = Pair(R.drawable.rosbot3, "ROSbot 3"),
                product2 = Pair(R.drawable.panther, "Panther")
            )
            ProductRow(
                product1 = Pair(R.drawable.dingo, "Dingo 1.5"),
                product2 = Pair(R.drawable.unitree, "Unitree Go1")
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        ContactUsSection()
    }
}

@Composable
fun ProductRow(product1: Pair<Int, String>, product2: Pair<Int, String>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ProductItem(product1.first, product1.second)
        ProductItem(product2.first, product2.second)
    }
}

@Composable
fun ProductItem(imageRes: Int, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 4.dp)
        )
        Button(
            onClick = { /* TODO: Handle add to cart */ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            modifier = Modifier.padding(top = 4.dp)
        ) {
            Text(text = "Add to cart", color = Color.White, fontSize = 14.sp)
        }
    }
}

@Composable
fun ContactUsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Contact Us",
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = "Microkatu 1, 70201, Kuopio, Finland",
            fontSize = 14.sp,
            color = Color.Black
        )
        Text(
            text = "Email: Md.Sajib.Pramanic@edu.savonia.fi",
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    SimpleEcommerceAppTheme {
        MainScreen()
    }
}