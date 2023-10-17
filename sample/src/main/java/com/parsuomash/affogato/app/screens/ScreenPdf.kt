package com.parsuomash.affogato.app.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.parsuomash.affogato.pdfviewer.VerticalPDFView

@Composable
fun ScreenPdf() {
  var pdfUri: Uri by rememberSaveable { mutableStateOf(Uri.EMPTY) }
  val pickPDFLauncher = rememberLauncherForActivityResult(
    ActivityResultContracts.GetContent()
  ) { uri ->
    if (uri != null) {
      pdfUri = uri
    }
  }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Button(
      modifier = Modifier
        .fillMaxWidth()
        .height(50.dp),
      onClick = { pickPDFLauncher.launch("application/pdf") }
    ) {
      Text(text = "Select file")
    }

    Spacer(modifier = Modifier.height(8.dp))

    AnimatedVisibility(
      modifier = Modifier.fillMaxSize(),
      visible = pdfUri != Uri.EMPTY,
      enter = fadeIn(),
      exit = fadeOut()
    ) {
      VerticalPDFView(
        modifier = Modifier.fillMaxSize(),
        uri = pdfUri
      )
    }
  }
}
