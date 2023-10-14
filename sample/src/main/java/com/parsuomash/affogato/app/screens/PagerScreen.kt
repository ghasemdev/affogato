package com.parsuomash.affogato.app.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.parsuomash.affogato.app.composable.HorizontalPagerIndicator

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerScreen() {
  val pagerState = rememberPagerState { 10 }

  Column {
    Box {
      HorizontalPager(state = pagerState) {
        Surface(
          modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.5f),
          color = Color.LightGray
        ) {
          Box {
            Text(
              modifier = Modifier.align(Alignment.Center),
              text = "Page $it"
            )
          }
        }
      }

      HorizontalPagerIndicator(
        pagerState = pagerState,
        modifier = Modifier
          .align(Alignment.BottomCenter)
          .padding(bottom = 8.dp)
      )
    }
  }
}
