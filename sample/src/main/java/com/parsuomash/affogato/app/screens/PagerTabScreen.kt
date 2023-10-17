package com.parsuomash.affogato.app.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.parsuomash.affogato.pager.indicator.DraggableTabRow
import com.parsuomash.affogato.pager.indicator.Tab
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerTabScreen() {
  val coroutineScope = rememberCoroutineScope()
  val pagerState = rememberPagerState { 3 }
  val tabItems = listOf("سایر", "گواهی‌های معتبر", "امضای فایل")

  Surface(
    modifier = Modifier.fillMaxSize(),
    color = Color(0xFF152132)
  ) {
    Column(modifier = Modifier.padding(28.dp)) {
      DraggableTabRow(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xFF21354F),
        indicatorColor = Color(0xFF40BED0),
        state = pagerState
      ) {
        tabItems.mapIndexed { index, text ->
          Tab(
            selected = index == pagerState.currentPage,
            text = { Text(text = text) },
            onClick = {
              coroutineScope.launch {
                pagerState.animateScrollToPage(index)
              }
            }
          )
        }
      }

      HorizontalPager(state = pagerState) {
        Box(
          modifier = Modifier.fillMaxSize(),
          contentAlignment = Alignment.Center
        ) {
          Text(
            modifier = Modifier.align(Alignment.Center),
            text = tabItems[it],
            color = Color.White
          )
        }
      }
    }
  }
}
