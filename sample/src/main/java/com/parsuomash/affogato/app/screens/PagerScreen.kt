package com.parsuomash.affogato.app.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.parsuomash.affogato.pager.indicator.HorizontalPagerIndicator
import com.parsuomash.affogato.pager.indicator.VerticalPagerIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerScreen() {
  val coroutineScope = rememberCoroutineScope()
  val horizontalPagerState = rememberPagerState { 10 }
  val verticalPagerState = rememberPagerState { 10 }

  Column {
    Box {
      HorizontalPager(state = horizontalPagerState) {
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
        pagerState = horizontalPagerState,
        modifier = Modifier
          .align(Alignment.BottomCenter)
          .padding(bottom = 8.dp),
        onIndicatorClick = { page ->
          coroutineScope.launch {
            horizontalPagerState.animateScrollToPage(page)
          }
        }
      )
    }

    Spacer(modifier = Modifier.height(8.dp))

    Box {
      VerticalPager(state = verticalPagerState) {
        Surface(
          modifier = Modifier.fillMaxSize(),
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

      VerticalPagerIndicator(
        pagerState = verticalPagerState,
        modifier = Modifier
          .align(Alignment.CenterStart)
          .padding(start = 8.dp),
        onIndicatorClick = { page ->
          coroutineScope.launch {
            verticalPagerState.animateScrollToPage(page)
          }
        }
      )
    }
  }
}
