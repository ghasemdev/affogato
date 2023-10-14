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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.parsuomash.affogato.R
import com.parsuomash.affogato.unit.sdp
import com.parsuomash.affogato.unit.ssp

@Composable
fun SdpScreen() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.sdp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Image(
      painter = painterResource(id = R.drawable.affogato),
      modifier = Modifier.size(80.sdp),
      contentDescription = null
    )
    Spacer(modifier = Modifier.height(32.sdp))

    Text(
      text = stringResource(id = R.string.lorem),
      textAlign = TextAlign.Justify,
      fontSize = 16.ssp
    )
    Spacer(modifier = Modifier.height(32.sdp))

    Button(
      modifier = Modifier
        .fillMaxWidth()
        .height(48.sdp),
      onClick = { }
    ) {
      Text(text = stringResource(id = R.string.app_name).uppercase(), fontSize = 16.ssp)
    }
  }
}
