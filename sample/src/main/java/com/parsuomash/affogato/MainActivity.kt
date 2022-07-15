package com.parsuomash.affogato

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.parsuomash.affogato.ui.theme.AffogatoTheme
import com.parsuomash.affogato.unit.Dimen
import com.parsuomash.affogato.unit.sdp
import com.parsuomash.affogato.unit.ssp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffogatoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        dimen.buttonFontSize
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Black)
        )
        Box(
            modifier = Modifier
                .size(40.sdp)
                .background(Color.Red)
        )
        Text(text = "Hello $name!", fontSize = 20.sp)
        Text(text = "Hello $name!", fontSize = 20.ssp)
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5)
@Preview(showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun DefaultPreview() {
    AffogatoTheme {
        Greeting("Android")
    }
}

@Dimen(type = "dp", values = ["320:24", "480:26", "600:28", "720:30"])
val topPadding = 24.dp

@Dimen(type = "sp", values = ["320=24", "480=26", "600=28", "720=30"])
val buttonFontSize = 24.sp

@Dimen(type = "dp", values = ["320=24", "480=26", "600=28", "720=30"])
val x = 10.dp
