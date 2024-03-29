package com.parsuomash.affogato.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.parsuomash.affogato.R
import com.parsuomash.affogato.app.dimen
import com.parsuomash.affogato.app.ui.theme.AffogatoTheme
import com.parsuomash.affogato.unit.Dimen
import com.parsuomash.affogato.unit.window.WindowSize
import com.parsuomash.affogato.unit.window.WindowType
import com.parsuomash.affogato.unit.window.isLandscape
import com.parsuomash.affogato.unit.window.rememberWindowSize

@Composable
fun DimenScreen(window: WindowSize) {
  val configuration = LocalConfiguration.current
  val isLandscape = configuration.isLandscape

  val text by remember(window) {
    mutableStateOf(
      when (if (isLandscape) window.height else window.width) {
        is WindowType.Compact -> "Compact"
        is WindowType.Medium -> "Medium"
        is WindowType.Expanded -> "Expanded"
      }
    )
  }
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(dimen.padding),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Text(text = text)
    Spacer(modifier = Modifier.height(dimen.space))

    Image(
      painter = painterResource(id = R.drawable.affogato),
      modifier = Modifier.size(dimen.icon),
      contentDescription = null
    )
    Spacer(modifier = Modifier.height(dimen.space))

    Text(
      text = stringResource(id = R.string.lorem),
      textAlign = TextAlign.Justify,
      fontSize = dimen.fontSize
    )
    Spacer(modifier = Modifier.height(dimen.space))

    Button(
      modifier = Modifier
        .fillMaxWidth()
        .height(dimen.heightButton),
      onClick = { }
    ) {
      Text(
        text = stringResource(id = R.string.app_name).uppercase(),
        fontSize = dimen.fontSize
      )
    }
  }
}

@Preview(name = "NEXUS_5", showBackground = true, device = Devices.NEXUS_5)
@Preview(name = "PIXEL_4_XL", showBackground = true, device = Devices.PIXEL_4_XL)
@Preview(name = "PIXEL_C", showBackground = true, device = Devices.PIXEL_C)
@Composable
fun DefaultPreview() {
  val window = rememberWindowSize()
  AffogatoTheme {
    DimenScreen(window)
  }
}

@Dimen(type = "dp", values = ["320:70", "480:80", "600:180", "720:180"])
val icon = 80.dp

@Dimen(type = "dp", values = ["320:14", "480:16", "600:18", "720:20"])
val padding = 16.dp

@Dimen(type = "dp", values = ["320:26", "480:32", "600:34", "720:36"])
val space = 32.dp

@Dimen(type = "dp", values = ["320:50", "480:50", "600:70", "720:80"])
val heightButton = 48.dp

@Dimen(type = "sp", values = ["320:14", "480:20", "600:30", "720:32"])
val fontSize = 16.sp
