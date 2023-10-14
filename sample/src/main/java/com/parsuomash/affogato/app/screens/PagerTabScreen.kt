package com.parsuomash.affogato.app.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.parsuomash.affogato.pager.indicator.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerTabScreen() {
  val coroutineScope = rememberCoroutineScope()
  val pagerState = rememberPagerState { 5 }

  Column {
    TabRow(
      // Our selected tab is our current page
      selectedTabIndex = pagerState.currentPage,
      // Override the indicator, using the provided pagerTabIndicatorOffset modifier
      indicator = { tabPositions ->
        TabRowDefaults.Indicator(
          Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
        )
      }
    ) {
      // Add tabs for all of our pages
      repeat(pagerState.pageCount) { page ->
        Tab(
          text = { Text("p$page") },
          selected = pagerState.currentPage == page,
          onClick = {
            coroutineScope.launch {
              pagerState.animateScrollToPage(page)
            }
          },
        )
      }
    }

    HorizontalPager(state = pagerState) {
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
  }
}
