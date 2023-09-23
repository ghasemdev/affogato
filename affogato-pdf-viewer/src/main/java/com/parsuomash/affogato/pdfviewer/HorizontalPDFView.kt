package com.parsuomash.affogato.pdfviewer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.util.FitPolicy
import com.parsuomash.affogato.pdfviewer.state.HorizontalPdfReaderState
import com.parsuomash.affogato.pdfviewer.state.ResourceType
import com.parsuomash.affogato.pdfviewer.zoomable.ZoomableDefaults
import com.parsuomash.affogato.pdfviewer.zoomable.ZoomableState
import com.parsuomash.affogato.pdfviewer.zoomable.rememberZoomableState

@Composable
fun HorizontalPDFView(
  modifier: Modifier = Modifier,
  state: HorizontalPdfReaderState,
  zoomableState: ZoomableState = rememberZoomableState(
    minScale = ZoomableDefaults.DefaultScale
  )
) {
  var currentPage by rememberSaveable { mutableIntStateOf(0) }
  var isDefaultPageLoaded by rememberSaveable { mutableStateOf(false) }

  AndroidView(
    modifier = modifier,
    factory = {
      PDFView(it, null)
    },
    update = { pdfView ->
      pdfView.apply {
        when (state.resource) {
          is ResourceType.Asset -> TODO()
          is ResourceType.Base64 -> TODO()
          is ResourceType.Local -> pdfView.fromUri(state.resource.uri)
          is ResourceType.Remote -> TODO()
        }.apply {
          minZoom = zoomableState.minScale
          midZoom = zoomableState.doubleTapScale
          maxZoom = zoomableState.maxScale
          pageFitPolicy(FitPolicy.WIDTH)
          useBestQuality(true)

          swipeHorizontal(true)
          pageSnap(true)
          autoSpacing(true)
          pageFling(true)

          if (isDefaultPageLoaded.not()) {
            defaultPage(currentPage)
            isDefaultPageLoaded = true
          }
        }.load()
      }
    },
    onRelease = { pdfView ->
      currentPage = pdfView.currentPage
      isDefaultPageLoaded = false
    }
  )
}
