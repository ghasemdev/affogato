@file:Suppress("unused")

package com.parsuomash.affogato.pdfviewer

import android.net.Uri
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
import com.parsuomash.affogato.pdfviewer.zoomable.ZoomableDefaults
import com.parsuomash.affogato.pdfviewer.zoomable.ZoomableState
import com.parsuomash.affogato.pdfviewer.zoomable.rememberZoomableState
import java.io.File
import java.io.InputStream

@Composable
fun VerticalPDFView(
  modifier: Modifier = Modifier,
  uri: Uri,
  zoomableState: ZoomableState = rememberZoomableState(
    minScale = ZoomableDefaults.DefaultScale
  )
) {
  VerticalPDFViewImpl(modifier = modifier, zoomableState = zoomableState) {
    it.fromUri(uri)
  }
}

@Composable
fun VerticalPDFView(
  modifier: Modifier = Modifier,
  file: File,
  zoomableState: ZoomableState = rememberZoomableState(
    minScale = ZoomableDefaults.DefaultScale
  )
) {
  VerticalPDFViewImpl(modifier = modifier, zoomableState = zoomableState) {
    it.fromFile(file)
  }
}

@Composable
fun VerticalPDFView(
  modifier: Modifier = Modifier,
  assetName: String,
  zoomableState: ZoomableState = rememberZoomableState(
    minScale = ZoomableDefaults.DefaultScale
  )
) {
  VerticalPDFViewImpl(modifier = modifier, zoomableState = zoomableState) {
    it.fromAsset(assetName)
  }
}

@Composable
fun VerticalPDFView(
  modifier: Modifier = Modifier,
  bytes: ByteArray,
  zoomableState: ZoomableState = rememberZoomableState(
    minScale = ZoomableDefaults.DefaultScale
  )
) {
  VerticalPDFViewImpl(modifier = modifier, zoomableState = zoomableState) {
    it.fromBytes(bytes)
  }
}

@Composable
fun VerticalPDFView(
  modifier: Modifier = Modifier,
  stream: InputStream,
  zoomableState: ZoomableState = rememberZoomableState(
    minScale = ZoomableDefaults.DefaultScale
  )
) {
  VerticalPDFViewImpl(modifier = modifier, zoomableState = zoomableState) {
    it.fromStream(stream)
  }
}

@Composable
private fun VerticalPDFViewImpl(
  modifier: Modifier,
  zoomableState: ZoomableState,
  configurator: (PDFView) -> PDFView.Configurator
) {
  var currentPage by rememberSaveable { mutableIntStateOf(0) }
  var isDefaultPageLoaded by rememberSaveable { mutableStateOf(false) }

  AndroidView(
    modifier = modifier,
    factory = { context ->
      PDFView(context, null).also {
        it.clipToOutline = true
      }
    },
    update = { pdfView ->
      pdfView.apply {
        configurator(pdfView).apply {
          minZoom = zoomableState.minScale
          midZoom = zoomableState.doubleTapScale
          maxZoom = zoomableState.maxScale
          pageFitPolicy(FitPolicy.WIDTH)
          useBestQuality(true)

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
