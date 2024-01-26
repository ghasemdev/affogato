@file:Suppress("unused")

package com.parsuomash.affogato.pdfviewer.state

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.core.net.toUri

@OptIn(ExperimentalFoundationApi::class)
class HorizontalPdfReaderState(
  resource: ResourceType,
  isZoomEnable: Boolean = false,
  isAccessibleEnable: Boolean = false,
  initialPage: Int = 0,
  initialPageOffsetFraction: Float = 0f
) : PdfReaderState(resource, isZoomEnable, isAccessibleEnable) {
  var pagerState: PagerState = PagerStateImpl(
    initialPage = initialPage,
    initialPageOffsetFraction = initialPageOffsetFraction,
  ) { pdfPageCount }

  override val currentPage: Int
    get() = pagerState.currentPage

  override val isScrolling: Boolean
    get() = pagerState.isScrollInProgress

  companion object {
    val Saver: Saver<HorizontalPdfReaderState, *> = listSaver(
      save = {
        val resource = it.file?.let { file ->
          ResourceType.Local(
            file.toUri()
          )
        } ?: it.resource
        listOf(
          resource,
          it.isZoomEnable,
          it.isAccessibleEnable,
          it.pagerState.currentPage,
          it.pagerState.currentPageOffsetFraction
        )
      },
      restore = {
        HorizontalPdfReaderState(
          it[0] as ResourceType,
          it[1] as Boolean,
          it[2] as Boolean,
          it[3] as Int,
          it[4] as Float
        )
      }
    )
  }
}

@OptIn(ExperimentalFoundationApi::class)
internal class PagerStateImpl(
  initialPage: Int,
  initialPageOffsetFraction: Float,
  updatedPageCount: () -> Int
) : PagerState(initialPage, initialPageOffsetFraction) {
  private var pageCountState = mutableStateOf(updatedPageCount)
  override val pageCount: Int get() = pageCountState.value.invoke()
}

@Composable
fun rememberHorizontalPdfReaderState(
  resource: ResourceType,
  initialPage: Int = 0,
  initialPageOffsetFraction: Float = 0f,
  isZoomEnable: Boolean = true,
  isAccessibleEnable: Boolean = false
): HorizontalPdfReaderState {
  return rememberSaveable(resource, saver = HorizontalPdfReaderState.Saver) {
    HorizontalPdfReaderState(
      resource = resource,
      isZoomEnable = isZoomEnable,
      isAccessibleEnable = isAccessibleEnable,
      initialPage = initialPage,
      initialPageOffsetFraction = initialPageOffsetFraction
    )
  }
}
