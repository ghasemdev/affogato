package com.parsuomash.affogato.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.parsuomash.affogato.app.screens.PagerScreen
import com.parsuomash.affogato.app.ui.theme.AffogatoTheme
import com.parsuomash.affogato.unit.window.rememberWindowSize

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AffogatoTheme {
        val window = rememberWindowSize()
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colors.background
        ) {
          PagerScreen()
        }
      }
    }
  }
}
